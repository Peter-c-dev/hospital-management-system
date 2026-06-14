
package org.example.hospital.service;
import org.example.hospital.repository.DoctorRepository;
import org.example.hospital.model.*;
import org.example.hospital.repository.PatientRepository;
import org.example.hospital.repository.WardRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final WardRepository wardRepository;
    private final DoctorRepository doctorRepository;

    public PatientService(
            PatientRepository patientRepository,
            WardRepository wardRepository,
            DoctorRepository doctorRepository) {

        this.patientRepository = patientRepository;
        this.wardRepository = wardRepository;
        this.doctorRepository = doctorRepository;

    }
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    public List<Patient> searchPatients(String name) {
        return patientRepository
                .findByNameContainingIgnoreCase(name);
    }
    public Patient admitPatient(
            Patient patient,
            String wardName,
            String username) {

        Ward ward = Optional
                .ofNullable(wardRepository.findByWardName(wardName))
                .orElseThrow(() -> new IllegalArgumentException(
                        "Ward name '" + wardName + "' not found."));

        Doctor doctor = Optional
                .ofNullable(doctorRepository.findByUsername(username))
                .orElseThrow(() ->
                        new RuntimeException("Doctor not found with username: " + username)
                );

        patient.setWard(ward);
        patient.setDoctor(doctor);
        patient.setStatus(PatientStatus.ADMITTED);

        return patientRepository.save(patient);
    }
    public Patient transferPatient(Long patientId, String wardName) {
        Patient patient = patientRepository
                .findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Patient not found"));
        Ward newWard = wardRepository
                .findByWardName(wardName);
        if (newWard == null) {
            throw new IllegalArgumentException(
                    "Ward not found");
        }
        patient.setWard(newWard);
        return patientRepository.save(patient);
    }
    public Patient updateStatus(Long id, PatientStatus status) {
        return patientRepository
                .findById(id)
                .map(patient -> {
                    patient.setStatus(status);
                    return patientRepository.save(patient);
                })
                .orElseThrow(() -> new IllegalArgumentException(
                        "Patient not found"));
    }
    public void dischargePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
