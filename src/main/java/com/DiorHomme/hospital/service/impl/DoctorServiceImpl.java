package com.DiorHomme.hospital.service.impl;

import com.DiorHomme.hospital.model.Doctor;
import com.DiorHomme.hospital.model.AppointmentModel;
import com.DiorHomme.hospital.repository.DoctorRepository;
import com.DiorHomme.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    @Override
    public List<AppointmentModel> getAppointmentsByDoctorId(Long doctorId) {
        return doctorRepository.getAppointmentsByDoctorId(doctorId);
    }

    @Override
    public void acceptAppointment(Long doctorId, Long appointmentId) {
        doctorRepository.updateAppointmentStatus(appointmentId, "ACCEPTED");
    }

    @Override
    public void rescheduleAppointment(Long doctorId, Long appointmentId, String newDate, String newTime) {
        doctorRepository.rescheduleAppointment(doctorId, appointmentId, newDate, newTime);
    }

    @Override
    public List<AppointmentModel> getUpcomingAppointments(Long doctorId) {
        return doctorRepository.getAppointmentsByDoctorId(doctorId);
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        doctor.setId(id);
        return doctorRepository.save(doctor);
    }
}
