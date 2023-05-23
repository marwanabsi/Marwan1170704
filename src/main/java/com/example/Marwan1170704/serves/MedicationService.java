package com.example.Marwan1170704.serves;

import com.example.Marwan1170704.model.Medication;
import com.example.Marwan1170704.repositorys.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {
    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public Medication getMedicationById(Long id) throws ChangeSetPersister.NotFoundException {
        return medicationRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    public Medication createMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    public Medication updateMedication(Long id, Medication updatedMedication) throws ChangeSetPersister.NotFoundException {
        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        medication.setName(updatedMedication.getName());
        medication.setDosage(updatedMedication.getDosage());
        medication.setInstructions(updatedMedication.getInstructions());
        medication.setStockAvailability(updatedMedication.getStockAvailability());
        medication.setExpirationDate(updatedMedication.getExpirationDate());

        return medicationRepository.save(medication);
    }

    public void deleteMedication(Long id) {
        medicationRepository.deleteById(id);
    }
}
