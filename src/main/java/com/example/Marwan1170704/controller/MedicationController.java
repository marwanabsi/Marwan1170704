package com.example.Marwan1170704.controller;

import com.example.Marwan1170704.model.Medication;
import com.example.Marwan1170704.serves.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationController {
    private final MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping("/{id}")
    public Medication getMedicationById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return medicationService.getMedicationById(id);
    }

    @GetMapping
    public List<Medication> getAllMedications() {
        return medicationService.getAllMedications();
    }

    @PostMapping
    public Medication createMedication(@RequestBody Medication medication) {
        return medicationService.createMedication(medication);
    }

    @PutMapping("/{id}")
    public Medication updateMedication(@PathVariable Long id, @RequestBody Medication medication) throws ChangeSetPersister.NotFoundException {
        return medicationService.updateMedication(id, medication);
    }

    @DeleteMapping("/{id}")
    public void deleteMedication(@PathVariable Long id) {
        medicationService.deleteMedication(id);
    }
}
