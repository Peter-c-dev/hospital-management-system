package org.example.hospital;

import org.example.hospital.model.Doctor;
import org.example.hospital.repository.DoctorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner init(DoctorRepository repo) {
        return args -> {
            Doctor d = new Doctor();
            d.setUsername("test");
            d.setPassword("1234");
            repo.save(d);
        };
    }
}