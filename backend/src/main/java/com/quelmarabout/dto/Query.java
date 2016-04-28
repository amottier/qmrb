package com.quelmarabout.dto;


public class Query {

    private int[] serviceIds;

    private boolean guarantyTimeframe;

    public int[] getServiceIds() {
	return serviceIds;
    }

    public boolean isGuarantyTimeframe() {
	return guarantyTimeframe;
    }

    public void setGuarantyTimeframe(boolean guarantyTimeframe) {
	this.guarantyTimeframe = guarantyTimeframe;
    }

    public void setServiceIds(int[] serviceIds) {
	this.serviceIds = serviceIds;
    }

}
