package com.hospital.citas;

import com.hospital.citas.entities.Appointment;
import com.hospital.citas.entities.Doctor;
import com.hospital.citas.entities.Patient;
import com.hospital.citas.repository.InMemoryAppointmentRepository;
import com.hospital.citas.usecase.ScheduleAppointmentUseCase;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        InMemoryAppointmentRepository repo = new InMemoryAppointmentRepository();
        ScheduleAppointmentUseCase scheduler = new ScheduleAppointmentUseCase(repo);

        Patient p = new Patient("P001", "Juan Perez", "juan.perez@example.com");
        Doctor d = new Doctor("D001", "Dr. Ana", "Cardiología");

        LocalDateTime dt = LocalDateTime.now().plusDays(2).withHour(10).withMinute(0).withSecond(0).withNano(0);
        Appointment appt = scheduler.schedule(p, d, dt);

        System.out.println("Cita agendada correctamente:\n" + appt);
        System.out.println("Ticket:\n" + appt.printTicket());
    }
}
