package com.hospital.citas.entities;

public class Doctor {
    private final String id;
    private final String name;
    private final String specialty;

    public Doctor(String id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }

    @Override
    public String toString() {
        return name + " - " + specialty + " (" + id + ")";
    }
}
