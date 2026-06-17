package org.example.hospital.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AppointmentRequestDTO {

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    @NotBlank(message = "Appointment time is required")
    private String appointmentTime;

    public AppointmentRequestDTO() {
    }

    public AppointmentRequestDTO(Long patientId,
                                 Long doctorId,
                                 String appointmentTime) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentTime = appointmentTime;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}