package com.mnt.emr.module.patient.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class SecondaryInsurance extends Model {
	@Id
	public Long id;
	
	public String secondaryInsuranceProvider;
	public String preferredLab;
	public String planName;
	public Date effectiveDate;
	public String policyNo;
	public String groupNo;
	public String copay;
	
	public String employerName;
	public String seAddress;
	public String seCity;
	public String seState;
	public String seZipCode;
	public String seCountry;
	
	public String relationship;
	public String subscriber;
	public Date dob;
	public String gender;
	public String ss;
	public String address;
	public String city;
	public String state;
	public String country;
	public String subscriberPhone;
	public String acceptAssignment;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrimaryInsuranceProvider() {
		return secondaryInsuranceProvider;
	}
	public void setPrimaryInsuranceProvider(String primaryInsuranceProvider) {
		this.secondaryInsuranceProvider = primaryInsuranceProvider;
	}
	public String getPreferredLab() {
		return preferredLab;
	}
	public void setPreferredLab(String preferredLab) {
		this.preferredLab = preferredLab;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	public String getCopay() {
		return copay;
	}
	public void setCopay(String copay) {
		this.copay = copay;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public String getSeAddress() {
		return seAddress;
	}
	public void setSeAddress(String seAddress) {
		this.seAddress = seAddress;
	}
	public String getSeCity() {
		return seCity;
	}
	public void setSeCity(String seCity) {
		this.seCity = seCity;
	}
	public String getSeState() {
		return seState;
	}
	public void setSeState(String seState) {
		this.seState = seState;
	}
	public String getSeZipCode() {
		return seZipCode;
	}
	public void setSeZipCode(String seZipCode) {
		this.seZipCode = seZipCode;
	}
	public String getSeCountry() {
		return seCountry;
	}
	public void setSeCountry(String seCountry) {
		this.seCountry = seCountry;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getSubscriberPhone() {
		return subscriberPhone;
	}
	public void setSubscriberPhone(String subscriberPhone) {
		this.subscriberPhone = subscriberPhone;
	}
	public String getAcceptAssignment() {
		return acceptAssignment;
	}
	public void setAcceptAssignment(String acceptAssignment) {
		this.acceptAssignment = acceptAssignment;
	}
}
