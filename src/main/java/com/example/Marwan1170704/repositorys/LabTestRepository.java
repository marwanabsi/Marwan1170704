package com.example.Marwan1170704.repositorys;

import com.example.Marwan1170704.model.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestRepository extends JpaRepository<LabTest, Long> {
}
