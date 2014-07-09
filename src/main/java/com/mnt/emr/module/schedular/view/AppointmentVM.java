package com.mnt.emr.module.schedular.view;

import java.util.Date;

public class AppointmentVM{

	public Long id;
	
	//Date fully object 
    public Date appointmentDmy;

	//Status of Appointment
	public String status;
	
	// Any Notes attached with appointment
	public String notes;
	
	//visit type of appointment
	public Long visitType;
	
	// Start of Time
	public String startMin;
	// Start of End Time
	public String endMin;
	
	// Reference to the Object of whom Appointment is. 
	public Long appointmentOfId;
	
	//Object Type of whom Appointment is.
	public String appointmentOfType;
	
	// Reference to the Object with whom Appointment is made. 
	public Long appointmentWithId;
	
	//Object Type with whom Appointment is made.
	public String appointmentWithType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStartMin() {
		return startMin;
	}

	public void setStartMin(String startMin) {
		this.startMin = startMin;
	}

	public String getEndMin() {
		return endMin;
	}

	public void setEndMin(String endMin) {
		this.endMin = endMin;
	}

	public Long getAppointmentOfId() {
		return appointmentOfId;
	}

	public Date getAppointmentDmy() {
		return appointmentDmy;
	}

	public void setAppointmentDmy(Date appointmentDmy) {
		this.appointmentDmy = appointmentDmy;
	}

	public Long getVisitType() {
		return visitType;
	}

	public void setVisitType(Long visitType) {
		this.visitType = visitType;
	}

	public String getAppointmentOfType() {
		return appointmentOfType;
	}

	public void setAppointmentOfType(String appointmentOfType) {
		this.appointmentOfType = appointmentOfType;
	}

	public Long getAppointmentWithId() {
		return appointmentWithId;
	}

	public void setAppointmentWithId(Long appointmentWithId) {
		this.appointmentWithId = appointmentWithId;
	}

	public String getAppointmentWithType() {
		return appointmentWithType;
	}

	public void setAppointmentWithType(String appointmentWithType) {
		this.appointmentWithType = appointmentWithType;
	}

	public void setAppointmentOfId(Long appointmentOfId) {
		this.appointmentOfId = appointmentOfId;
	}
}
