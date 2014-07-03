package com.mnt.emr.module.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.emr.module.common.model.AuthUser;
import com.mnt.emr.module.common.model.Role;
import com.mnt.emr.module.common.repository.ApplicationRepository;
import com.mnt.emr.module.facility.model.Facility;

@Service
public class ApplicationServiceImpl implements ApplicationService{

	@Autowired
	ApplicationRepository applicationRepository;
	
	@Override
	public AuthUser createAuthUserOfFacility(Facility f) {
		return applicationRepository.createAuthUserOfFacility(f);
	}

	@Override
	public void approveFacility(List<Long> ids) {
		applicationRepository.approveFacility(ids);
	}
}
