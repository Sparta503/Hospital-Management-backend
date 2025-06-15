package com.DiorHomme.hospital.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "appointments")
public class AppointmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "patient_id")
    private Long patientId;
    
    @Column(name = "doctor_id")
    private Long doctorId;
    
    @Column(name = "appointment_date")
    private String appointmentDate;
    
    @Column(name = "appointment_time")
    private String appointmentTime;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "notes")
    private String notes;
}
