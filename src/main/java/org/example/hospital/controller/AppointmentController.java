package org.example.hospital.controller;

import org.example.hospital.model.Appointment;
import org.example.hospital.service.AppointmentService;
import org.example.hospital.dto.AppointmentRequestDTO;
import org.example.hospital.dto.AppointmentResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public AppointmentResponseDTO createAppointment(
            @RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        return appointmentService.createAppointment(appointmentRequestDTO);
    }
    @GetMapping
    public List<AppointmentResponseDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/doctor/{id}")
    public List<Appointment> getByDoctor(@PathVariable Long id) {
        return appointmentService.getAppointmentsByDoctor(id);
    }

    @GetMapping("/patient/{id}")
    public List<Appointment> getByPatient(@PathVariable Long id) {
        return appointmentService.getAppointmentsByPatient(id);
    }
}