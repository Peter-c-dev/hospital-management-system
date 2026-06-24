package org.example.hospital.Test;

import org.example.hospital.exception.PatientNotFoundException;
import org.example.hospital.model.Patient;
import org.example.hospital.repository.PatientRepository;
import org.example.hospital.repository.WardRepository;
import org.example.hospital.service.PatientService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;
import org.example.hospital.model.PatientStatus;
import org.example.hospital.repository.DoctorRepository;
import org.example.hospital.model.Ward;
import static org.mockito.Mockito.*;

public class PatientServiceTest {

    @Test
    void shouldUpdatePatientStatus() {
        PatientRepository patientRepository = mock(PatientRepository.class);
        WardRepository wardRepository = mock(WardRepository.class);
        DoctorRepository doctorRepository = mock(DoctorRepository.class);

        PatientService patientService =
                new PatientService(
                        patientRepository,
                        wardRepository,
                        doctorRepository);

        Patient patient = new Patient();
        patient.setStatus(PatientStatus.ADMITTED);

        when(patientRepository.findById(1L))
                .thenReturn(Optional.of(patient));

        when(patientRepository.save(any(Patient.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Patient updatedPatient =
                patientService.updateStatus(
                        1L,
                        PatientStatus.RECOVERY);
        assertEquals(
                PatientStatus.RECOVERY,
                updatedPatient.getStatus());
    }

    @Test
    void shouldThrowExceptionWhenPatientNotFound() {
        PatientRepository patientRepository = mock(PatientRepository.class);
        WardRepository wardRepository = mock(WardRepository.class);
        DoctorRepository doctorRepository = mock(DoctorRepository.class);

        PatientService patientService =
                new PatientService(
                        patientRepository,
                        wardRepository,
                        doctorRepository);
        when(patientRepository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(
                PatientNotFoundException.class,
                () -> patientService.updateStatus(
                        999L,
                        PatientStatus.RECOVERY));
    }

    @Test
    void shouldReturnPatientWhenIdExists() {
        PatientRepository patientRepository = mock(PatientRepository.class);
        WardRepository wardRepository = mock(WardRepository.class);
        DoctorRepository doctorRepository = mock(DoctorRepository.class);
        PatientService patientService =
                new PatientService(
                        patientRepository,
                        wardRepository,
                        doctorRepository);
        Patient patient = new Patient();

        when(patientRepository.findById(1L))
                .thenReturn(Optional.of(patient));

        Patient result =
                patientService.getPatientById(1L);
        assertEquals(patient, result);
    }
    @Test
    void shouldThrowExceptionWhenGetPatientByIdNotFound() {

        PatientRepository patientRepository = mock(PatientRepository.class);
        WardRepository wardRepository = mock(WardRepository.class);
        DoctorRepository doctorRepository = mock(DoctorRepository.class);

        PatientService patientService =
                new PatientService(
                        patientRepository,
                        wardRepository,
                        doctorRepository);

        when(patientRepository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(
                PatientNotFoundException.class,
                () -> patientService.getPatientById(999L));
    }
    @Test
    void shouldDeletePatientWhenDischarged() {
        PatientRepository patientRepository = mock(PatientRepository.class);
        WardRepository wardRepository = mock(WardRepository.class);
        DoctorRepository doctorRepository = mock(DoctorRepository.class);
        PatientService patientService =
                new PatientService(
                        patientRepository,
                        wardRepository,
                        doctorRepository);
        patientService.dischargePatient(1L);
        verify(patientRepository).deleteById(1L);
    }
    @Test
    void shouldTransferPatientToNewWard() {
        PatientRepository patientRepository = mock(PatientRepository.class);
        WardRepository wardRepository = mock(WardRepository.class);
        DoctorRepository doctorRepository = mock(DoctorRepository.class);

        PatientService patientService =
                new PatientService(
                        patientRepository,
                        wardRepository,
                        doctorRepository);
        Patient patient = new Patient();

        Ward newWard = new Ward();
        newWard.setWardName("A&E");

        when(patientRepository.findById(1L))
                .thenReturn(Optional.of(patient));
        when(wardRepository.findByWardName("A&E"))
                .thenReturn(newWard);
        when(patientRepository.save(any(Patient.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));
        Patient transferredPatient =
                patientService.transferPatient(
                        1L,
                        "A&E");
        assertEquals(
                newWard,
                transferredPatient.getWard());
    }
}

