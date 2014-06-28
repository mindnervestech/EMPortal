package com.custom.domain;

public enum UserType {
	NURSE("Nurse"),
	RN("RN"),
	MEDICAL_ASSISTANT("Medical Asst"),
	ADMIN("Admin"),
	BILLING("Billing"),
	LAB("Lab"),
	MEDICAL_REPORTS("Medical Reports"),
	FRONT_DESK("Front Desk");
	
	public String displayValue;
	private UserType(String displayValue) {
		this.displayValue = displayValue;
	}
}
