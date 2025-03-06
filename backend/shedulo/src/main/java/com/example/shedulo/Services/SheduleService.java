package com.example.shedulo.Services;

import com.example.shedulo.Entity.Admins;
import com.example.shedulo.Entity.Shedule;
import com.example.shedulo.Entity.SheduleRequest;
import com.example.shedulo.Repositories.AdminsRepository;
import com.example.shedulo.Repositories.SheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class SheduleService {

    private final SheduleRepository sheduleRepository;
    private final AdminsRepository adminsRepository;

    // Constructor injection for repositories
    public SheduleService(SheduleRepository sheduleRepository, AdminsRepository adminsRepository) {
        this.sheduleRepository = sheduleRepository;
        this.adminsRepository = adminsRepository;
    }

    // Method to create a new schedule
    public Shedule createSchedule(SheduleRequest sheduleRequest) {
        // Get the admin by authName
        String authName = sheduleRequest.getAuthName();
        String category = sheduleRequest.getCategory();
        Admins admin = adminsRepository.findByAuthName(authName)
                .orElseThrow(() -> new RuntimeException("Admin not found with auth_name: " + authName));

        Admins categoryy = adminsRepository.findByCategory(category)
                .orElseThrow(() -> new RuntimeException("Category not found with category: " + category));


        Shedule shedule = new Shedule();
        shedule.setName(sheduleRequest.getName());
        shedule.setAge(sheduleRequest.getAge());
        shedule.setPriorityLevel(sheduleRequest.getPriorityLevel());
        shedule.setDate(LocalDate.parse(sheduleRequest.getDate()));
        shedule.setTime(LocalTime.parse(sheduleRequest.getTime()));
        shedule.setReason(sheduleRequest.getReason());
        shedule.setCategory(categoryy);
        shedule.setAdmin(admin);  // Set the admin

        // Save the new schedule
        return sheduleRepository.save(shedule);
    }


    // Method to get all schedules
    public List<Shedule> getAllSchedules() {
        return sheduleRepository.findAll();
    }
}
