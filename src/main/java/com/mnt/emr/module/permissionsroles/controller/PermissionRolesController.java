package com.mnt.emr.module.permissionsroles.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avaje.ebean.Ebean;
import com.google.common.collect.Lists;
import com.mnt.emr.module.common.model.Permission;
import com.mnt.emr.module.common.model.Privileges;
import com.mnt.emr.module.common.model.Role;
import com.mnt.emr.module.common.service.ApplicationService;
import com.mnt.emr.module.permissionsroles.view.PermissionListVM;
import com.mnt.emr.module.permissionsroles.view.PermissionModalVM;
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
		List<Role> roles = null;
		if(Helper.getCurrentUser().getFacility().getId() == -1) {
			roles =  applicationService.getAllFacilityAdmins();
		} else {
			roles =  applicationService.getAllRolesByFacility(Helper.getCurrentUser().getFacility());
		}
		
		List<PermissionVM> permissionVMs = Lists.newArrayList();
		
		for(Role _r : roles) {
			List<Privileges> privileges = _r.getRights();
			String permissions = "";
			for(Privileges _p : privileges) {
				if(!_p.getDenied())
					permissions += _p.getPermision().getDisplayName() + " | ";
			}
			permissionVMs.add(new PermissionVM(_r.getId(), _r.getName(), permissions));
		}
		return permissionVMs;
	}
	
	@RequestMapping(value = "/add-edit-permission.html/{id}", method = RequestMethod.GET)
	public String displayPermission(@PathVariable Long id, Model model) {
		List<PermissionModalVM> vmList = Lists.newArrayList();
		List<Permission> permissions = Permission.findAllValidPermissions();
		List<Privileges> rights = Role.getAllPrivilleges(id);
		for(Permission _p : permissions) {
			PermissionModalVM vm = new PermissionModalVM(_p, rights);
			vmList.add(vm);
		}
		model.addAttribute("asJson", Json.toJson(vmList));
		model.addAttribute("permissions", vmList);
		model.addAttribute("role_id", id);
		return "add-edit-permission.html";
	}
	
	@RequestMapping(value = "/savePermission/{rid}", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> savePermissions(@PathVariable Long rid, @RequestBody PermissionListVM modalVMs) {
		Role role = Role.findById(rid);
		List<Privileges> privileges = Role.getAllPrivilleges(rid); 
		privileges.size();
		Ebean.deleteManyToManyAssociations(role, "rights");
		Ebean.delete(privileges);
		
		List<Privileges> rights = Lists.newArrayList();
		
		for(PermissionModalVM vm : modalVMs.getPermissionModalVMs()) {
			Permission p = Permission.findById(vm.getId());
			Privileges pr = new Privileges(p, !vm.isAllowed());
			pr.save();
			rights.add(pr);
		}
		role.setRights(rights);
		role.saveManyToManyAssociations("rights");
		
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
