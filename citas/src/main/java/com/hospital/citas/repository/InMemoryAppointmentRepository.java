package com.hospital.citas.repository;

import com.hospital.citas.entities.Appointment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryAppointmentRepository implements AppointmentRepository {
    private final List<Appointment> storage = new ArrayList<>();

    @Override
    public Appointment save(Appointment appointment) {
        storage.add(appointment);
        return appointment;
    }

    @Override
    public Optional<Appointment> findById(String id) {
        return storage.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    @Override
    public List<Appointment> findByDoctorAndDate(String doctorId, LocalDateTime date) {
        return storage.stream()
                .filter(a -> a.getDoctor().getId().equals(doctorId)
                        && a.getDatetime().toLocalDate().equals(date.toLocalDate()))
                .collect(Collectors.toList());
    }
}
