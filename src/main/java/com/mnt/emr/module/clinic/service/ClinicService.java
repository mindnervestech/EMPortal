package com.mnt.emr.module.clinic.service;

import java.util.List;

import com.mnt.emr.module.clinic.model.Clinic;
import com.mnt.emr.module.clinic.view.ClinicVM;

public interface ClinicService {
	Clinic saveClinic(ClinicVM clinicVM);
	ClinicVM getClinicVMById(Long id);	
	List<ClinicVM> searchClinicByFilter(String name, String role, String dob);
	Clinic updateClinic(ClinicVM clinicVM);
	void deleteClinic(ClinicVM clinicVM );
}
