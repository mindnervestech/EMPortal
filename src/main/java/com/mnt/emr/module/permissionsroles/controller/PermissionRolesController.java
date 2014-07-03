package com.mnt.emr.module.permissionsroles.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.mnt.emr.module.common.model.Privileges;
import com.mnt.emr.module.common.model.Role;
import com.mnt.emr.module.common.service.ApplicationService;
import com.mnt.emr.module.doctor.view.DoctorVM;
import com.mnt.emr.module.permissionsroles.view.PermissionVM;
import com.mnt.emr.util.Helper;
import com.mnt.emr.util.Json;

@Controller
public class PermissionRolesController {

	private static String PERMISSION_GRIDCOLUMN_JSON = getStringFromInputStream(Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("permission_grid.json"));
	
	@Autowired
	ApplicationService applicationService;
	
	@RequestMapping(value = "/template/permission.main.html", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("gridData","[]");
		model.addAttribute("gridColumn",PERMISSION_GRIDCOLUMN_JSON);
		return "permission.main.html";
	}
	
	@RequestMapping(value="/getAllPermissionSet", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_SADMIN') or hasRole('ROLE_FADMIN')")
	public @ResponseBody List<PermissionVM>  getAllPermissionSets() {
		List<Role> roles =  applicationService.getAllRolesByFacility(Helper.getCurrentUser().getFacility());
		List<PermissionVM> permissionVMs = Lists.newArrayList();
		
		for(Role _r : roles) {
			List<Privileges> privileges = _r.getRights();
			String permissions = "";
			for(Privileges _p : privileges) {
				permissions += _p.getPermision().getDisplayName() + " | ";
			}
			permissionVMs.add(new PermissionVM(_r.getId(), _r.getName(), permissions));
		}
		return permissionVMs;
	}
	
	@RequestMapping(value = "/add-edit-permission.html/{id}", method = RequestMethod.GET)
	public String displayPermission(@PathVariable Long id, Model model) {
		DoctorVM doctorVM = null;
		if(id == -1) {
			doctorVM = new DoctorVM();
		}
		model.addAttribute("asJson", Json.toJson(doctorVM));
		model.addAttribute("doctor", doctorVM);
		return "add-edit-permission.html";
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
