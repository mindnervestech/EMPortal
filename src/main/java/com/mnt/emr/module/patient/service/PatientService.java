package com.mnt.emr.module.patient.service;

import java.util.List;

import com.mnt.emr.module.patient.model.Patient;
import com.mnt.emr.module.patient.view.DataReleaseVM;
import com.mnt.emr.module.patient.view.PatientVM;
import com.mnt.emr.module.patient.view.StatsVM;

public interface PatientService {
	Patient savePatient(PatientVM patientVM);
	Patient updatePatient(PatientVM patientVM);
	PatientVM getPatientVMById(Long id);
	List<PatientVM> searchPatientsByFilter(String name, String role, String dob);
	Patient savePatientWithMongoDB(PatientVM patientVM, Long patientId);
	void saveOrUpdateStatsData(StatsVM statsVM);
	void saveOrUpdateDataReleaseData(DataReleaseVM dataReleaseVM);
}
