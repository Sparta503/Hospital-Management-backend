package com.DiorHomme.hospital.service;

import java.util.List;
import com.DiorHomme.hospital.model.AppointmentModel;

public interface Appointment {
    List<AppointmentModel> getAllAppointments();
    AppointmentModel createAppointment(AppointmentModel appointment);
    void deleteAppointment(Long id);
}
