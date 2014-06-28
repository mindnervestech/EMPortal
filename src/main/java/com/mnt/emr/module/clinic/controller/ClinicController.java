package com.mnt.emr.module.clinic.controller;

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

import com.mnt.emr.module.clinic.service.ClinicService;
import com.mnt.emr.module.clinic.view.ClinicVM;
import com.mnt.emr.util.Json;

@Controller
public class ClinicController {
	private static String USERGRIDCOLUMN_JSON = getStringFromInputStream(Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("clinic_grid.json"));
	
	private static final Logger logger = LoggerFactory.getLogger(ClinicController.class);
	
	@Autowired
	ClinicService clinicService;
	@RequestMapping(value = "/saveClinic", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> saveClinic(@RequestBody ClinicVM clinicVM   ) {
		logger.info("inside save clinic");
		clinicService.saveClinic(clinicVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Clinic Saved Successfully!");
		return message;
	}
	
	
	@RequestMapping(value = "/template/clinic.main.html", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("gridData","[]");
		model.addAttribute("gridColumn",USERGRIDCOLUMN_JSON);
		return "clinic.main.html";
	}
	
	@RequestMapping(value = "/clinic-search", method = RequestMethod.GET)
	@ResponseBody
	public List<ClinicVM> searchClinic(@RequestParam(required=false, value="name") String name, @RequestParam(required=false, value="roleType") String role, @RequestParam(required=false, value="dob") String dob) {
		return clinicService.searchClinicByFilter(name, role, dob);
	}
	
	@RequestMapping(value = "/updateClinic", method = RequestMethod.PUT)
	public @ResponseBody Map<String,String> updatePharmacy(@RequestBody ClinicVM clinicVM   ) {
		logger.info("inside update clinic");
		clinicService.updateClinic(clinicVM);
		System.out.println(clinicVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "clinic Saved Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/deleteClinic", method = RequestMethod.PUT)
	public @ResponseBody Map<String,String> deleteClinic(@RequestBody ClinicVM clinicVM   ) {
		logger.info("inside delete clinic");
		clinicService.deleteClinic(clinicVM);
		System.out.println(clinicVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "clinic Deleted Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/add-edit-clinic.html/{id}", method = RequestMethod.GET)
	public String displayClinic(@PathVariable Long id, Model model) {
		ClinicVM clinicVM = null;
		if(id == -1) {
			clinicVM = new ClinicVM();
		} else {
			clinicVM = clinicService.getClinicVMById(id);
		}
		model.addAttribute("asJson", Json.toJson(clinicVM));
		model.addAttribute("clinic", clinicVM);
		return "add-edit-clinic.html";
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
