package org.example.hospital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username cannot be empty")
    @Column(nullable = false, length = 235)
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Column(nullable = false, length = 235)
    private String password;

    @NotBlank(message = "Role cannot be empty")
    private String role;

}
