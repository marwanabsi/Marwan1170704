package com.example.Marwan1170704.controller;

import com.example.Marwan1170704.model.Nurse;
import com.example.Marwan1170704.serves.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurses")
public class NurseController {
    private final NurseService nurseService;

    @Autowired
    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @GetMapping("/{id}")
    public Nurse getNurseById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return nurseService.getNurseById(id);
    }

    @GetMapping
    public List<Nurse> getAllNurses() {
        return nurseService.getAllNurses();
    }

    @PostMapping
    public Nurse createNurse(@RequestBody Nurse nurse) {
        return nurseService.createNurse(nurse);
    }

    @PutMapping("/{id}")
    public Nurse updateNurse(@PathVariable Long id, @RequestBody Nurse nurse) throws ChangeSetPersister.NotFoundException {
        return nurseService.updateNurse(id, nurse);
    }

    @DeleteMapping("/{id}")
    public void deleteNurse(@PathVariable Long id) {
        nurseService.deleteNurse(id);
    }
}
