package org.example.hospital.service;
import org.example.hospital.model.Doctor;
import org.example.hospital.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import org.example.hospital.exception.DoctorNotFoundException;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    public List<Doctor> searchDoctors(String username) {
        return doctorRepository
                .findByUsernameContainingIgnoreCase(
                        username);
    }
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() ->
                        new DoctorNotFoundException(
                                "Doctor not found"));
    }
    public Doctor login(String username, String password) {

        Doctor doctor = doctorRepository.findByUsername(username);

        if (doctor == null || !doctor.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        return doctor;
    }
}