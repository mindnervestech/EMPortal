package com.mnt.emr.module.role.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mnt.emr.module.role.service.RoleService;
import com.mnt.emr.module.role.view.RoleList;
import com.mnt.emr.module.role.view.RoleVM;
import com.mnt.emr.util.Helper;
import com.mnt.emr.util.Json;

@Controller
public class RoleController {
	
	private static String ROLE_GRIDCOLUMN_JSON = getStringFromInputStream(Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("role_grid.json"));
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value = "/template/role.main.html", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("gridData","[]");
		model.addAttribute("gridColumn",ROLE_GRIDCOLUMN_JSON);
		return "role.main.html";
	}
	
	@RequestMapping(value = "/add-edit-role.html/{id}", method = RequestMethod.GET)
	public String displayRole(@PathVariable Long id, Model model) {
		List<RoleVM> roleVMs = null;
		roleVMs = roleService.getAllRoleVMsByFacility(Helper.getCurrentUser().getFacility());
		model.addAttribute("asJson", Json.toJson(roleVMs));
		
		model.addAttribute("role", roleVMs);
		return "add-edit-role.html";
	}
	
	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> saveRole(@RequestBody RoleList roles) {
		roleService.saveRoles(roles.getRoles(),Helper.getCurrentUser().getFacility());

		Map<String, String> map = new HashMap<>();
		map.put("message", "saved");
		return map;
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
