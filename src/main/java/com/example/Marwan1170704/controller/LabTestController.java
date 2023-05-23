package com.example.Marwan1170704.controller;

import com.example.Marwan1170704.model.LabTest;
import com.example.Marwan1170704.serves.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labtests")
public class LabTestController {
    private final LabTestService labTestService;

    @Autowired
    public LabTestController(LabTestService labTestService) {
        this.labTestService = labTestService;
    }

    @GetMapping("/{id}")
    public LabTest getLabTestById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return labTestService.getLabTestById(id);
    }

    @GetMapping
    public List<LabTest> getAllLabTests() {
        return labTestService.getAllLabTests();
    }

    @PostMapping
    public LabTest createLabTest(@RequestBody LabTest labTest) {
        return labTestService.createLabTest(labTest);
    }

    @PutMapping("/{id}")
    public LabTest updateLabTest(@PathVariable Long id, @RequestBody LabTest labTest) throws ChangeSetPersister.NotFoundException {
        return labTestService.updateLabTest(id, labTest);
    }

    @DeleteMapping("/{id}")
    public void deleteLabTest(@PathVariable Long id) {
        labTestService.deleteLabTest(id);
    }
}
