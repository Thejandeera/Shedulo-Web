package com.example.shedulo.Repositories;

import com.example.shedulo.Entity.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminsRepository extends JpaRepository<Admins, Long> {
    Optional<Admins> findByAuthName(String authName);
}

