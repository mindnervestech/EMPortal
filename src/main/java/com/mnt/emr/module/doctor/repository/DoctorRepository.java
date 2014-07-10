package com.mnt.emr.module.doctor.repository;

import java.util.List;

import com.mnt.emr.module.doctor.model.Doctor;
import com.mnt.emr.module.doctor.view.DoctorVM;

public interface DoctorRepository {
	Doctor saveDoctor(DoctorVM vm);
	DoctorVM getDoctorVMById(Long id);
	List<DoctorVM> searchDoctorsByFilter(String name, String role, String dob);
	Doctor updateDoctor(DoctorVM doctorVM);
	List<Doctor> getDoctorsByIds(String resourceIds);	
}
