package com.mnt.emr.module.doctor.controller;

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

import com.mnt.emr.module.doctor.service.DoctorService;
import com.mnt.emr.module.doctor.view.DoctorVM;
import com.mnt.emr.util.Json;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DoctorController {
	private static String USERGRIDCOLUMN_JSON = getStringFromInputStream(Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("doctor_grid.json"));
	
	private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	DoctorService doctorService;
	
	@RequestMapping(value = "/template/doctor.main.html", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("gridData","[]");
		model.addAttribute("gridColumn",USERGRIDCOLUMN_JSON);
		return "doctor.main.html";
	}
	
	@RequestMapping(value = "/saveDoctor", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> saveDoctor(@RequestBody DoctorVM doctorVM   ) {
		logger.info("inside save doctor");
		doctorService.saveDoctor(doctorVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Doctor Saved Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/updateDoctor", method = RequestMethod.PUT)
	public @ResponseBody Map<String,String> updateDoctor(@RequestBody DoctorVM doctorVM   ) {
		logger.info("inside update doctor");
		doctorService.updateDoctor(doctorVM);
		System.out.println(doctorVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Doctor Saved Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/doctor-search", method = RequestMethod.GET)
	@ResponseBody
	public List<DoctorVM> searchDoctor(@RequestParam(required=false, value="name") String name, @RequestParam(required=false, value="role") String role, @RequestParam(required=false, value="dob") String dob) {
		return doctorService.searchDoctorsByFilter(name, role, dob);
	}
	
	@RequestMapping(value = "/add-edit-doctor.html/{id}", method = RequestMethod.GET)
	public String displayDoctor(@PathVariable Long id, Model model) {
		DoctorVM doctorVM = null;
		if(id == -1) {
			doctorVM = new DoctorVM();
		} else {
			doctorVM = doctorService.getDoctorVMById(id);
		}
		model.addAttribute("asJson", Json.toJson(doctorVM));
		model.addAttribute("doctor", doctorVM);
		return "add-edit-doctor.html";
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
