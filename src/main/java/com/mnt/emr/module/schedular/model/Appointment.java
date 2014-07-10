package com.mnt.emr.module.schedular.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.mnt.emr.module.facility.model.Facility;
import com.mnt.emr.module.schedular.view.AppointmentVM;
import com.mnt.module.appointment.domain.SlotStatus;
import com.mnt.module.appointment.domain.TimeConverter;

@Entity
public class Appointment extends Model {


	// Don't make it Public
	private static Model.Finder<Long,Appointment> find = new Model.Finder<Long,Appointment>(Long.class, Appointment.class);
	
	@Id
	public Long id;
	
	// Day of Appointment 
	public int appointmentDate;
	public int appointmentMonth;
	public int appointmentYear;
	
	//Date fully object 
    public Date appointmentDmy;

	
	//Status of Appointment
	public String status;
	
	// Any Notes attached with appointment
	public String notes;
	
	//visit type of appointment
	public String visitType;
	
	// Start of Time
	public int startMin;
	// Start of End Time
	public int endMin;
	
	
	// Reference to the Object of whom Appointment is. 
	public Long appointmentOfId;
	
	//Object Type of whom Appointment is.
	public String appointmentOfType;
	
	// Reference to the Object with whom Appointment is made. 
	public Long appointmentWithId;
	
	//Object Type with whom Appointment is made.
	public String appointmentWithType;

	public static List<Appointment> getAppointmentSlots(Long appointmentWith_Id,String appointmentWith_Type,Calendar day) {
		return find.where().
			eq("appointmentWithId", appointmentWith_Id).
			eq("appointmentDate", day.get(Calendar.DATE)).
			eq("appointmentMonth", day.get(Calendar.MONTH)).
			eq("appointmentYear", day.get(Calendar.YEAR)).
			eq("appointmentWithType", appointmentWith_Type)
			.findList();
		
	}

	public static Appointment getAppointmentById(Long appointmentId) {
		return find.where().
					eq("id", appointmentId)
					.findUnique();
	}
	
	public static Appointment makeAppointmentOfXForADayY(Long appointmentOf_Id, String appointmentOf_Type, 
			Long appointmentWith_Id, String appointmentWith_Type, int startMin,int endMin, Calendar day, String visitType) {
		
		Appointment partialAppointment = Appointment.getPatialAppointment(startMin, endMin, day, appointmentOf_Id);
		Appointment appointment = null;
		
		if(partialAppointment == null) {
			appointment = new Appointment();
			appointment.appointmentOfId = appointmentOf_Id;
			appointment.appointmentOfType = appointmentOf_Type;
			appointment.appointmentWithId = appointmentWith_Id;
			appointment.appointmentWithType = appointmentWith_Type;
			appointment.appointmentDmy = day.getTime();
			appointment.appointmentDate = day.get(Calendar.DATE);
			appointment.appointmentMonth = day.get(Calendar.MONTH);
			appointment.appointmentYear = day.get(Calendar.YEAR);
			appointment.startMin = startMin;
			appointment.endMin = endMin;
			appointment.status = SlotStatus.PARTIAL.name();
			appointment.visitType = visitType;
			appointment.save();
		}
		
		else {
			partialAppointment.setStatus(SlotStatus.BOOKED.name());
			partialAppointment.update();
			
			appointment = new Appointment();
			appointment.appointmentOfId = appointmentOf_Id;
			appointment.appointmentOfType = appointmentOf_Type;
			appointment.appointmentWithId = appointmentWith_Id;
			appointment.appointmentWithType = appointmentWith_Type;
			appointment.appointmentDmy = day.getTime();
			appointment.appointmentDate = day.get(Calendar.DATE);
			appointment.appointmentMonth = day.get(Calendar.MONTH);
			appointment.appointmentYear = day.get(Calendar.YEAR);
			appointment.startMin = startMin;
			appointment.endMin = endMin;
			appointment.status = SlotStatus.BOOKED.name();
			appointment.visitType = visitType;
			appointment.save();
		}
		return appointment;
	}
	
	public static List<Appointment> getAllAppointments(Long patientId) {
		return find.where().eq("appointmentOf_Id", patientId).findList();
	}
	
	public static List<Appointment> getPastAppointments(Long patientId){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		return find.where().and(Expr.eq("appointmentOf_Id", patientId), Expr.lt("appointmentDmy", calendar.getTime())).findList();
	}
	
	public static List<Appointment> getFutureAppointments(Long patientId){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		return find.where().and(Expr.eq("appointmentOf_Id", patientId), Expr.ge("appointmentDmy", calendar.getTime())).findList();
	}

	public static Appointment getPatialAppointment(int startMin,int endMin, Calendar calendar, Long patientId) {
		return find.where().eq("appointmentOfId", patientId)
						   .eq("appointmentDate", calendar.get(Calendar.DATE))
						   .eq("appointmentMonth", calendar.get(Calendar.MONTH))
						   .eq("appointmentYear", calendar.get(Calendar.YEAR))
						   .eq("startMin", startMin)
						   .eq("endMin", endMin)
						   .eq("status", SlotStatus.PARTIAL.name())
				.findUnique();
	}
	
	public static List<Appointment> getAllAppointmentsXsDayAfter(int... days) {
		
		List<Date> dates = new ArrayList<>();
		for(int day : days) {
			Calendar calendarDayAfter = Calendar.getInstance();
			calendarDayAfter.set(Calendar.HOUR_OF_DAY, 0);
			calendarDayAfter.set(Calendar.MINUTE, 0);
			calendarDayAfter.set(Calendar.SECOND, 0);
			calendarDayAfter.add(Calendar.DATE, day);
			dates.add(calendarDayAfter.getTime());
		}
		List<Appointment> appointments = Appointment.find.where().in("appointmentDmy", dates).findList();
		return appointments;
	}

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

	public int getStartMin() {
		return startMin;
	}

	public void setStartMin(int startMin) {
		this.startMin = startMin;
	}

	public int getEndMin() {
		return endMin;
	}

	public void setEndMin(int endMin) {
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

	public int getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(int appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public int getAppointmentMonth() {
		return appointmentMonth;
	}

	public void setAppointmentMonth(int appointmentMonth) {
		this.appointmentMonth = appointmentMonth;
	}

	public int getAppointmentYear() {
		return appointmentYear;
	}

	public void setAppointmentYear(int appointmentYear) {
		this.appointmentYear = appointmentYear;
	}

	public String getVisitType() {
		return visitType;
	}

	public void setVisitType(String visitType) {
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

	public static List<Appointment> getAllAppointmentsOfFacilityOfDay(
			Facility facility, String resourceIds, Date aptDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(aptDate);
		
		String[] rids = resourceIds.split(",");
		List<Integer> resources = new ArrayList<>();
		for(String s: rids) {
			resources.add(Integer.parseInt(s));
		}
		return find.where().eq("appointmentDate", calendar.get(Calendar.DAY_OF_MONTH))
					.eq("appointmentMonth", calendar.get(Calendar.MONTH))
					.eq("appointmentYear", calendar.get(Calendar.YEAR))
					.in("appointmentWithId", resources)
					.findList();
	}

	public static Appointment updateAppointmentOfXForADayY(AppointmentVM apt) {
		Appointment appointment = Appointment.getAppointmentById(apt.getId());
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(apt.getAppointmentDmy());
		
		int startMin = 0;
		int endMin = 0;
		try {
			startMin = TimeConverter.convertDayTimeToElapsedMin(apt.getStartMin());
			endMin = TimeConverter.convertDayTimeToElapsedMin(apt.getEndMin());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		appointment.setStartMin(startMin);
		appointment.setEndMin(endMin);
		
		appointment.setAppointmentDmy(apt.getAppointmentDmy());
		appointment.setAppointmentDate(calendar.get(Calendar.DAY_OF_MONTH));
		appointment.setAppointmentMonth(calendar.get(Calendar.MONTH));
		appointment.setAppointmentYear(calendar.get(Calendar.YEAR));
		
		appointment.setAppointmentOfId(apt.getAppointmentOfId());
		appointment.setAppointmentOfType(apt.getAppointmentOfType());
		appointment.setAppointmentWithId(apt.getAppointmentWithId());
		appointment.setAppointmentWithType(apt.getAppointmentWithType());
		appointment.setVisitType(apt.getVisitType().toString());
		appointment.setNotes(apt.getNotes());
		appointment.update();
		
		return appointment;
	}

	public static void deleteAppointmentById(Long appointmentId) {
		find.byId(appointmentId).delete();
	}

	public static List<Appointment> getAppointmentsByResources(List<Integer> resourcesIds) {
		return find.where().in("appointmentWithId", resourcesIds).findList();
	}
}
