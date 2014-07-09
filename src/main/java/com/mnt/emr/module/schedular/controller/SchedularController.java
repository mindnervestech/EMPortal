package com.mnt.emr.module.schedular.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.mnt.core.utils.EmrHelper;
import com.mnt.emr.module.doctor.service.DoctorService;
import com.mnt.emr.module.doctor.view.DoctorVM;
import com.mnt.emr.module.patient.model.Patient;
import com.mnt.emr.module.patient.service.PatientService;
import com.mnt.emr.module.patient.view.PatientVM;
import com.mnt.emr.module.schedular.model.Appointment;
import com.mnt.emr.module.schedular.service.SchedulerService;
import com.mnt.emr.module.schedular.view.AppointmentVM;
import com.mnt.emr.module.schedular.view.DoctorResourceVM;
import com.mnt.emr.module.schedular.view.ScheduledEvent;
import com.mnt.emr.util.Json;
import com.mnt.module.appointment.domain.TimeConverter;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SchedularController {

	private static String EVENTS_JSON = EmrHelper.getStringFromInputStream(Thread.currentThread().getContextClassLoader()
			.getResourceAsStream("schedular_events.json"));

	private static String DOCTORS_EVENTS_JSON = EmrHelper.getStringFromInputStream(Thread.currentThread().getContextClassLoader()
			.getResourceAsStream("doctors.json"));

	private static final Logger logger = LoggerFactory.getLogger(SchedularController.class);

	@Autowired
	SchedulerService schedulerService;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	DoctorService doctorService;
	
	@RequestMapping(value = "/template/daily.schedular.main.html", method = RequestMethod.GET)
	public String dailyEvents(Model model) {
		logger.info("inside home of Schedular Controller");
		//call service implementation for fetching details form db.
		List<AppointmentVM> appointmentList = 
				schedulerService.getAppointmentByDate(new Date());
		
		if (appointmentList == null || appointmentList.isEmpty()) {
			AppointmentVM appointmentVm = new AppointmentVM();
			appointmentList = new ArrayList<AppointmentVM>();
			appointmentList.add(appointmentVm);
		}
		
		List<DoctorVM> doctorList = 
				doctorService.searchDoctorsByFilter(null, null, null);
		
		List<DoctorResourceVM> resourceVMs = Lists.newArrayList();
		for(DoctorVM d: doctorList) {
			resourceVMs.add(new DoctorResourceVM(d));
		}
		
		if (doctorList == null || doctorList.isEmpty()) {
			DoctorVM doctorVM = new DoctorVM();
			doctorList.add(doctorVM);
		}
		
		//model.addAttribute("events", Json.toJson(appointmentList));
		model.addAttribute("doctorsEvent", Json.toJson(resourceVMs));
		model.addAttribute("events", EVENTS_JSON);
		//model.addAttribute("doctorsEvent", DOCTORS_EVENTS_JSON);

		return "daily.schedular.main.html";
	}

	@RequestMapping(value = "/template/monthly.schedular.main.html", method = RequestMethod.GET)
	public String monthlyEvents(Model model, @RequestParam final String month) {
		logger.info("inside home of Schedular Controller");

		List<AppointmentVM> monthlyAppointmentList = 
				schedulerService.getAppointmentByMonth(month);
		
		if (monthlyAppointmentList == null || monthlyAppointmentList.isEmpty()) {
			AppointmentVM appointmentVm = new AppointmentVM();
			monthlyAppointmentList = new ArrayList<AppointmentVM>();
			monthlyAppointmentList.add(appointmentVm);
		}
		

		List<DoctorVM> doctorList = 
				doctorService.searchDoctorsByFilter(null, null, null);
		
		if (doctorList == null || doctorList.isEmpty()) {
			DoctorVM doctorVM = new DoctorVM();
			doctorList.add(doctorVM);
		}
		
		//model.addAttribute("events", Json.toJson(monthlyAppointmentList));
		//model.addAttribute("events", Json.toJson(doctorList));
		model.addAttribute("events", EVENTS_JSON);
		model.addAttribute("doctorsEvent", DOCTORS_EVENTS_JSON);

		return "monthly.schedular.main.html";
	}

	@RequestMapping(value = "/add-edit-appointment.html/{id}", method = RequestMethod.GET)
	public String displayAppointmentView(@PathVariable Long id, Model model) {
		AppointmentVM appointmentVm = null;
		PatientVM patientVM = null;
		if (id != -1) {
			Appointment appointment = Appointment.getAppointmentById(id);
			Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
			appointmentVm = mapper.map(appointment, AppointmentVM.class);
			appointmentVm.setStartMin(TimeConverter.convertElapsedMinToDayTime(appointment.getStartMin()));
			appointmentVm.setEndMin(TimeConverter.convertElapsedMinToDayTime(appointment.getEndMin()));
			
			Patient patient = Patient.find.byId(appointment.getAppointmentOfId());
			patientVM =mapper.map(patient, PatientVM.class); 
		} else {
			appointmentVm = new AppointmentVM();
			patientVM = new PatientVM();
		}
		model.addAttribute("appointmentJson", Json.toJson(appointmentVm));
		model.addAttribute("patientJson", Json.toJson(patientVM));
		return "add-edit-appointment.html";
	}

	@RequestMapping(value = "/multiview_schedular", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> multiviewDoctor() {
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "data fetched!");
		return message;
	}
	
	@RequestMapping(value = "/saveAppointment", method = RequestMethod.POST)
	public @ResponseBody ScheduledEvent saveAppointment(@RequestBody AppointmentVM appointmentVM) {
		logger.info("inside save appointment");
		logger.info("Appointment VM " + appointmentVM);
		Appointment app = schedulerService.saveAppointment(appointmentVM);
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		ScheduledEvent se = new ScheduledEvent();
		se.setDoctorId(app.getAppointmentWithId().toString());
		se.setEventId(app.getId().toString());
		se.setStartDate(formatter.format(app.getAppointmentDmy()));
		
		Date endDate = new Date(app.getAppointmentDmy().getTime() + ((app.getEndMin()-app.getStartMin())*60*1000));
		se.setEndDate(formatter.format(endDate));
		
		return se;
	}
	
	@RequestMapping(value="/updateAppointment", method= RequestMethod.PUT)
	public @ResponseBody Map<String,String> updateAppointment(@RequestBody AppointmentVM appointmentVM) {
		logger.info("inside save appointment");
		logger.info("Appointment VM " + appointmentVM);
		schedulerService.updateAppointment(appointmentVM);
		
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "updated!");
		return message;
	}
	
	@RequestMapping(value="/deleteAppointment", method= RequestMethod.DELETE)
	public @ResponseBody Map<String,String> deleteAppointment(@RequestParam(value="appointment_id") Long appointmentId) {
		System.out.println(appointmentId);
		schedulerService.deleteAppointmentById(appointmentId);
		
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "deleted");
		return message;
	}
	
	@RequestMapping(value = "/events/daily", method = RequestMethod.GET)
	public @ResponseBody List<ScheduledEvent> getDailyEventsOfDate(@RequestParam(value="from") String fromDate, @RequestParam(value="to") String toDate) {
		logger.info("inside get appointment");
		logger.info("date::: " + fromDate);
		
		List<ScheduledEvent> events = schedulerService.getAllAppointmetsOfFacilityOfDay(fromDate);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Appointment got Successfully!");
		return events;
	}

	@RequestMapping(value = "/findPatients", method = RequestMethod.GET)
	public @ResponseBody List<PatientVM> searchPatientsByName(@RequestParam String searchParam) {
		logger.info("Searching for patients.");
		List<PatientVM> patientsList = new ArrayList<>();
		patientsList = patientService.searchPatientsByFilter(searchParam, "", "");
		
		if (patientsList.isEmpty()) {
			PatientVM patient = new PatientVM();
			patientsList.add(patient);
		}
		return patientsList;
	}

}