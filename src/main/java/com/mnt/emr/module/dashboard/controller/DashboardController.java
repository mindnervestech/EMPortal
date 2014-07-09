package com.mnt.emr.module.dashboard.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {
	
	private static String DASHBOARDGRIDCOLUMN_JSON = getStringFromInputStream(Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("facility_grid.json"));
	
	@RequestMapping(value = "/template/dashboard.main.html", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("gridData","[]");
		model.addAttribute("gridColumn",DASHBOARDGRIDCOLUMN_JSON);
		return "dashboard.main.html";
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
