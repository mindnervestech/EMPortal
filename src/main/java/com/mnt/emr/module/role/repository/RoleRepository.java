package com.mnt.emr.module.role.repository;

import java.util.List;

import com.mnt.emr.module.facility.model.Facility;
import com.mnt.emr.module.role.view.RoleVM;

public interface RoleRepository {
	void saveRoles(List<RoleVM> roles, Facility facility);
	List<RoleVM> getAllRoleVMsByFacility(Facility facility);
}
