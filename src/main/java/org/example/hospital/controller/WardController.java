package org.example.hospital.controller;

import org.example.hospital.model.Ward;
import org.example.hospital.service.WardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wards")
public class WardController {

    private final WardService wardService;

    public WardController(
            WardService wardService
    ) {
        this.wardService = wardService;
    }

    @PostMapping
    public Ward createWard(
            @RequestBody Ward ward
    ) {
        return wardService.saveWard(ward);
    }

    @GetMapping
    public List<Ward> getAllWards() {
        return wardService.getAllWards();
    }

    @GetMapping("/search")
    public List<Ward> searchWards(
            @RequestParam String wardName) {
        return wardService.searchWards(
                wardName);
    }


    @GetMapping("/{id}")
    public Ward getWardById(
            @PathVariable Long id) {
        return wardService.getWardById(id);
    }
}

