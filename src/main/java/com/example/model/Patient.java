package com.example.model;

import java.time.Instant;

public class Patient {
    private String id;
    private String nationalProviderIdentifier;
    private String firstName;
    private String lastName;
    private Instant dateOfBirth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNationalProviderIdentifier() {
        return nationalProviderIdentifier;
    }

    public void setNationalProviderIdentifier(String nationalProviderIdentifier) {
        this.nationalProviderIdentifier = nationalProviderIdentifier;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Instant dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
