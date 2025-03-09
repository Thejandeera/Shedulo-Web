package com.example.shedulo.Services;

import com.example.shedulo.Entity.Admins;
import com.example.shedulo.Repositories.AdminsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminsService {

    private final AdminsRepository repository;

    public AdminsService(AdminsRepository repository) {
        this.repository = repository;
    }

    public Admins addAdmin(Admins admin) {
        return repository.save(admin);
    }

    public List<Admins> getAllAdmins() {
        return repository.findAll();
    }

    public Set<String> getAllUniqueCategories() {
        return repository.findAll()
                .stream()
                .map(admin -> admin.getCategory()) // Extract category
                .filter(category -> category != null && !category.isEmpty()) // Remove null/empty values
                .collect(Collectors.toSet()); // Convert to Set to ensure uniqueness
    }

    public Set<String> getAllUniqueAuthNames() {
        return repository.findAll()
                .stream()
                .map(admin -> admin.getAuthName()) // Extract authName
                .filter(authName -> authName != null && !authName.isEmpty()) // Remove null/empty values
                .collect(Collectors.toSet()); // Convert to Set to ensure uniqueness
    }
}
