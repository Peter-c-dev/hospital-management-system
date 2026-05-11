package org.example.hospital.dto;

public class DoctorResponseDTO {

    private Long id;
    private String username;

    public DoctorResponseDTO() {
    }
    public DoctorResponseDTO (Long id, String username) {
        this.id = id;
        this.username = username;
    }
    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
}
