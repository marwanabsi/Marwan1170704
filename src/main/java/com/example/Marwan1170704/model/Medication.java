package com.example.Marwan1170704.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String dosage;
    private String instructions;
    private int stockAvailability;
    private LocalDate expirationDate;

}
