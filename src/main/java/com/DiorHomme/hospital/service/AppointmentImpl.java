package com.DiorHomme.hospital.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.DiorHomme.hospital.model.AppointmentModel;

@Service
public class AppointmentImpl implements Appointment {
    private List<AppointmentModel> appointments = new ArrayList<>();

    @Override
    public List<AppointmentModel> getAllAppointments() {
        return appointments;
    }

    @Override
    public AppointmentModel createAppointment(AppointmentModel appointment) {
        appointments.add(appointment);
        return appointment;
    }

    @Override
    public void deleteAppointment(Long id) {
        appointments.removeIf(app -> app.getId().equals(id));
    }
}
