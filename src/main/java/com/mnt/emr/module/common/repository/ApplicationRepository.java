package com.mnt.emr.module.common.repository;

import java.util.List;

import com.mnt.emr.module.common.model.AuthUser;
import com.mnt.emr.module.common.model.Role;
import com.mnt.emr.module.facility.model.Facility;

public interface ApplicationRepository {
	AuthUser createAuthUserOfFacility(Facility f);
	void approveFacility(List<Long> ids);
	List<Role> getAllRolesByFacility(Facility facility);
	List<Role> getAllFacilityAdmins();
	String getFileForId(Long id);
}
