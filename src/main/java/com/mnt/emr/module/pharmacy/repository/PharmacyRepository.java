package com.mnt.emr.module.pharmacy.repository;

import java.util.List;

import com.mnt.emr.module.pharmacy.model.Pharmacy;
import com.mnt.emr.module.pharmacy.view.PharmacyVM;


public interface PharmacyRepository {
	Pharmacy savePharmacy(PharmacyVM vm);
	PharmacyVM getPharmacyVMById(Long id);
	List<PharmacyVM> searchPharmacyByFilter(String name, String role, String dob);	
	Pharmacy updatePharmacy(PharmacyVM pharmacyVM);
	void deletePharmacy(PharmacyVM pharmacyVM);
}
