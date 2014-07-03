package com.mnt.emr.module.facility.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.custom.domain.FacilityStatus;
import com.mnt.emr.module.common.EmailTask;
import com.mnt.emr.module.common.model.AuthUser;
import com.mnt.emr.module.common.model.Role;
import com.mnt.emr.module.common.service.ApplicationService;
import com.mnt.emr.module.facility.model.Facility;
import com.mnt.emr.module.facility.repository.FacilityRepository;
import com.mnt.emr.module.facility.view.FacilityVM;

@Service
public class FacilityServiceImpl implements FacilityService {
	
	@Autowired
	FacilityRepository facilityRepository;
	
	@Autowired
	ApplicationService applicationService;
	
	@Autowired
	@Qualifier("emailTask")
	EmailTask emailTask;
	
	@Override
	public Facility registerFacilityByUser(FacilityVM facility) {
		facility.setStatus(FacilityStatus.DISAPPROVED.name());
		Facility f = registerFacility(facility);
		
		AuthUser au = applicationService.createAuthUserOfFacility(f);
		
		emailTask.sendEmail(au);
		return f;
	}
	
	@Override
	public Facility registerFacilityByAdmin(FacilityVM facility) {
		facility.setStatus(FacilityStatus.APPROVED.name());
		Facility f = registerFacility(facility);
		applicationService.createAuthUserOfFacility(f);
		
		return f;
	}
	
	private Facility registerFacility(FacilityVM facility) {
		return  facilityRepository.saveFacility(facility);
		
	}

	@Override
	public FacilityVM getFacilityVMById(Long id) {
		return facilityRepository.getFacilityVMById(id);
	}

	@Override
	public List<FacilityVM> searchFacilitiesByFilter(String name, String role,
			String dob) {
		return facilityRepository.searchFacilitiesByFilter(name, role, dob);
	}

	@Override
	public Facility updateFacility(FacilityVM facilityVM) {
		return facilityRepository.updateFacility(facilityVM);
	}
}
