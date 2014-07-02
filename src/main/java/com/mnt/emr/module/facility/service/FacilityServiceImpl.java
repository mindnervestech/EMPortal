package com.mnt.emr.module.facility.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.emr.module.facility.model.Facility;
import com.mnt.emr.module.facility.repository.FacilityRepository;
import com.mnt.emr.module.facility.view.FacilityVM;

@Service
public class FacilityServiceImpl implements FacilityService {
	
	@Autowired
	FacilityRepository facilityRepository;
	
	@Override
	public Facility saveFacility(FacilityVM facility) {
		return facilityRepository.saveFacility(facility);
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
