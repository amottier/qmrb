package com.quelmarabout.dto;

import java.sql.Time;

public class OpeningHours {
    
    private long id;

    private DaysOfWeek day;

    private Time openingTime;
    
    private int workingTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DaysOfWeek getDay() {
        return day;
    }

    public void setDay(DaysOfWeek day) {
        this.day = day;
    }

    public Time getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Time openingTime) {
        this.openingTime = openingTime;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }
    
    
    
}
