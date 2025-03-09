package com.example.shedulo.Controllers;

import com.example.shedulo.Entity.Admins;
import com.example.shedulo.Services.AdminsService;
import org.springframework.web.bind.annotation.*;
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
    public Admins addAdmin(@RequestBody Admins admin) {
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