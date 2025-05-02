package com.example.service;

import java.util.List;

import com.example.model.Visit;
import com.example.model.VisitType;

public interface VisitService {

    /**
     * Gets a specific visit
     * 
     * @param id ID of the visit to retrieve
     * @return the visit identified or null if no visit could be found
     */
    public Visit getVisitById(String id);

    /**
     * Gets a list of visits of a specific type
     * 
     * @param visitType type of visits to retrieve
     * @return the list of visits
     */
    public List<Visit> getVisitsByType(VisitType visitType);
}
