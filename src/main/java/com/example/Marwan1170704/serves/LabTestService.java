package com.example.Marwan1170704.serves;

import com.example.Marwan1170704.model.LabTest;
import com.example.Marwan1170704.repositorys.LabTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabTestService {
    private final LabTestRepository labTestRepository;

    @Autowired
    public LabTestService(LabTestRepository labTestRepository) {
        this.labTestRepository = labTestRepository;
    }

    public LabTest getLabTestById(Long id) throws ChangeSetPersister.NotFoundException {
        return labTestRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public List<LabTest> getAllLabTests() {
        return labTestRepository.findAll();
    }

    public LabTest createLabTest(LabTest labTest) {
        return labTestRepository.save(labTest);
    }

    public LabTest updateLabTest(Long id, LabTest updatedLabTest) throws ChangeSetPersister.NotFoundException {
        LabTest labTest = labTestRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        labTest.setName(updatedLabTest.getName());
        labTest.setDescription(updatedLabTest.getDescription());
        labTest.setDepartment(updatedLabTest.getDepartment());
        labTest.setTestResults(updatedLabTest.getTestResults());

        return labTestRepository.save(labTest);
    }

    public void deleteLabTest(Long id) {
        labTestRepository.deleteById(id);
    }
}
