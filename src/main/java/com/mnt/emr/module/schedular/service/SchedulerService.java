package com.mnt.emr.module.schedular.service;

import java.util.Date;
import java.util.List;

import com.mnt.emr.module.schedular.model.Appointment;
import com.mnt.emr.module.schedular.view.AppointmentVM;
import com.mnt.emr.module.schedular.view.ScheduledEvent;

public interface SchedulerService {
	
	List<AppointmentVM> getAppointmentByDate(Date appointmentDt);
	List<AppointmentVM> getAppointmentByMonth(final String month);
	Appointment saveAppointment(AppointmentVM appointment);
	Appointment updateAppointment(AppointmentVM appointment);
	List<ScheduledEvent> getAllAppointmetsOfFacilityOfDay(String fromDate);
	void deleteAppointmentById(Long appointmentId);
	
}
