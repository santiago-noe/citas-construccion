package com.hospital.citas.entities;

public class Ticket {
    private final Appointment appointment;

    public Ticket(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return appointment.printTicket();
    }
}
