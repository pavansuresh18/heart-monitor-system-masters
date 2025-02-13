package com.JanitriBackendAssignment.Service;


import com.JanitriBackendAssignment.Repository.HeartRateRepository;
import com.JanitriBackendAssignment.Repository.PatientRepository;
import com.JanitriBackendAssignment.entity.HeartRate;
import com.JanitriBackendAssignment.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HeartRateService {
    @Autowired
    private HeartRateRepository heartRateRepository;
    @Autowired
    private PatientRepository patientRepository;

    public HeartRate addHeartRate(Long patientId, int heartRateValue) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        HeartRate heartRate = new HeartRate();
        heartRate.setPatient(patient);
        heartRate.setHeartRate(heartRateValue);
        heartRate.setRecordedAt(LocalDateTime.now());

        return heartRateRepository.save(heartRate);
    }

    public List<HeartRate> getHeartRatesByPatientId(Long patientId) {
        return heartRateRepository.findByPatientId(patientId);
    }
}