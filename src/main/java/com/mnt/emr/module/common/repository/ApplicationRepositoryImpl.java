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
	public AuthUser createAuthUser(Facility f) {
		AuthUser authUser = new AuthUser();
		authUser.setUsername(f.email);
		try {
			authUser.setPassword(RandomPasswordGenerator.generateRandomString(6, Mode.ALPHANUMERIC));
		} catch (Exception e) {
			e.printStackTrace();
		}
		authUser.setFacility(f);
		authUser.save();
		return authUser;
	}

	@Override
	public Role createRole(Facility f, AuthUser au) {
		Role role = new Role();
		role.setFacility(f);
		role.setName(UserType.FADMIN.name());
		role.save();
		
		List<Role> roles = Lists.newArrayList();
		roles.add(role);
		au.setRoles(roles);
		au.update();
		return role;
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

}
