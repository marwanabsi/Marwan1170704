package com.example.Marwan1170704.serves;

import com.example.Marwan1170704.repositorys.NurseRepository;
import com.example.Marwan1170704.model.Nurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {
    private final NurseRepository nurseRepository;

    @Autowired
    public NurseService(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    public Nurse getNurseById(Long id) throws ChangeSetPersister.NotFoundException {
        return nurseRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    public Nurse createNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    public Nurse updateNurse(Long id, Nurse updatedNurse) throws ChangeSetPersister.NotFoundException {
        Nurse nurse = nurseRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        nurse.setName(updatedNurse.getName());
        nurse.setContactDetails(updatedNurse.getContactDetails());
        nurse.setQualifications(updatedNurse.getQualifications());
        nurse.setShiftTimings(updatedNurse.getShiftTimings());
        return nurseRepository.save(nurse);
    }

    public void deleteNurse(Long id) {
        nurseRepository.deleteById(id);
    }
}
