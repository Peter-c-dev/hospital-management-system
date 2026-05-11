package org.example.hospital.controller;
import org.example.hospital.model.Ward;
import org.example.hospital.repository.WardRepository;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/wards")
public class WardController {
    private final WardRepository wardRepository;
    public WardController(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }
    @GetMapping
    public List<Ward> getAllWards() {
        return wardRepository.findAll();
    }
    @PostMapping
    public Ward createWard(@Valid @RequestBody Ward ward) {
        return wardRepository.save(ward);
    }
}
