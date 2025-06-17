package com.DiorHomme.hospital.repository;

import com.DiorHomme.hospital.model.Doctor;
import com.DiorHomme.hospital.model.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("SELECT a FROM AppointmentModel a WHERE a.doctor.id = :doctorId")
    List<AppointmentModel> getAppointmentsByDoctorId(@Param("doctorId") Long doctorId);

    @Modifying
    @Query("UPDATE AppointmentModel a SET a.status = :status WHERE a.id = :appointmentId")
    void updateAppointmentStatus(@Param("appointmentId") Long appointmentId, @Param("status") String status);

    @Modifying
    @Query("DELETE FROM AppointmentModel a WHERE a.id = :appointmentId")
    void deleteAppointment(@Param("appointmentId") Long appointmentId);

    @Modifying
    @Query("UPDATE AppointmentModel a SET a.appointmentDate = :newDate, a.appointmentTime = :newTime WHERE a.doctor.id = :doctorId AND a.id = :appointmentId")
    void rescheduleAppointment(@Param("doctorId") Long doctorId, @Param("appointmentId") Long appointmentId, @Param("newDate") String newDate, @Param("newTime") String newTime);
}
