package com.custom.domain;

public enum FacilityStatus {
	APPROVED("Approved"),
	DISAPPROVED("Disapproved");
	
	public String displayValue;
	private FacilityStatus(String displayValue) {
		this.displayValue = displayValue;
	}
}
