package com.mnt.emr.module.doctor.service;

import java.util.List;

import com.mnt.emr.module.doctor.model.Doctor;
import com.mnt.emr.module.doctor.view.DoctorVM;

public interface DoctorService {
	Doctor saveDoctor(DoctorVM doctorVM);
	DoctorVM getDoctorVMById(Long id);	
	List<DoctorVM> searchDoctorsByFilter(String name, String role, String dob);	
	Doctor updateDoctor(DoctorVM doctorVM);
	List<Doctor> getDoctorsByIds(String resourceIds);
}
