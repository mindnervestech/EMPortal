package com.mnt.emr.module.schedular.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mnt.emr.module.common.model.AuthUser;
import com.mnt.emr.module.facility.model.Facility;
import com.mnt.emr.module.schedular.model.Appointment;
import com.mnt.emr.module.schedular.view.AppointmentVM;
import com.mnt.emr.module.schedular.view.ScheduledEvent;
import com.mnt.emr.util.Helper;
import com.mnt.module.appointment.domain.TimeConverter;

@Service
public class SchedulerRepositoryImpl implements SchedulerRepository{

	@Override
	public List<Appointment> getAppointmentByDate(Date appointmentDt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getAppointmentByMonth(String month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment saveAppointment(AppointmentVM apt) throws ParseException{
		int startMin = TimeConverter.convertDayTimeToElapsedMin(apt.getStartMin());
		int endMin = TimeConverter.convertDayTimeToElapsedMin(apt.getEndMin());
		Calendar cal = Calendar.getInstance();
		cal.setTime(apt.getAppointmentDmy());
		
		Appointment appointment = Appointment.makeAppointmentOfXForADayY(apt.getAppointmentOfId(), "USER", apt.getAppointmentWithId(),
						"DOCTOR", startMin, endMin, cal, apt.getVisitType().toString());
		return appointment;
	}

	@Override
	public Appointment updateAppointment(AppointmentVM appointment) {
		Appointment appt = Appointment.updateAppointmentOfXForADayY(appointment);
		return appt;
	}

	@Override
	public List<ScheduledEvent> getAllAppointmetsOfFacilityOfDay(String resourceIds,String fromDate) {
		AuthUser authUser = Helper.getCurrentUser();
		Facility facility = authUser.getFacility();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date aptDate = null;
		try {
			aptDate = formatter.parse(fromDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Appointment> appointments = Appointment.getAllAppointmentsOfFacilityOfDay(facility, resourceIds, aptDate);
		formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		List<ScheduledEvent> events = new ArrayList<>();
		
		SimpleDateFormat formatterForText = new SimpleDateFormat("HH:mm");
		for(Appointment a: appointments) {
			ScheduledEvent se = new ScheduledEvent();
			se.setDoctorId(a.getAppointmentWithId().toString());
			se.setEventId(a.getId().toString());
			
			se.setStartDate(formatter.format(a.getAppointmentDmy()));
			
			Date endDate = new Date(a.getAppointmentDmy().getTime() + ((a.getEndMin()-a.getStartMin())*60*1000));
			se.setEndDate(formatter.format(endDate));
			se.setText( formatterForText.format(a.getAppointmentDmy())+ " - " +  formatterForText.format(endDate));
			
			events.add(se);
		}
		return events;
	}

	@Override
	public void deleteAppointmentById(Long appointmentId) {
		Appointment.deleteAppointmentById(appointmentId);
	}

	@Override
	public List<ScheduledEvent> getAppointmentsByResources(List<Integer> resourcesIds) {
		List<Appointment> appointments = Appointment.getAppointmentsByResources(resourcesIds);
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		List<ScheduledEvent> events = new ArrayList<>();
		
		SimpleDateFormat formatterForText = new SimpleDateFormat("HH:mm");
		for(Appointment a: appointments) {
			ScheduledEvent se = new ScheduledEvent();
			se.setDoctorId(a.getAppointmentWithId().toString());
			se.setEventId(a.getId().toString());
			
			se.setStartDate(formatter.format(a.getAppointmentDmy()));
			
			Date endDate = new Date(a.getAppointmentDmy().getTime() + ((a.getEndMin()-a.getStartMin())*60*1000));
			se.setEndDate(formatter.format(endDate));
			se.setText( formatterForText.format(a.getAppointmentDmy())+ " - " +  formatterForText.format(endDate));
			
			events.add(se);
		}
		return events;
	}

}
