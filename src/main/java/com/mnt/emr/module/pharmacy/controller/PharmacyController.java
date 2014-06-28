package com.mnt.emr.module.pharmacy.controller;

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

import com.mnt.emr.module.pharmacy.service.PharmacyService;
import com.mnt.emr.module.pharmacy.view.PharmacyVM;
import com.mnt.emr.util.Json;

@Controller
public class PharmacyController {
	private static String USERGRIDCOLUMN_JSON = getStringFromInputStream(Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("pharmacy_grid.json"));
	
	private static final Logger logger = LoggerFactory.getLogger(PharmacyController.class);
	
	@Autowired
	PharmacyService pharmacyService;
	@RequestMapping(value = "/savePharmacy", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> savePharmacy(@RequestBody PharmacyVM pharmacyVM   ) {
		logger.info("inside save pharmacy");
		pharmacyService.savePharmacy(pharmacyVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Pharmacy Saved Successfully!");
		return message;
	}
	
	
	@RequestMapping(value = "/template/pharmacy.main.html", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("gridData","[]");
		model.addAttribute("gridColumn",USERGRIDCOLUMN_JSON);
		return "pharmacy.main.html";
	}
	
	@RequestMapping(value = "/pharmacy-search", method = RequestMethod.GET)
	@ResponseBody
	public List<PharmacyVM> searchPharmacy(@RequestParam(required=false, value="name") String name, @RequestParam(required=false, value="roleType") String role, @RequestParam(required=false, value="dob") String dob) {
		return pharmacyService.searchPharmacyByFilter(name, role, dob);
	}
	
	@RequestMapping(value = "/updatePharmacy", method = RequestMethod.PUT)
	public @ResponseBody Map<String,String> updatePharmacy(@RequestBody PharmacyVM pharmacyVM   ) {
		logger.info("inside update pharmacy");
		pharmacyService.updatePharmacy(pharmacyVM);
		System.out.println(pharmacyVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Pharmacy Saved Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/deletePharmacy", method = RequestMethod.PUT)
	public @ResponseBody Map<String,String> deletePharmacy(@RequestBody PharmacyVM pharmacyVM   ) {
		logger.info("inside delete pharmacy");
		pharmacyService.deletePharmacy(pharmacyVM);
		System.out.println(pharmacyVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Pharmacy Deleted Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/add-edit-pharmacy.html/{id}", method = RequestMethod.GET)
	public String displayPharmacy(@PathVariable Long id, Model model) {
		PharmacyVM pharmacyVM = null;
		if(id == -1) {
			pharmacyVM = new PharmacyVM();
		} else {
			pharmacyVM = pharmacyService.getPharmacyVMById(id);
		}
		model.addAttribute("asJson", Json.toJson(pharmacyVM));
		model.addAttribute("pharmacy", pharmacyVM);
		return "add-edit-pharmacy.html";
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
