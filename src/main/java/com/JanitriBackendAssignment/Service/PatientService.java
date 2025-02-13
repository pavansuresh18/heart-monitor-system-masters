package com.JanitriBackendAssignment.Service;

import com.JanitriBackendAssignment.Repository.PatientRepository;
import com.JanitriBackendAssignment.Repository.UserRepository;
import com.JanitriBackendAssignment.entity.Patient;
import com.JanitriBackendAssignment.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    public Patient addPatient(Long userId, Patient patient) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        patient.setUser(user);
        return patientRepository.save(patient);
    }

    public List<Patient> getPatientsByUserId(Long userId) {
        return patientRepository.findByUserId(userId);
    }
}