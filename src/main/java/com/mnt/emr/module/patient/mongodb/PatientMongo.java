package com.mnt.emr.module.patient.mongodb;

import java.util.List;

import javax.persistence.Id;

import com.google.common.collect.Lists;
import com.mnt.emr.module.patient.view.DataReleaseVM;
import com.mnt.emr.module.patient.view.InsuranceVM;
import com.mnt.emr.module.patient.view.StatsVM;

public class PatientMongo {
	
	@Id
	public String id;
	
	public Long patientId;
	
	public List<InsuranceVM> insuranceDetails = Lists.newArrayList();
	
	public StatsVM stats;
	
	public DataReleaseVM dataReleaseVM;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<InsuranceVM> getInsuranceDetails() {
		return insuranceDetails;
	}

	public void setInsuranceDetails(List<InsuranceVM> insuranceDetails) {
		this.insuranceDetails = insuranceDetails;
	}

	public StatsVM getStats() {
		return stats;
	}

	public void setStats(StatsVM stats) {
		this.stats = stats;
	}

	public DataReleaseVM getDataReleaseVM() {
		return dataReleaseVM;
	}

	public void setDataReleaseVM(DataReleaseVM dataReleaseVM) {
		this.dataReleaseVM = dataReleaseVM;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
}
