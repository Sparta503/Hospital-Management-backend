package com.DiorHomme.hospital.service;

import com.DiorHomme.hospital.model.Patient;
import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient createPatient(Patient patient);
    Patient updatePatient(Long id, Patient patient);
    boolean deletePatient(Long id);
}
