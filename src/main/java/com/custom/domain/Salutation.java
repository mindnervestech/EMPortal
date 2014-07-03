package com.custom.domain;

public enum Salutation {
	MR("Mr."),
	MISS("Ms."),
	MRS("Mrs.");
	
	public String displayValue;
	private Salutation(String displayValue) {
		this.displayValue = displayValue;
	}
}
