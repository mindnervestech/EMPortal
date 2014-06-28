package com.custom.domain;

public enum AllowedScheduledEvent {
	URGENT_VISIT("Urgent Visit"),
	FOLLOW_UP_VISIT("Follow-up Visit"),
	REFERRAL("Referral"),
	DEXA("DEXA"),
	WELLNESS_EXAM("Wellness Exam"),
	YEARLY_PHYSICAL("Yearly Physical");
	
	public String displayValue;
	private AllowedScheduledEvent(String displayValue) {
		this.displayValue = displayValue;
	}
}
