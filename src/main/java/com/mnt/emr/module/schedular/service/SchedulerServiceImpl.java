package com.mnt.emr.module.schedular.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.emr.module.schedular.model.Appointment;
import com.mnt.emr.module.schedular.repository.SchedulerRepository;
import com.mnt.emr.module.schedular.view.AppointmentVM;
import com.mnt.emr.module.schedular.view.ScheduledEvent;

@Service
public class SchedulerServiceImpl implements SchedulerService {

	@Autowired
	SchedulerRepository schedulerRepository;

	@Override
	public List<AppointmentVM> getAppointmentByDate(Date appointmentDt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment saveAppointment(AppointmentVM appointment) {
		try {
			return schedulerRepository.saveAppointment(appointment);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Appointment updateAppointment(AppointmentVM appointment) {
		return schedulerRepository.updateAppointment(appointment);
	}

	@Override
	public List<AppointmentVM> getAppointmentByMonth(final String month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduledEvent> getAllAppointmetsOfFacilityOfDay(String resourceIds, String fromDate) {
		return schedulerRepository.getAllAppointmetsOfFacilityOfDay(resourceIds, fromDate);
	}

	@Override
	public void deleteAppointmentById(Long appointmentId) {
		schedulerRepository.deleteAppointmentById(appointmentId);
	}

	@Override
	public List<ScheduledEvent> getAppointmentsByResources(List<Integer> resourcesIds) {
		return schedulerRepository.getAppointmentsByResources(resourcesIds);
	}
	

}
