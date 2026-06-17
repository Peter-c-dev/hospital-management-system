package org.example.hospital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Doctor {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username cannot be empty")
    @Column(nullable = false, length = 300)
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false, length = 300)
    private String password;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnoreProperties("doctor")
    private List<Appointment> appointments;

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

}
