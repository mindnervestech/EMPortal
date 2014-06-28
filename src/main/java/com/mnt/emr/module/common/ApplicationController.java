package com.mnt.emr.module.common;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.fixtures.MenuBarFixture;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ApplicationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	
	
	
	@RequestMapping(value = "/userLayout", method = RequestMethod.GET)
	public String user(Locale locale, Model model) {
		model.addAttribute("_menuContext", MenuBarFixture.build("dummy"));
		
		return "userLayout";
	}
	
	@RequestMapping(value = "/pharmacyLayout", method = RequestMethod.GET)
	public String pharmacy(Locale locale, Model model) {
		model.addAttribute("_menuContext", MenuBarFixture.build("dummy"));
		
		return "pharmacyLayout";
	}
	
	@RequestMapping(value = "/insuranceCompanyLayout", method = RequestMethod.GET)
	public String insuranceCompany(Locale locale, Model model) {
		model.addAttribute("_menuContext", MenuBarFixture.build("dummy"));
		
		return "insuranceCompanyLayout";
	}
	
	@RequestMapping(value = "/clinicLayout", method = RequestMethod.GET)
	public String clinic(Locale locale, Model model) {
		model.addAttribute("_menuContext", MenuBarFixture.build("dummy"));
		
		return "clinicLayout";
	}
	
	@RequestMapping(value = "/doctorLayout", method = RequestMethod.GET)
	public String doctor(Locale locale, Model model) {
		model.addAttribute("_menuContext", MenuBarFixture.build("dummy"));
		
		return "doctorLayout";
	}
	
	
	@RequestMapping(value = "/patientLayout", method = RequestMethod.GET)
	public String patient(Locale locale, Model model) {
		model.addAttribute("_menuContext", MenuBarFixture.build("dummy"));
		
		return "patientLayout";
	}
	
	@RequestMapping(value = "/taskLayout", method = RequestMethod.GET)
	public String task(Locale locale, Model model) {
		model.addAttribute("_menuContext", MenuBarFixture.build("dummy"));
		
		return "taskLayout";
	}
}
