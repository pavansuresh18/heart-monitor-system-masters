package com.JanitriBackendAssignment.Repository;

import com.JanitriBackendAssignment.entity.HeartRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {
    List<HeartRate> findByPatientId(Long patientId);
}