package com.mnt.emr.module.schedular.view;

import org.codehaus.jackson.annotate.JsonProperty;



public class ScheduledEvent {
	
	private String eventId;
	private String text;
	
	@JsonProperty(value="start_date")
	private String startDate;
	
	@JsonProperty(value="end_date")
	private String endDate;
	
	@JsonProperty(value="doctor_id")
	private String doctorId;
	
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}	
}