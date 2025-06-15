package com.DiorHomme.hospital.repository;

import com.DiorHomme.hospital.model.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel, Long> {
}
