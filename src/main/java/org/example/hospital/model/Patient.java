package org.example.hospital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Patient name cannot be empty")
    @Column(nullable = false, length = 300)
    private String name;

    @NotBlank(message = "Diagnosis cannot be empty")
    @Column(nullable = false, length = 400)
    private String diagnosis;

    @NotBlank(message = "Allergies cannot be empty")
    @Column(nullable = false, length = 400)
    private String allergies;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 115, message = "Age cannot exceed 115")
    private Integer age;

    @Enumerated(EnumType.STRING)
    private PatientStatus status;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}