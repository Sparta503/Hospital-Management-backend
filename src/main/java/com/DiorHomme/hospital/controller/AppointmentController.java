package com.DiorHomme.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.DiorHomme.hospital.service.Appointment;
import com.DiorHomme.hospital.model.AppointmentModel;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private Appointment appointmentService;

    @GetMapping
    public List<AppointmentModel> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public AppointmentModel createAppointment(@RequestBody AppointmentModel appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
}
