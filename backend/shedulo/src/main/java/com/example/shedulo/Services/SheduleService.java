package com.example.shedulo.Services;

import com.example.shedulo.Entity.Admins;
import com.example.shedulo.Entity.Shedule;
import com.example.shedulo.Entity.SheduleRequest;
import com.example.shedulo.Repositories.AdminsRepository;
import com.example.shedulo.Repositories.SheduleRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class SheduleService {

    private final SheduleRepository sheduleRepository;
    private final AdminsRepository adminsRepository;

    // Constructor injection for repositories
    public SheduleService(SheduleRepository sheduleRepository, AdminsRepository adminsRepository) {
        this.sheduleRepository = sheduleRepository;
        this.adminsRepository = adminsRepository;
    }

    // Method to create a new schedule and associate it with the authenticated admin
    public Shedule createSchedule(SheduleRequest sheduleRequest) {
        String authName = sheduleRequest.getAuthName(); // Get authName from the request body

        Admins admin = adminsRepository.findByAuthName(authName)
                .orElseThrow(() -> new RuntimeException("Admin not found with auth_name: " + authName));

        // Convert SheduleRequest to Shedule entity
        Shedule shedule = new Shedule();
        shedule.setName(sheduleRequest.getName());
        shedule.setAge(sheduleRequest.getAge());
        shedule.setPriorityLevel(sheduleRequest.getPriorityLevel());
        shedule.setDate(LocalDate.parse(sheduleRequest.getDate()));
        shedule.setTime(LocalTime.parse(sheduleRequest.getTime()));
        shedule.setReason(sheduleRequest.getReason());

        // Set the authenticated admin to the schedule
        shedule.setAdmin(admin);

        // Save and return the schedule
        return sheduleRepository.save(shedule);
    }

    // Method to get all schedules
    public List<Shedule> getAllSchedules() {
        return sheduleRepository.findAll(); // Return all schedules from the repository
    }
}
