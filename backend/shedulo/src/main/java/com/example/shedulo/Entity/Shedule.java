package com.example.shedulo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shedules")
@Getter
@Setter
@NoArgsConstructor
public class Shedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private int priorityLevel;
    private LocalDate date;
    private LocalTime time;
    private String reason;

    // Category can still be related to an Admin or some other entity
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category")
    private Admins category;

    // Representing the authenticated admin who created the schedule
    @ManyToOne
    @JoinColumn(name = "auth_name", referencedColumnName = "authName") // Make sure column name matches in Admins table
    private Admins authName;

    // Method to associate the authenticated admin
    public void setAdmin(Admins admin) {
        this.authName = admin;  // Associate the authenticated admin with the schedule
    }
}
