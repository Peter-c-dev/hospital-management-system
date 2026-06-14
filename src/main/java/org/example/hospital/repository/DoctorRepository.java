package org.example.hospital.repository;

import org.example.hospital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor findByUsername(String username);

    Doctor findByUsernameAndPassword(
            String username,
            String password);

    List<Doctor> findByUsernameContainingIgnoreCase(
            String username);
}