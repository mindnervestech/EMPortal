package com.mnt.emr.module.patient.view;

public class DataReleaseVM {
	public Long patientId;
	public String provider;
	public String pharmacy;
	public String hippaNoticeReceived;
	public String allowVoiceMessage;
	public String allowMailMessage;
	public String allowSMS;
	public String allowMail;
	public String leaveMessageWith;
	public String allowImmunizationRegistryUse;
	public String allowImmunizationInfoSharing;
	public String allowHalthInfoExchange;
	public String allowPatientPortal;
	
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}
	public String getHippaNoticeReceived() {
		return hippaNoticeReceived;
	}
	public void setHippaNoticeReceived(String hippaNoticeReceived) {
		this.hippaNoticeReceived = hippaNoticeReceived;
	}
	public String getAllowVoiceMessage() {
		return allowVoiceMessage;
	}
	public void setAllowVoiceMessage(String allowVoiceMessage) {
		this.allowVoiceMessage = allowVoiceMessage;
	}
	public String getAllowMailMessage() {
		return allowMailMessage;
	}
	public void setAllowMailMessage(String allowMailMessage) {
		this.allowMailMessage = allowMailMessage;
	}
	public String getAllowSMS() {
		return allowSMS;
	}
	public void setAllowSMS(String allowSMS) {
		this.allowSMS = allowSMS;
	}
	public String getAllowMail() {
		return allowMail;
	}
	public void setAllowMail(String allowMail) {
		this.allowMail = allowMail;
	}
	public String getLeaveMessageWith() {
		return leaveMessageWith;
	}
	public void setLeaveMessageWith(String leaveMessageWith) {
		this.leaveMessageWith = leaveMessageWith;
	}
	public String getAllowImmunizationRegistryUse() {
		return allowImmunizationRegistryUse;
	}
	public void setAllowImmunizationRegistryUse(String allowImmunizationRegistryUse) {
		this.allowImmunizationRegistryUse = allowImmunizationRegistryUse;
	}
	public String getAllowImmunizationInfoSharing() {
		return allowImmunizationInfoSharing;
	}
	public void setAllowImmunizationInfoSharing(String allowImmunizationInfoSharing) {
		this.allowImmunizationInfoSharing = allowImmunizationInfoSharing;
	}
	public String getAllowHalthInfoExchange() {
		return allowHalthInfoExchange;
	}
	public void setAllowHalthInfoExchange(String allowHalthInfoExchange) {
		this.allowHalthInfoExchange = allowHalthInfoExchange;
	}
	public String getAllowPatientPortal() {
		return allowPatientPortal;
	}
	public void setAllowPatientPortal(String allowPatientPortal) {
		this.allowPatientPortal = allowPatientPortal;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
}
