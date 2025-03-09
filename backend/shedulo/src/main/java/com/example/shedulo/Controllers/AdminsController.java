package com.example.shedulo.Controllers;

import com.example.shedulo.Entity.Admins;
import com.example.shedulo.Services.AdminsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/admins")
public class AdminsController {
    private final AdminsService service;

    public AdminsController(AdminsService service) {
        this.service = service;
    }

    @PostMapping
    public Admins addAdmin(@RequestParam("admin") String adminJson,
                           @RequestParam("image") MultipartFile image) throws IOException {
        // Convert adminJson to Admins object using your preferred method (e.g., Jackson)
        Admins admin = new ObjectMapper().readValue(adminJson, Admins.class);

        // Convert image to byte[] and set it in the admin object
        admin.setImage(image.getBytes());

        // Save the admin with the image
        return service.addAdmin(admin);
    }

    @GetMapping
    public List<Admins> getAllAdmins() {
        return service.getAllAdmins();
    }

    @GetMapping("/categories")
    public Set<String> getAllCategories() {
        return service.getAllUniqueCategories();
    }

    @GetMapping("/authNames")
    public Set<String> getAllAuthNames() {
        return service.getAllUniqueAuthNames();
    }
}