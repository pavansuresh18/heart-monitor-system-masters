package com.JanitriBackendAssignment.Controller;

import com.JanitriBackendAssignment.Service.HeartRateService;
import com.JanitriBackendAssignment.entity.HeartRate;
import com.JanitriBackendAssignment.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heart-rate")
public class HeartRateController {
    @Autowired
    private HeartRateService heartRateService;

    @PostMapping("/{patientId}")
    public HeartRate addHeartRate(@PathVariable Long patientId, @RequestBody HeartRate heartRate) {
        return heartRateService.addHeartRate(patientId, heartRate.getHeartRate());
    }

    @GetMapping
    public List<HeartRate> getHeartRates(@RequestParam Long patientId) {
        return heartRateService.getHeartRatesByPatientId(patientId);
    }
}