package com.mnt.emr.module.common.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.custom.domain.FacilityStatus;
import com.custom.domain.UserType;
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
		if(authUser.getRoles() == null) {
			List<Role> roles = new ArrayList<Role>();
			roles.add(role);
			authUser.setRoles(roles);
		} else {
			authUser.getRoles().add(role);
		}
		
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

	@Override
	public List<Role> getAllFacilityAdmins() {
		return Role.getAllFacilityAdmins();
	}

	@Override
	public String getFileForId(Long id) {
		System.out.println(id);
		//File Path fetch Logic here
		return "D://storage//1//user.jpg";
	}

}
