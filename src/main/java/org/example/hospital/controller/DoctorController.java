package org.example.hospital.controller;
import org.example.hospital.service.DoctorService;
import org.springframework.web.bind.annotation.*;
import org.example.hospital.dto.DoctorResponseDTO;
import org.example.hospital.dto.LoginRequestDTO;
import org.example.hospital.model.Doctor;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping("/login")
    public DoctorResponseDTO login(
            @RequestBody LoginRequestDTO request) {

        Doctor doctor = doctorService.login(
                request.getUsername(),
                request.getPassword()
        );

        return new DoctorResponseDTO(
                doctor.getId(),
                doctor.getUsername()
        );
    }
}