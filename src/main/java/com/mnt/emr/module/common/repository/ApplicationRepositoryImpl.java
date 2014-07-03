package com.mnt.emr.module.common.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.custom.domain.FacilityStatus;
import com.custom.domain.UserType;
import com.google.common.collect.Lists;
import com.mnt.core.utils.RandomPasswordGenerator;
import com.mnt.core.utils.RandomPasswordGenerator.Mode;
import com.mnt.emr.module.common.EmailTask;
import com.mnt.emr.module.common.model.AuthUser;
import com.mnt.emr.module.common.model.Role;
import com.mnt.emr.module.facility.model.Facility;

@Service
public class ApplicationRepositoryImpl implements ApplicationRepository {

	@Autowired
	@Qualifier("emailTask")
	EmailTask emailTask;
	
	@Override
	public AuthUser createAuthUserOfFacility(Facility f) {
		AuthUser authUser = new AuthUser();
		authUser.setUsername(f.email);
		authUser.setPassword(RandomPasswordGenerator.generateRandomString(6, Mode.ALPHANUMERIC));
		authUser.setFacility(f);
		Role role = new Role();
		role.setFacility(f);
		role.setName(UserType.FADMIN.name());
		authUser.getRoles().add(role);
		authUser.save();
		return authUser;
	}

	

	@Override
	public void approveFacility(List<Long> ids) {
		List<Facility> facilities = Facility.getFacilitiesOfIds(ids);
		for(Facility f: facilities) {
			f.setStatus(FacilityStatus.APPROVED);
			f.update();
			AuthUser au = AuthUser.findByFacility(f);
			emailTask.sendEmail(au);
		}
	}
	
	@Override
	public List<Role> getAllRolesByFacility(Facility facility) {
		return Role.getAllRolesByFacility(facility);
	}

}
