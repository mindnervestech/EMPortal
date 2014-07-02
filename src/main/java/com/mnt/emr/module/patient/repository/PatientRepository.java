package com.mnt.emr.module.patient.repository;

import java.util.List;

import com.mnt.emr.module.patient.model.Patient;
import com.mnt.emr.module.patient.view.DataReleaseVM;
import com.mnt.emr.module.patient.view.PatientVM;
import com.mnt.emr.module.patient.view.StatsVM;

public interface PatientRepository {
	Patient savePatient(PatientVM vm);
	Patient updatePatient(PatientVM vm);
	PatientVM getPatientVMById(Long id);
	void saveDataToMongoCollection(String collectionName, String jsonDataToSave);
	List<PatientVM> searchPatientsByFilter(String name, String role, String dob);
	Patient savePatientWithMongoDB(PatientVM vm, Long patientId);
	void saveOrUpdateStatsData(StatsVM statsVM);
	void saveOrUpdatDataReleaseData(DataReleaseVM dataReleaseVM);
}
