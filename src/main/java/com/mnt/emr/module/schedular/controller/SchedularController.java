package com.mnt.emr.module.schedular.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mnt.core.utils.EmrHelper;

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
	
	@RequestMapping(value = "/template/schedular.main.html", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("inside home of Schedular Controller");
		model.addAttribute("events", EVENTS_JSON);
		model.addAttribute("doctorsEvent", DOCTORS_EVENTS_JSON);
		
		return "schedular.main.html";
	}
	
	@RequestMapping(value = "/template/daily.schedular.main.html", method = RequestMethod.GET)
	public String dailyEvents(Model model) {
		logger.info("inside home of Schedular Controller");
		model.addAttribute("events", EVENTS_JSON);
		model.addAttribute("doctorsEvent", DOCTORS_EVENTS_JSON);
		
		return "daily.schedular.main.html";
	}

	@RequestMapping(value = "/template/monthly.schedular.main.html", method = RequestMethod.GET)
	public String monthlyEvents(Model model) {
		logger.info("inside home of Schedular Controller");
		model.addAttribute("events", EVENTS_JSON);
		model.addAttribute("doctorsEvent", DOCTORS_EVENTS_JSON);
		
		return "monthly.schedular.main.html";
	}
	
	@RequestMapping(value = "/multiview_schedular", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> multiviewDoctor() {
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "data fetched!");
		return message;
	}
	
}
