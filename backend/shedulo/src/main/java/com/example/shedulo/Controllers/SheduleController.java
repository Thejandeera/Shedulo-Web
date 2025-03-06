package com.example.shedulo.Controllers;

import com.example.shedulo.Entity.Shedule;
import com.example.shedulo.Entity.SheduleRequest;
import com.example.shedulo.Services.SheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shedule")
public class SheduleController {

    private final SheduleService service;

    public SheduleController(SheduleService service) {
        this.service = service;
    }

    // Endpoint to create a new schedule
    @PostMapping
    public ResponseEntity<Shedule> createShedule(@RequestBody SheduleRequest sheduleRequest) {
        Shedule createdShedule = service.createSchedule(sheduleRequest);
        return new ResponseEntity<>(createdShedule, HttpStatus.CREATED); // Return status 201 (created)
    }

    // Endpoint to get all schedules
    @GetMapping
    public ResponseEntity<List<Shedule>> getAllSchedules() {
        List<Shedule> schedules = service.getAllSchedules();
        return new ResponseEntity<>(schedules, HttpStatus.OK); // Return status 200 (OK)
    }
}
