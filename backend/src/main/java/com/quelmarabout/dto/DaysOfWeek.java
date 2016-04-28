package com.quelmarabout.dto;

public enum DaysOfWeek {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

    private int id;

    private DaysOfWeek(int id) {
	this.id = id;
    }
    
    public int getId() {
	return id;
    }
    
    public static DaysOfWeek searchForDay(int searchedId) {
	for(DaysOfWeek day : DaysOfWeek.values()) {
	    if (day.getId() == searchedId) {
		return day;
	    }
	}
	
	throw new IllegalArgumentException("No day with id: "+searchedId);
    }
}
