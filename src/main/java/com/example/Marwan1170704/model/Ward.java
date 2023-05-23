package com.example.Marwan1170704.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Ward")
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int capacity;
    private boolean availability;

}