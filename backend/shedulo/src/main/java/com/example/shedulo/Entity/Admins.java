package com.example.shedulo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admins")
@Getter
@Setter
@NoArgsConstructor
public class Admins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    @Column(unique = true)  // Ensure that authName is unique across all admins
    private String authName;  // This should be the unique identifier for the admin

    private String specialization;
    private String institute;
    private String availability;
}
