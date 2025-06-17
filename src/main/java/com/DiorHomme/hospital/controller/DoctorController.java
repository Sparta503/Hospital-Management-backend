package com.DiorHomme.hospital.controller;

import com.DiorHomme.hospital.model.Doctor;
import com.DiorHomme.hospital.model.AppointmentModel;
import com.DiorHomme.hospital.service.DoctorService;
import com.DiorHomme.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    // Get all appointments
    @GetMapping("/appointments")
    public List<AppointmentModel> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Create a new appointment
    @PostMapping("/appointments")
    public AppointmentModel createAppointment(@RequestBody AppointmentModel appointment) {
        return appointmentService.createAppointment(appointment);
    }

    // View all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Get doctor by id
    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    // View all appointments for a doctor
    @GetMapping("/{doctorId}/appointments")
    public List<AppointmentModel> getAppointmentsByDoctor(@PathVariable Long doctorId) {
        return doctorService.getAppointmentsByDoctorId(doctorId);
    }

    // Make a prescription for an appointment (stub)
    @PostMapping("/{doctorId}/appointments/{appointmentId}/prescription")
    public ResponseEntity<String> makePrescription(@PathVariable Long doctorId, @PathVariable Long appointmentId, @RequestBody String prescription) {
        // Implement prescription logic here
        return ResponseEntity.ok("Prescription added for appointment " + appointmentId);
    }

    // Accept an appointment
    @PostMapping("/{doctorId}/appointments/{appointmentId}/accept")
    public ResponseEntity<Void> acceptAppointment(@PathVariable Long doctorId, @PathVariable Long appointmentId) {
        doctorService.acceptAppointment(doctorId, appointmentId);
        return ResponseEntity.ok().build();
    }

    // Reschedule an appointment
    @PostMapping("/{doctorId}/appointments/{appointmentId}/reschedule")
    public ResponseEntity<Void> rescheduleAppointment(
            @PathVariable Long doctorId,
            @PathVariable Long appointmentId,
            @RequestParam String newDate,
            @RequestParam String newTime) {
        doctorService.rescheduleAppointment(doctorId, appointmentId, newDate, newTime);
        return ResponseEntity.ok().build();
    }

    // Other necessary functionalities (example: update profile)
    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }
}
