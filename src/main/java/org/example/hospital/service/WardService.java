package org.example.hospital.service;

import org.example.hospital.model.Ward;
import org.example.hospital.repository.WardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardService {

    private final WardRepository wardRepository;

    public WardService(
            WardRepository wardRepository) {

        this.wardRepository = wardRepository;
    }

    public Ward saveWard(Ward ward) {
        return wardRepository.save(ward);
    }

    public List<Ward> getAllWards() {
        return wardRepository.findAll();
    }

    public List<Ward> searchWards(String wardName) {
        return wardRepository
                .findByWardNameContainingIgnoreCase(
                        wardName);
    }

    public Ward getWardById(Long id) {
        return wardRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Ward not found"));
    }
}