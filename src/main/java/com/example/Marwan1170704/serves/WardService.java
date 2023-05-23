package com.example.Marwan1170704.serves;

import com.example.Marwan1170704.model.Ward;
import com.example.Marwan1170704.repositorys.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardService {
    private final WardRepository wardRepository;

    @Autowired
    public WardService(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }

    public Ward getWardById(Long id) throws ChangeSetPersister.NotFoundException {
        return wardRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public List<Ward> getAllWards() {
        return wardRepository.findAll();
    }

    public Ward createWard(Ward ward) {
        return wardRepository.save(ward);
    }

    public Ward updateWard(Long id, Ward updatedWard) throws ChangeSetPersister.NotFoundException {
        Ward ward = wardRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        ward.setName(updatedWard.getName());
        ward.setCapacity(updatedWard.getCapacity());
        ward.setAvailability(updatedWard.isAvailability());
        return wardRepository.save(ward);
    }

    public void deleteWard(Long id) {
        wardRepository.deleteById(id);
    }
}
