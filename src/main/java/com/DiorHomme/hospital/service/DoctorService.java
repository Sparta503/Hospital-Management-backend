package com.DiorHomme.hospital.service;

import com.DiorHomme.hospital.model.Doctor;
import com.DiorHomme.hospital.model.AppointmentModel;
import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long id);
    List<AppointmentModel> getAppointmentsByDoctorId(Long doctorId);
    void acceptAppointment(Long doctorId, Long appointmentId);
    void rescheduleAppointment(Long doctorId, Long appointmentId, String newDate, String newTime);
    List<AppointmentModel> getUpcomingAppointments(Long doctorId);
    Doctor updateDoctor(Long id, Doctor doctor);
}
