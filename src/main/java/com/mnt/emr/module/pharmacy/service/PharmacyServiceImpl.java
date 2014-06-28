package com.mnt.emr.module.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.emr.module.pharmacy.model.Pharmacy;
import com.mnt.emr.module.pharmacy.repository.PharmacyRepository;
import com.mnt.emr.module.pharmacy.view.PharmacyVM;

@Service
public class PharmacyServiceImpl implements PharmacyService {
	
	@Autowired
	PharmacyRepository pharmacyRepository;
	
	@Override
	public Pharmacy savePharmacy(PharmacyVM pharmacyVM) {
		return pharmacyRepository.savePharmacy(pharmacyVM);
	}

	@Override
	public PharmacyVM getPharmacyVMById(Long id) {
		return pharmacyRepository.getPharmacyVMById(id);
	}

	@Override
	public List<PharmacyVM> searchPharmacyByFilter(String name, String role, String dob) {
		return pharmacyRepository.searchPharmacyByFilter(name, role, dob);
	}

	@Override
	public Pharmacy updatePharmacy(PharmacyVM pharmacyVM) {
		return pharmacyRepository.updatePharmacy(pharmacyVM);
	}
	
	@Override
	public void deletePharmacy(PharmacyVM pharmacyVM) {
		 pharmacyRepository.deletePharmacy(pharmacyVM);
	}
}
