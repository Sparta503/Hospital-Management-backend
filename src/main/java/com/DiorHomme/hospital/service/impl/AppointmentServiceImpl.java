package com.DiorHomme.hospital.service.impl;

import com.DiorHomme.hospital.model.AppointmentModel;
import com.DiorHomme.hospital.repository.AppointmentRepository;
import com.DiorHomme.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentModel> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public AppointmentModel createAppointment(AppointmentModel appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public AppointmentModel getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    @Override
    public AppointmentModel updateAppointment(Long id, AppointmentModel appointment) {
        appointment.setId(id);
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
