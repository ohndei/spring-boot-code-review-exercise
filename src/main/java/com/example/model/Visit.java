package com.example.model;

import java.time.Instant;

public class Visit {
    private String id;
    private VisitType type;
    private Instant admitTime;
    private Instant dischargeTime;

    public String getId() {
        return id;
    }

    public VisitType getType() {
        return type;
    }

    public Instant getAdmitTime() {
        return admitTime;
    }

    public Instant getDischargeTime() {
        return dischargeTime;
    }
}
