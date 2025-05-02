package com.example.model;

import java.time.Instant;

public class PatientDto {
    private String id;
    private String nationalProviderIdentifier;
    private String firstName;
    private String lastName;
    private Instant dateOfBirth;

    public String getId() {
        return id;
    }

    public String getNationalProviderIdentifier() {
        return nationalProviderIdentifier;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }
}
