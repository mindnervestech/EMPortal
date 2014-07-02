package com.mnt.emr.module.patient.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.mnt.emr.module.patient.model.Patient;
import com.mnt.emr.module.patient.service.PatientService;
import com.mnt.emr.module.patient.view.DataReleaseVM;
import com.mnt.emr.module.patient.view.PatientVM;
import com.mnt.emr.module.patient.view.StatsVM;
import com.mnt.emr.util.Json;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PatientController {
	private static String PATIENT_GRIDCOLUMN_JSON = getStringFromInputStream(Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("patient_grid.json"));
	
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	PatientService patientService;
	
	@RequestMapping(value = "/template/patient.main.html", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("gridData","[]");
		model.addAttribute("gridColumn",PATIENT_GRIDCOLUMN_JSON);
		return "patient.main.html";
	}
	
	@RequestMapping(value = "/savePatient", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> savePatient(@RequestBody PatientVM patientVM   ) {
		logger.info("inside save Patient");
		Patient patient = patientService.savePatient(patientVM);
		patientService.savePatientWithMongoDB(patientVM, patient.getId());
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Patient Saved Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/updatePatient", method = RequestMethod.PUT)
	public @ResponseBody Map<String,String> updatePatient(@RequestBody PatientVM patientVM   ) {
		logger.info("inside update dPatient");
		patientService.updatePatient(patientVM);
		System.out.println(patientVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Patient updated Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/patient-search", method = RequestMethod.GET)
	@ResponseBody
	public List<PatientVM> searchPatient(@RequestParam(required=false, value="name") String name, @RequestParam(required=false, value="role") String role, @RequestParam(required=false, value="dob") String dob) {
		return patientService.searchPatientsByFilter(name, role, dob);
	}
	
	@RequestMapping(value="/save-stats", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> saveStas(@RequestBody StatsVM statsVM) {
		logger.info("inside save stast");
		patientService.saveOrUpdateStatsData(statsVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "stast saved Successfully!");
		return message;
	}
	
	@RequestMapping(value="/save-data-release", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> saveDataRelease(@RequestBody DataReleaseVM dataReleaseVM) {
		logger.info("inside save data-release");
		patientService.saveOrUpdateDataReleaseData(dataReleaseVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "data release saved Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/add-edit-patient.html/{id}", method = RequestMethod.GET)
	public String displayPatient(@PathVariable Long id, Model model) {
		PatientVM patientVM = null;
		if(id == -1) {
			patientVM = new PatientVM();
		} else {
			patientVM = patientService.getPatientVMById(id);
		}
		model.addAttribute("asJson", Json.toJson(patientVM));
		model.addAttribute("patient", patientVM);
		return "add-edit-patient.html";
	}
	
	@RequestMapping(value="/savePrimaryInsurance", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> savePrimaryInsurance(@RequestBody PatientVM patientVM   ) {
		logger.info("inside save Patient");
		patientService.savePatient(patientVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Patient Saved Successfully!");
		return message;
	}
	
	private static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
