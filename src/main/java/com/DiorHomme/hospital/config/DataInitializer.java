package com.DiorHomme.hospital.config;

import com.DiorHomme.hospital.model.Doctor;
import com.DiorHomme.hospital.model.AppointmentModel;
import com.DiorHomme.hospital.repository.DoctorRepository;
import com.DiorHomme.hospital.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create test doctor
        Doctor doctor = new Doctor();
        doctor.setName("Dr. John Smith");
        doctor.setEmail("john.smith@example.com");
        doctor.setSpecialization("Cardiology");
        doctor = doctorRepository.save(doctor);

        // Create test appointment
        AppointmentModel appointment = new AppointmentModel();
        appointment.setPatientId(1L);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate("2025-06-18");
        appointment.setAppointmentTime("10:00:00");
        appointment.setStatus("SCHEDULED");
        appointment.setNotes("Initial consultation");
        appointmentRepository.save(appointment);
    }
}
