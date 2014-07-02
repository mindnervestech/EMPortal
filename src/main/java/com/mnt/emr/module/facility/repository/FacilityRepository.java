package com.mnt.emr.module.facility.repository;

import java.util.List;

import com.mnt.emr.module.facility.model.Facility;
import com.mnt.emr.module.facility.view.FacilityVM;

public interface FacilityRepository {
	Facility saveFacility(FacilityVM facility);
	FacilityVM getFacilityVMById(Long id);
	List<FacilityVM> searchFacilitiesByFilter(String name, String role,	String dob);
	Facility updateFacility(FacilityVM facilityVM);
}
