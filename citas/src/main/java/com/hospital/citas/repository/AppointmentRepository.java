package com.hospital.citas.repository;

import com.hospital.citas.entities.Appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {
    Appointment save(Appointment appointment);
    Optional<Appointment> findById(String id);
    List<Appointment> findByDoctorAndDate(String doctorId, LocalDateTime date);
}
