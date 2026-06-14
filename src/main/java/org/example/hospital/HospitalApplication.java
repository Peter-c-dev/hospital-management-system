package org.example.hospital;

import org.example.hospital.model.Doctor;
import org.example.hospital.model.Ward;
import org.example.hospital.model.WardStatus;
import org.example.hospital.repository.DoctorRepository;
import org.example.hospital.repository.WardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner init(
            DoctorRepository doctorRepo,
            WardRepository wardRepo) {

        return args -> {

            Doctor testDoctor = new Doctor();
            testDoctor.setUsername("test");
            testDoctor.setPassword("1234");
            doctorRepo.save(testDoctor);

            Doctor drSmith = new Doctor();
            drSmith.setUsername("drsmith");
            drSmith.setPassword("1234");
            doctorRepo.save(drSmith);

            Ward generalWard = new Ward();
            generalWard.setWardName("General Ward");
            generalWard.setWardState(WardStatus.GENERAL_MEDICINE);
            generalWard.setCapacity(20);
            generalWard.setWardOpen(true);

            wardRepo.save(generalWard);
        };
    }
}