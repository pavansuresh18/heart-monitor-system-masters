package com.JanitriBackendAssignment.Controller;

import com.JanitriBackendAssignment.Service.PatientService;
import com.JanitriBackendAssignment.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/{userId}")
    public Patient addPatient(@PathVariable Long userId, @RequestBody Patient patient) {
        return patientService.addPatient(userId, patient);
    }

    @GetMapping
    public List<Patient> getPatients(@RequestParam Long userId) {
        return patientService.getPatientsByUserId(userId);
    }
}
