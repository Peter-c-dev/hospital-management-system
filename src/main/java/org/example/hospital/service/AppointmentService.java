package org.example.hospital.service;

import org.example.hospital.dto.AppointmentRequestDTO;
import org.example.hospital.dto.AppointmentResponseDTO;
import org.example.hospital.model.Appointment;
import org.example.hospital.model.Doctor;
import org.example.hospital.model.Patient;
import org.example.hospital.repository.AppointmentRepository;
import org.example.hospital.repository.DoctorRepository;
import org.example.hospital.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.example.hospital.exception.AppointmentNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              PatientRepository patientRepository,
                              DoctorRepository doctorRepository) {

        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public AppointmentResponseDTO convertToDTO(Appointment appointment) {

        return new AppointmentResponseDTO(
                appointment.getId(),
                appointment.getPatient().getName(),
                appointment.getDoctor().getUsername(),
                appointment.getAppointmentTime().toString()
        );
    }

    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO) {


        Patient patient = patientRepository.findById(appointmentRequestDTO.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

        Doctor doctor = doctorRepository.findById(appointmentRequestDTO.getDoctorId())
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        Appointment appointment = new Appointment();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointment.setAppointmentTime(
                LocalDateTime.parse(appointmentRequestDTO.getAppointmentTime())
        );

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return convertToDTO(savedAppointment);
    }
    public AppointmentResponseDTO updateAppointment(
            Long appointmentId,
            AppointmentRequestDTO appointmentRequestDTO) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() ->
                        new AppointmentNotFoundException(
                                "Appointment not found"));
        Doctor doctor = doctorRepository.findById(
                appointmentRequestDTO.getDoctorId())
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
        appointment.setDoctor(doctor);
        appointment.setAppointmentTime(
                LocalDateTime.parse(
                        appointmentRequestDTO.getAppointmentTime()));
                Appointment updatedAppointment = appointmentRepository.save(appointment);
                return convertToDTO(updatedAppointment);

    }

    public List<AppointmentResponseDTO> getAllAppointments() {

        return appointmentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() ->
                        new AppointmentNotFoundException(
                                "Appointment not found"));

    }
}