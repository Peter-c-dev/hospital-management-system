package org.example.hospital.repository;

import org.example.hospital.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface WardRepository extends JpaRepository<Ward, Long> {
    Ward findByWardName(String wardName);

}