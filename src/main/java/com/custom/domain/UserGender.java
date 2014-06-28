package com.custom.domain;

public enum UserGender {
	MALE("Male"),
	FEMALE("Female");
	
	public String displayValue;
	private UserGender(String displayValue) {
		this.displayValue = displayValue;
	}
}
