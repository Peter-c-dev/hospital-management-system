package org.example.hospital.dto;

public class PatientResponseDTO {

    private Long id;

    private String name;

    private String diagnosis;

    private Integer age;

    private String wardName;

    private String doctorName;

    public PatientResponseDTO(
            Long id,
            String name,
            String diagnosis,
            Integer age,
            String wardName,
            String doctorName
    ) {
        this.id = id;
        this.name = name;
        this.diagnosis = diagnosis;
        this.age = age;
        this.wardName = wardName;
        this.doctorName = doctorName;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public Integer getAge() {
        return age;
    }
    public String getWardName() {
        return wardName;
    }
    public String getDoctorName() {
        return doctorName;
    }
}
