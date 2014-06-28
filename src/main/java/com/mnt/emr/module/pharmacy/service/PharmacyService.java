package com.mnt.emr.module.pharmacy.service;

import java.util.List;

import com.mnt.emr.module.pharmacy.model.Pharmacy;
import com.mnt.emr.module.pharmacy.view.PharmacyVM;

public interface PharmacyService {
	Pharmacy savePharmacy(PharmacyVM pharmacyVM);
	PharmacyVM getPharmacyVMById(Long id);	
	List<PharmacyVM> searchPharmacyByFilter(String name, String role, String dob);
	Pharmacy updatePharmacy(PharmacyVM pharmacyVM);
	void deletePharmacy(PharmacyVM pharmacyVM );
}
