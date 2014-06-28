package com.custom.domain;

public enum Ethnicity {
	WHITE_CAUCASINE("White-Caucasine"),
	AFRICAN_AMERICAN("African American"),
	ASIAN("Asian"),
	HISPANIC_OR_LATINO("Hispanic or Latino");
	
	public String displayValue;
	private Ethnicity(String displayValue) {
		this.displayValue = displayValue;
	}
}
