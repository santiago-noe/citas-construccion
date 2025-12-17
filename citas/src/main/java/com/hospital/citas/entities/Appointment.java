package com.hospital.citas.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Appointment {
    private final String id;
    private final Patient patient;
    private final Doctor doctor;
    private final LocalDateTime datetime;
    private String status;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime datetime) {
        this.id = UUID.randomUUID().toString();
        this.patient = patient;
        this.doctor = doctor;
        this.datetime = datetime;
        this.status = "PROGRAMADA";
    }

    public String getId() { return id; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getDatetime() { return datetime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String printTicket() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- TICKET DE CITA ---\n");
        sb.append("ID: ").append(id).append('\n');
        sb.append("Paciente: ").append(patient).append('\n');
        sb.append("Médico: ").append(doctor).append('\n');
        sb.append("Fecha/Hora: ").append(datetime).append('\n');
        sb.append("Estado: ").append(status).append('\n');
        sb.append("----------------------\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Cita[" + id + "] " + patient + " - " + doctor + " @ " + datetime;
    }
}
