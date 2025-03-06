package com.example.shedulo.Repositories;


import com.example.shedulo.Entity.Shedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SheduleRepository extends JpaRepository<Shedule, Long> {
}
