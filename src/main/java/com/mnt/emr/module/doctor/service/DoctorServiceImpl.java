package com.mnt.emr.module.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.emr.module.doctor.model.Doctor;
import com.mnt.emr.module.doctor.repository.DoctorRepository;
import com.mnt.emr.module.doctor.view.DoctorVM;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;
	
	@Override
	public Doctor saveDoctor(DoctorVM doctorVM) {
		return doctorRepository.saveDoctor(doctorVM);
	}

	@Override
	public DoctorVM getDoctorVMById(Long id) {
		return doctorRepository.getDoctorVMById(id);
	}

	@Override
	public List<DoctorVM> searchDoctorsByFilter(String name, String role, String dob) {
		return doctorRepository.searchDoctorsByFilter(name, role, dob);
	}

	@Override
	public Doctor updateDoctor(DoctorVM doctorVM) {
		return doctorRepository.updateDoctor(doctorVM);
	}

}
