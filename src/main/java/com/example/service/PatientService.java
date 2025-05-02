package com.example.service;

import java.time.Instant;
import java.util.List;

import com.example.exception.NoSuchPatientException;
import com.example.model.Patient;

public interface PatientService {

    /**
     * Gets a patient by their unique system ID
     * 
     * @param id system ID used to find patient
     * @return patient specified by ID or null if no such patient exists
     */
    public Patient getPatientById(String id);

    /**
     * Gets a patient by their national patient identifier (NPI)
     *
     * @param npi National Patient Identifier used to find patient
     * @return patient specified by NPI or null if no such patient exists
     */
    public Patient getPatientByNPI(String npi);

    /**
     * Gets one or more patients using the given search parameters;
     * use null value to exclude search parameters
     * 
     * @param firstName patient's first name
     * @param lastName patient's last name
     * @param dateOfBirth patient's date of birth
     * @return list of patients (if any) found
     */
    public List<Patient> getPatients(String firstName, String lastName, Instant dateOfBirth);

    /**
     * Adds a new patient
     * @param patient patient to add
     */
    public void addPatient(Patient patient);

    /**
     * Updates the specified patient
     * 
     * @param patientId ID of patient to update
     * @param patient data used to update patient
     * @throws NoSuchPatientException if the patient does not exist
     */
    public void updatePatient(String patientId, Patient patient) throws NoSuchPatientException;

    /**
     * Deletes the specified patient; ignores invalid patient IDs
     * 
     * @param patientId ID of patient to delete
     */
    public void deletePatient(String patientId);
}
