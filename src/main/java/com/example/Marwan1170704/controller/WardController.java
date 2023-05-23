package com.example.Marwan1170704.controller;

import com.example.Marwan1170704.model.Ward;
import com.example.Marwan1170704.serves.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wards")
public class WardController {
    private final WardService wardService;

    @Autowired
    public WardController(WardService wardService) {
        this.wardService = wardService;
    }

    @GetMapping("/{id}")
    public Ward getWardById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return wardService.getWardById(id);
    }

    @GetMapping
    public List<Ward> getAllWards() {
        return wardService.getAllWards();
    }

    @PostMapping
    public Ward createWard(@RequestBody Ward ward) {
        return wardService.createWard(ward);
    }

    @PutMapping("/{id}")
    public Ward updateWard(@PathVariable Long id, @RequestBody Ward ward) throws ChangeSetPersister.NotFoundException {
        return wardService.updateWard(id, ward);
    }

    @DeleteMapping("/{id}")
    public void deleteWard(@PathVariable Long id) {
        wardService.deleteWard(id);
    }
}
