package com.mnt.emr.module.patient.view;

import java.util.Date;

import javax.persistence.Transient;

public class StatsVM{
	
	@Transient
	public Long patientId;
	
	public String language;
	public String race;
	public Date financialReviewDate;
	public Integer familySize;
	public Double monthlyIncome;
	public String homeLessEtc;
	public String interpreter;
	public String migrantOrSeasonal;
	public String referalSource;
	public String vfc;
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public Date getFinancialReviewDate() {
		return financialReviewDate;
	}
	public void setFinancialReviewDate(Date financialReviewDate) {
		this.financialReviewDate = financialReviewDate;
	}
	public Integer getFamilySize() {
		return familySize;
	}
	public void setFamilySize(Integer familySize) {
		this.familySize = familySize;
	}
	public Double getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(Double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public String getHomeLessEtc() {
		return homeLessEtc;
	}
	public void setHomeLessEtc(String homeLessEtc) {
		this.homeLessEtc = homeLessEtc;
	}
	public String getInterpreter() {
		return interpreter;
	}
	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}
	public String getMigrantOrSeasonal() {
		return migrantOrSeasonal;
	}
	public void setMigrantOrSeasonal(String migrantOrSeasonal) {
		this.migrantOrSeasonal = migrantOrSeasonal;
	}
	public String getReferalSource() {
		return referalSource;
	}
	public void setReferalSource(String referalSource) {
		this.referalSource = referalSource;
	}
	public String getVfc() {
		return vfc;
	}
	public void setVfc(String vfc) {
		this.vfc = vfc;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
}
