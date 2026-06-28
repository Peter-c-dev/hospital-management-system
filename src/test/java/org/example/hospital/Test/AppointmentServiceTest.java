package org.example.hospital.Test;

import org.example.hospital.dto.AppointmentResponseDTO;
import org.example.hospital.dto.AppointmentRequestDTO;

import org.example.hospital.model.Appointment;
import org.example.hospital.model.Doctor;
import org.example.hospital.model.Patient;
import org.example.hospital.repository.AppointmentRepository;
import org.example.hospital.repository.DoctorRepository;
import org.example.hospital.service.AppointmentService;
import org.example.hospital.repository.PatientRepository;
import org.example.hospital.exception.AppointmentNotFoundException;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class AppointmentServiceTest {

    @Test
    void shouldReturnAppointmentById() {
        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
        PatientRepository patientRepository = mock(PatientRepository.class);
        DoctorRepository doctorRepository = mock(DoctorRepository.class);

        AppointmentService appointmentService =
                new AppointmentService(
                        appointmentRepository,
                        patientRepository,
                        doctorRepository);

        Appointment appointment = new Appointment();

        when(appointmentRepository.findById(1L))
                .thenReturn(Optional.of(appointment));

        Appointment result =
                appointmentService.getAppointmentById(1L);

        assertEquals(appointment, result);
    }

    @Test
    void shouldThrowExceptionWhenAppointmentNotFound() {

        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
        PatientRepository patientRepository = mock(PatientRepository.class);
        DoctorRepository doctorRepository = mock(DoctorRepository.class);

        AppointmentService appointmentService =
                new AppointmentService(
                        appointmentRepository,
                        patientRepository,
                        doctorRepository);

        when(appointmentRepository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(
                AppointmentNotFoundException.class,
                () -> appointmentService.getAppointmentById(999L));
    }
}