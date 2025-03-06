package com.example.shedulo.Services;

import com.example.shedulo.Entity.Admins;
import com.example.shedulo.Repositories.AdminsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
