package com.mnt.emr.module.common;

import java.security.Principal;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mnt.emr.module.common.model.AuthUser;
import com.mnt.emr.module.common.service.ApplicationService;

import dto.fixtures.MenuBarFixture;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ApplicationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	
	@Autowired
	ApplicationService applicationService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		
		return "login.html";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model) {
		
		return "login.html";
	}
	
	@PreAuthorize("hasPermission(#user, 'userLayout')")
	@RequestMapping(value = "/userLayout", method = RequestMethod.GET)
	public String user(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "userLayout";
	}
	
	@PreAuthorize("hasPermission(#user, 'pharmacyLayout')")
	@RequestMapping(value = "/pharmacyLayout", method = RequestMethod.GET)
	public String pharmacy(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "pharmacyLayout";
	}
	
	@PreAuthorize("hasPermission(#user, 'insuranceCompanyLayout')")
	@RequestMapping(value = "/insuranceCompanyLayout", method = RequestMethod.GET)
	public String insuranceCompany(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "insuranceCompanyLayout";
	}
	
	@PreAuthorize("hasPermission(#user, 'clinicLayout')")
	@RequestMapping(value = "/clinicLayout", method = RequestMethod.GET)
	public String clinic(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "clinicLayout";
	}
	
	@RequestMapping(value = "/doctorLayout", method = RequestMethod.GET)
	@PreAuthorize("hasPermission(#user, 'doctorLayout')")
	public String doctor(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "doctorLayout";
	}
	
	@PreAuthorize("hasPermission(#user, 'schedularLayout')")
	@RequestMapping(value = "/schedularLayout", method = RequestMethod.GET)
	public String schedular(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "schedularLayout";
	}
	
	@PreAuthorize("hasPermission(#user, 'patientLayout')")
	@RequestMapping(value = "/patientLayout", method = RequestMethod.GET)
	public String patient(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		
		return "patientLayout";
	}
	
	@PreAuthorize("hasPermission(#user, 'taskLayout')")
	@RequestMapping(value = "/taskLayout", method = RequestMethod.GET)
	public String task(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		return "taskLayout";
	}
	
	@PreAuthorize("hasPermission(#user, 'facilityLayout')")
	@RequestMapping(value = "/facilityLayout", method = RequestMethod.GET)
	public String facility(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		return "facilityLayout";
	}
	
	@PreAuthorize("hasPermission(#user, 'permissionLayout')")
	@RequestMapping(value = "/permissionLayout", method = RequestMethod.GET)
	public String permission(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		return "permissionLayout";
	}
	
	@PreAuthorize("hasPermission(#user, 'roleLayout')")
	@RequestMapping(value = "/roleLayout", method = RequestMethod.GET)
	public String role(Locale locale, Model model, Principal principal) {
		model.addAttribute("_menuContext", MenuBarFixture.build());
		return "roleLayout";
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
				layout = "dashboard.main.html";
		}
		return layout;
	}
	
	@RequestMapping(value = "/getPatientImageById/{id}", method = RequestMethod.GET)
	public @ResponseBody FileSystemResource getPatientImageById(@PathVariable Long id) {
		return new FileSystemResource(applicationService.getFileForId(id));
	}
}
