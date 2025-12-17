package com.hospital.citas.usecase;

import com.hospital.citas.entities.Appointment;
import com.hospital.citas.entities.Doctor;
import com.hospital.citas.entities.Patient;
import com.hospital.citas.repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleAppointmentUseCase {
    private final AppointmentRepository repository;

    public ScheduleAppointmentUseCase(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment schedule(Patient patient, Doctor doctor, LocalDateTime datetime) {
        // Simple rule: no two appointments at same date/time for same doctor
        List<Appointment> existing = repository.findByDoctorAndDate(doctor.getId(), datetime);
        boolean conflict = existing.stream().anyMatch(a -> a.getDatetime().equals(datetime));
        if (conflict) {
            throw new IllegalArgumentException("El horario no está disponible para el médico seleccionado.");
        }
        Appointment appt = new Appointment(patient, doctor, datetime);
        repository.save(appt);
        return appt;
    }
}
