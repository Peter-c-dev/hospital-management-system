package org.example.hospital.exception;

public class DoctorNotFoundException
extends RuntimeException {

    public DoctorNotFoundException(String message) {
        super(message);
    }
}
