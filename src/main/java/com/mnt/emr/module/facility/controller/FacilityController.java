package com.mnt.emr.module.facility.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.custom.domain.FacilityStatus;
import com.mnt.emr.module.common.EmailTask;
import com.mnt.emr.module.common.model.AuthUser;
import com.mnt.emr.module.common.model.Role;
import com.mnt.emr.module.common.service.ApplicationService;
import com.mnt.emr.module.facility.model.Facility;
import com.mnt.emr.module.facility.service.FacilityService;
import com.mnt.emr.module.facility.view.FacilityVM;
import com.mnt.emr.util.Json;

@Controller
public class FacilityController {
	
	private static String FACILITYGRIDCOLUMN_JSON = getStringFromInputStream(Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("facility_grid.json"));
	
	@Autowired
	FacilityService facilityService;
	
	@Autowired
	ApplicationService applicationService;
	
	
	
	@RequestMapping(value = "/template/facility.main.html", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("gridData","[]");
		model.addAttribute("gridColumn",FACILITYGRIDCOLUMN_JSON);
		return "facility.main.html";
	}
	
	@RequestMapping(value = "/add-edit-facility.html/{id}", method = RequestMethod.GET)
	public String displayFacility(@PathVariable Long id, Model model) {
		FacilityVM facilityVM = null;
		if(id == -1) {
			facilityVM = new FacilityVM();
		} else {
			facilityVM = facilityService.getFacilityVMById(id);
		}
		model.addAttribute("asJson", Json.toJson(facilityVM));
		model.addAttribute("facility", facilityVM);
		return "add-edit-facility.html";
	}
	
	@RequestMapping(value = "/saveFacilityByUser", method = RequestMethod.POST)
	public String saveFacilityByUser(HttpServletRequest request,@ModelAttribute("facility") FacilityVM facility,
			Model model, final RedirectAttributes redirectAttributes)
	{
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6LcZv_QSAAAAAMt9VPCr-_CJ4qusfezix657trSo");
        
		String remoteAddr = request.getRemoteAddr();
        String challengeField = request.getParameter("recaptcha_challenge_field");
        String responseField = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challengeField, responseField);

        if(!reCaptchaResponse.isValid())
        {
        	redirectAttributes.addFlashAttribute("invalidCaptcha", "Captcha Is Invalid");
        	return "redirect:/register";
        }
        
        facilityService.registerFacilityByUser(facility);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/saveFacilityByAdmin", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> saveFacilityByAdmin(HttpServletRequest request,@RequestBody FacilityVM facility,
			Model model, final RedirectAttributes redirectAttributes)
	{
		facility.setStatus(FacilityStatus.APPROVED.name());
		Facility f = facilityService.registerFacilityByAdmin(facility);
		
		applicationService.createAuthUserOfFacility(f);
		
		
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Facility Saved Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registration(Locale locale, Model model) {
		return "registration";
	}
	
	@RequestMapping(value = "/updateFacility", method = RequestMethod.PUT)
	public @ResponseBody Map<String,String> updateFacility(@RequestBody FacilityVM facilityVM   ) {
		facilityService.updateFacility(facilityVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Doctor Saved Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/facility-search", method = RequestMethod.GET)
	public @ResponseBody List<FacilityVM> searchFacility(@RequestParam(required=false, value="facilityName") String name, 
							@RequestParam(required=false, value="role") String role, @RequestParam(required=false, value="dob") String dob) {
		return facilityService.searchFacilitiesByFilter(name, role, dob);
	}

	@RequestMapping(value = "/approveFacility", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> approveFacility(@RequestParam(value="ids") List<Long> ids) {
		applicationService.approveFacility(ids);
		
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Doctor Saved Successfully!");
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
