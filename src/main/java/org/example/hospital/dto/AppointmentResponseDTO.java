package org.example.hospital.dto;

public class AppointmentResponseDTO {

    private Long id;
    private String patientName;
    private String doctorName;
    private String appointmentTime;

    public AppointmentResponseDTO(Long id,
                                  String patientName,
                                  String doctorName,
                                  String appointmentTime) {

        this.id = id;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentTime = appointmentTime;
    }
    public Long getId() {
        return id;
    }
    public String getPatientName() {
        return patientName;
    }
    String getDoctorName() {
        return doctorName;
    }
    public String getAppointmentTime() {
        return appointmentTime;
    }
}
