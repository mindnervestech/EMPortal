package com.mnt.emr.module.common;

import java.security.Principal;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mnt.emr.module.common.model.AuthUser;

import dto.fixtures.MenuBarFixture;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ApplicationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		
		return "login.html";
	}
	
	@RequestMapping(value = "/userLayout", method = RequestMethod.GET)
	public String user(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "userLayout";
	}
	
	@RequestMapping(value = "/pharmacyLayout", method = RequestMethod.GET)
	public String pharmacy(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "pharmacyLayout";
	}
	
	@RequestMapping(value = "/insuranceCompanyLayout", method = RequestMethod.GET)
	public String insuranceCompany(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "insuranceCompanyLayout";
	}
	
	@RequestMapping(value = "/clinicLayout", method = RequestMethod.GET)
	public String clinic(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "clinicLayout";
	}
	
	@RequestMapping(value = "/doctorLayout", method = RequestMethod.GET)
	//@PreAuthorize("hasPermission(#user, 'doctorLayout')")
	public String doctor(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "doctorLayout";
	}
	
	@RequestMapping(value = "/schedularLayout", method = RequestMethod.GET)
	public String schedular(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "schedularLayout";
	}
	
	@RequestMapping(value = "/patientLayout", method = RequestMethod.GET)
	public String patient(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "patientLayout";
	}
	
	@RequestMapping(value = "/taskLayout", method = RequestMethod.GET)
	public String task(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		return "taskLayout";
	}
	
	@RequestMapping(value = "/facilityLayout", method = RequestMethod.GET)
	public String facility(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		return "facilityLayout";
	}
	
	@RequestMapping(value = "/permissionLayout", method = RequestMethod.GET)
	public String permission(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		return "permissionLayout";
	}
	
	@RequestMapping(value = "/homeLayout", method = RequestMethod.GET)
	@PreAuthorize("isAuthenticated()")
	public String home(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		String role = ((AuthUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRoles().get(0).getName();
		String layout;
		switch(role) {
			case "DOCTOR" :
				layout = "doctorDasboard";
				break;
			case "NURSE" :
				layout = "nurseDasboard";
				break;
			case "SADMIN" :
				layout = "sadminDasboard";
				break;
			case "FADMIN" :
				layout = "fadminDasboard";
				break;				
			default:
				layout = "homeLayout";
		}
		return layout;
	}
}
