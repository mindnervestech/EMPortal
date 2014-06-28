package com.custom.domain;

public enum TaskStatus {
	SEND("SEND"),
	RECEIVE("RECEIVE"),
	COMPLETED("COMPLETED"),
	WAITING_FOR_APPROVAL("WAITING_FOR_APPROVAL"),
	PENDING("PENDING");
	public String displayValue;
	private TaskStatus(String displayValue) {
		this.displayValue = displayValue;
	}
}
