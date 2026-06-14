
package org.example.hospital.controller;
import org.example.hospital.model.Patient;
import org.example.hospital.model.PatientStatus;
import org.example.hospital.service.PatientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
    @GetMapping("/search")
    public List<Patient> searchPatients(
            @RequestParam String name) {
        return patientService.searchPatients(name);
    }
    @PostMapping("/admit/{wardName}/{username}")
    public Patient admitPatient(
            @PathVariable String wardName,
            @PathVariable String username,
            @RequestBody Patient patient) {
        return patientService.admitPatient(patient, wardName, username);
    }
    @PatchMapping("/{id}/transfer/{wardName}")
    public Patient transferPatient(
            @PathVariable Long id,
            @PathVariable String wardName) {
        return patientService.transferPatient(id, wardName);
    }
    @PatchMapping("/{id}/status")
    public Patient updateStatus(
            @PathVariable Long id,
            @RequestBody PatientStatus status) {
        return patientService.updateStatus(id, status);
    }
    @DeleteMapping("/{id}")
    public void dischargePatient(
            @PathVariable Long id) {
        patientService.dischargePatient(id);
    }
}
