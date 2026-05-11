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

    @NotBlank
    @Column(nullable = false, length = 300)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 400)
    private String diagnosis;

    @NotBlank
    @Column(nullable = false, length = 400)
    private String allergies;

    @NotNull
    @Min(0)
    @Max(115)
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