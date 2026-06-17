package org.example.hospital.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Appointment time is required")
    private LocalDateTime appointmentTime;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnoreProperties({"appointments"})
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonIgnoreProperties({"appointments"})
    private Doctor doctor;

    public Long getId() {
        return id;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}