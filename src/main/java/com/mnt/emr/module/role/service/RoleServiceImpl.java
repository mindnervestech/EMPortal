package com.mnt.emr.module.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.emr.module.facility.model.Facility;
import com.mnt.emr.module.role.repository.RoleRepository;
import com.mnt.emr.module.role.view.RoleVM;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void saveRoles(List<RoleVM> roles, Facility facility) {
		roleRepository.saveRoles(roles, facility);
	}

	@Override
	public List<RoleVM> getAllRoleVMsByFacility(Facility facility) {
		return roleRepository.getAllRoleVMsByFacility(facility);
	}

}
