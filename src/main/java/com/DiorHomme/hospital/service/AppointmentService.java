package com.DiorHomme.hospital.service;

import com.DiorHomme.hospital.model.AppointmentModel;
import java.util.List;

public interface AppointmentService {
    List<AppointmentModel> getAllAppointments();
    AppointmentModel createAppointment(AppointmentModel appointment);
    AppointmentModel getAppointmentById(Long id);
    AppointmentModel updateAppointment(Long id, AppointmentModel appointment);
    void deleteAppointment(Long id);
}
