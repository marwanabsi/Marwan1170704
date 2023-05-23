package com.example.Marwan1170704.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Nurse")
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String contactDetails;
    private String qualifications;
    private String shiftTimings;
}
