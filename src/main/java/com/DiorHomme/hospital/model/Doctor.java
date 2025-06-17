package com.DiorHomme.hospital.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String specialization;

    @Column
    private String phoneNumber;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<AppointmentModel> appointments;

    public Doctor() {}

    public Doctor(Long id, String name, String email, String specialization, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<AppointmentModel> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentModel> appointments) {
        this.appointments = appointments;
    }
}
