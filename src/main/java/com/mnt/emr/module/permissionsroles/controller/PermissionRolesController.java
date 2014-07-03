package com.mnt.emr.module.permissionsroles.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mnt.emr.module.common.model.Permission;
import com.mnt.emr.module.common.model.Role;
import com.mnt.emr.module.common.service.ApplicationService;
import com.mnt.emr.util.Helper;

@Controller
public class PermissionRolesController {

	@Autowired
	ApplicationService applicationService;
	
	@RequestMapping(value="/getAllPermissionSet", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_SADMIN') or hasRole('ROLE_FADMIN')")
	public void getAllPermissionSets() {
		List<Role> roles =  applicationService.getAllRolesByFacility(Helper.getCurrentUser().getFacility());
		
	}
}
