package org.example.hospital.controller;

import org.example.hospital.model.Appointment;
import org.example.hospital.service.AppointmentService;
import org.example.hospital.dto.AppointmentRequestDTO;
import org.example.hospital.dto.AppointmentResponseDTO;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

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
            @Valid @RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        return appointmentService.createAppointment(appointmentRequestDTO);
    }
    @PatchMapping("/{id}")
    public AppointmentResponseDTO updateAppointment(
            @PathVariable Long Id,
            @Valid @RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        return appointmentService.updateAppointment(
                Id, appointmentRequestDTO);
    }
    @GetMapping
    public List<AppointmentResponseDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
}
@GetMapping("/{id}")
public Appointment getAppointmentById(
        @PathVariable Long id) {
    return appointmentService.getAppointmentById(id);
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

