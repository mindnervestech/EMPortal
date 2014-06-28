package com.mnt.emr.module.patient.service;

import java.util.List;

import com.mnt.emr.module.patient.model.Patient;
import com.mnt.emr.module.patient.view.PatientVM;

public interface PatientService {
	Patient savePatient(PatientVM patientVM);
	Patient updatePatient(PatientVM patientVM);
	PatientVM getPatientVMById(Long id);
	List<PatientVM> searchPatientsByFilter(String name, String role, String dob);
}
