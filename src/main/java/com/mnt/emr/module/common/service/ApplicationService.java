package com.mnt.emr.module.common.service;

import java.util.List;

import com.mnt.emr.module.common.model.AuthUser;
import com.mnt.emr.module.common.model.Role;
import com.mnt.emr.module.facility.model.Facility;

public interface ApplicationService {
	AuthUser createAuthUser(Facility f);
	Role createRole(Facility f, AuthUser au);
	void approveFacility(List<Long> ids);
}
