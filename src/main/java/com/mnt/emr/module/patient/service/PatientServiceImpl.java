package com.mnt.emr.module.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.emr.module.patient.model.Patient;
import com.mnt.emr.module.patient.repository.PatientRepository;
import com.mnt.emr.module.patient.view.DataReleaseVM;
import com.mnt.emr.module.patient.view.PatientVM;
import com.mnt.emr.module.patient.view.StatsVM;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	@Override
	public Patient savePatient(PatientVM patientVM) {
		return patientRepository.savePatient(patientVM);
	}

	@Override
	public PatientVM getPatientVMById(Long id) {
		return patientRepository.getPatientVMById(id);
	}

	@Override
	public List<PatientVM> searchPatientsByFilter(String name, String role,
			String dob) {
		return patientRepository.searchPatientsByFilter(name, role, dob);
	}

	@Override
	public Patient updatePatient(PatientVM patientVM) {
		return patientRepository.updatePatient(patientVM);
	}

	@Override
	public Patient savePatientWithMongoDB(PatientVM patientVM, Long patientId) {
		return patientRepository.savePatientWithMongoDB(patientVM, patientId);
	}

	@Override
	public void saveOrUpdateStatsData(StatsVM statsVM) {
		patientRepository.saveOrUpdateStatsData(statsVM);
	}

	@Override
	public void saveOrUpdateDataReleaseData(DataReleaseVM dataReleaseVM) {
		patientRepository.saveOrUpdatDataReleaseData(dataReleaseVM);
	}

}
