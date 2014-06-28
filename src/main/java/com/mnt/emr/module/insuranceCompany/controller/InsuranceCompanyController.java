package com.mnt.emr.module.insuranceCompany.controller;

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

import com.mnt.emr.module.insuranceCompany.service.InsuranceCompanyService;
import com.mnt.emr.module.insuranceCompany.view.InsuranceCompanyVM;
import com.mnt.emr.util.Json;

@Controller
public class InsuranceCompanyController {
	private static String USERGRIDCOLUMN_JSON = getStringFromInputStream(Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("insuranceCompany_grid.json"));
	
	private static final Logger logger = LoggerFactory.getLogger(InsuranceCompanyController.class);
	
	@Autowired
	InsuranceCompanyService insuranceCompanyService;
	@RequestMapping(value = "/saveinsuranceCompany", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> saveinsuranceCompany(@RequestBody InsuranceCompanyVM insuranceCompanyVM   ) {
		logger.info("inside save InsuranceCompany");
		insuranceCompanyService.saveinsuranceCompany(insuranceCompanyVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "Pharmacy Saved Successfully!");
		return message;
	}
	
	
	@RequestMapping(value = "/template/insuranceCompany.main.html", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("gridData","[]");
		model.addAttribute("gridColumn",USERGRIDCOLUMN_JSON);
		return "insuranceCompany.main.html";
	}
	
	@RequestMapping(value = "/insuranceCompany-search", method = RequestMethod.GET)
	@ResponseBody
	public List<InsuranceCompanyVM> searchinsuranceCompany(@RequestParam(required=false, value="name") String name, @RequestParam(required=false, value="roleType") String role, @RequestParam(required=false, value="dob") String dob) {
		return insuranceCompanyService.searchinsuranceCompanyByFilter(name, role, dob);
	}
	
	@RequestMapping(value = "/updateinsuranceCompany", method = RequestMethod.PUT)
	public @ResponseBody Map<String,String> updateinsuranceCompany(@RequestBody InsuranceCompanyVM insuranceCompanyVM   ) {
		logger.info("inside update insuranceCompany");
		insuranceCompanyService.updateinsuranceCompany(insuranceCompanyVM);
		System.out.println(insuranceCompanyVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "insuranceCompany Saved Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/deleteinsuranceCompany", method = RequestMethod.PUT)
	public @ResponseBody Map<String,String> deleteinsuranceCompany(@RequestBody InsuranceCompanyVM insuranceCompanyVM   ) {
		logger.info("inside update insuranceCompany");
		insuranceCompanyService.deleteinsuranceCompany(insuranceCompanyVM);
		System.out.println(insuranceCompanyVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "insuranceCompany Deleted Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/add-edit-insuranceCompany.html/{id}", method = RequestMethod.GET)
	public String displayinsuranceCompany(@PathVariable Long id, Model model) {
		InsuranceCompanyVM insuranceCompanyVM = null;
		if(id == -1) {
			insuranceCompanyVM = new InsuranceCompanyVM();
		} else {
			insuranceCompanyVM = insuranceCompanyService.getinsuranceCompanyVMById(id);
		}
		model.addAttribute("asJson", Json.toJson(insuranceCompanyVM));
		model.addAttribute("insuranceCompany", insuranceCompanyVM);
		return "add-edit-insuranceCompany.html";
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
