package org.example.hospital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 300)
    private String wardName;

    @Enumerated(EnumType.STRING)
    private WardStatus wardState;

    @NotNull
    @Min(0)
    private Integer capacity;

    private boolean wardOpen;

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;

    }
    @OneToMany(mappedBy = "ward", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Patient> patients;
}