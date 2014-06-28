package com.mnt.emr.module.clinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.emr.module.clinic.model.Clinic;
import com.mnt.emr.module.clinic.repository.ClinicRepository;
import com.mnt.emr.module.clinic.view.ClinicVM;


@Service
public class ClinicServiceImpl implements ClinicService {
	@Autowired
	ClinicRepository clinicRepository;
	
	@Override
	public Clinic saveClinic(ClinicVM clinicVM) {
		return clinicRepository.saveClinic(clinicVM);
	}

	@Override
	public ClinicVM getClinicVMById(Long id) {
		return clinicRepository.getClinicVMById(id);
	}

	@Override
	public List<ClinicVM> searchClinicByFilter(String name, String role, String dob) {
		return clinicRepository.searchClinicByFilter(name, role, dob);
	}

	@Override
	public Clinic updateClinic(ClinicVM clinicVM) {
		return clinicRepository.updateClinic(clinicVM);
	}
	
	@Override
	public void deleteClinic(ClinicVM clinicVM) {
		 clinicRepository.deleteClinic(clinicVM);
	}
}
