package com.custom.domain;

public enum TaskPriority {
	URGENT("URGENT"),
	HIGH("HIGH"),
	MEDIUM("MEDIUM"),
	LOW("LOW");	
	public String displayValue;
	private TaskPriority(String displayValue) {
		this.displayValue = displayValue;
	}
}
