package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Patient;
import com.example.model.PatientDto;
import com.example.model.Visit;
import com.example.model.VisitType;
import com.example.service.PatientService;
import com.example.service.VisitService;

@RestController
public class PatientController {
    
    private final PatientService patientService;
    private VisitService visitService;
    
    public PatientController(PatientService patientService, VisitService visitServiceBean) {
        this.patientService = patientService;
        this.visitService = visitServiceBean;
    }

    /**
     * Find any patients with the given first name, last name, or date of birth
     * 
     * @param searchParams parameters used to search for patients
     * @return a list of all patients matching the search criteria
     */
    @PostMapping(path = "/patient/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Patient>> findPatients(@RequestBody Patient searchParams) {
        List<Patient> patients = List.of();
        if (searchParams.getFirstName() != null) {
            patients = patientService.getPatients(searchParams.getFirstName(), "", searchParams.getDateOfBirth());
        } else if (searchParams.getLastName() != null) {
            patients = patientService.getPatients(searchParams.getFirstName(), "", null);
        } else if (searchParams.getDateOfBirth() != null) {
            patients.addAll(patientService.getPatients("", "", searchParams.getDateOfBirth()));
        }
        
        return ResponseEntity.ok(patients);
    }
    
    @GetMapping("/patient/{npi}")
    public Patient getPatient(@PathVariable String npi) {
        return patientService.getPatientById(npi);
    }
    
    @PostMapping("/patient/")
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }
    
    @PostMapping("/patient/{patientId}")
    public void updatePatient(@PathVariable String patientId, @RequestBody PatientDto patientDto) {
        if (patientDto.getId() != null) {
            Patient patient = new Patient();
            patient.setId(patientDto.getId());
            patient.setNationalProviderIdentifier(patient.getNationalProviderIdentifier());
            patient.setFirstName(patientDto.getFirstName());
            patient.setLastName(patient.getLastName());
            patientService.updatePatient(patientDto.getId(), patient);
        }
    }
    
    @DeleteMapping("/delete/patient/{patientId}")
    public ResponseEntity<Integer> deletePatient(@PathVariable String patientId) {
        patientService.deletePatient(patientId);
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            return ResponseEntity.ok(0);
        }
        return ResponseEntity.ok(1);
    }
    
    @GetMapping("/visit/{visitId}")
    public Visit getPatientVisit() {
        return visitService.getVisitsByType(VisitType.EMERGENCY).get(0);
    }
    
    @GetMapping("/patient/visit/URGENT_CARE")
    public List<Visit> getPatientUrgentCareVisit() {
        return visitService.getVisitsByType(VisitType.URGENT_CARE);
    }
    
    @GetMapping("/visit/{visitType}/")
    public ResponseEntity<List<Visit>> getPrimaryCareVisit(VisitType visitType) {
        List<Visit> visitsByType = visitService.getVisitsByType(visitType);
        if (visitsByType.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(visitsByType);    
        }
    }
}
