package com.example.Marwan1170704.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "LabTest")
public class LabTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String department;
    private String testResults;

}