package com.mnt.emr.module.patient.repository;

import java.util.List;

import com.mnt.emr.module.patient.model.Patient;
import com.mnt.emr.module.patient.view.PatientVM;

public interface PatientRepository {
	Patient savePatient(PatientVM vm);
	Patient updatePatient(PatientVM vm);
	PatientVM getPatientVMById(Long id);
	void saveDataToMongoCollection(String collectionName, String jsonDataToSave);
	List<PatientVM> searchPatientsByFilter(String name, String role, String dob);
}
