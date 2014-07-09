package com.mnt.emr.module.schedular.repository;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.mnt.emr.module.schedular.model.Appointment;
import com.mnt.emr.module.schedular.view.AppointmentVM;
import com.mnt.emr.module.schedular.view.ScheduledEvent;

public interface SchedulerRepository {
	
	List<Appointment> getAppointmentByDate(Date appointmentDt);
	List<Appointment> getAppointmentByMonth(final String month);
	Appointment saveAppointment(AppointmentVM appointment) throws ParseException;
	Appointment updateAppointment(AppointmentVM appointment);
	List<ScheduledEvent> getAllAppointmetsOfFacilityOfDay(String fromDate);
	void deleteAppointmentById(Long appointmentId);
	
}
