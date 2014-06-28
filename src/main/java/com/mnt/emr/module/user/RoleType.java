package com.mnt.emr.module.user;

public enum RoleType {
	DOCTOR("Doctor"),
	NURSE("Nurse"),
	PATIENT("Patient"),
	USER("User");
	
	public String displayValue;
	private RoleType(String displayValue) {
		this.displayValue = displayValue;
	}
	
	
	
}
