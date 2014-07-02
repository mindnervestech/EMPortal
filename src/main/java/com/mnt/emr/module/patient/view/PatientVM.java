package com.mnt.emr.module.patient.view;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

public class PatientVM {
	
	public Long id;
	
	//Basic Details
	public String salutation;
	public String firstName;
	public String middleName;
	public String lastName;
	public String parent;
	public String guardianName;
	public String nickName;
	public String gender;
	public Date dateOfBirth;
	public String ssn;
	
	public List<AddressDetailVM> addressDetails = Lists.newArrayList();
	
	//Contact Details
	public String phoneNumber;
	public String mobileNumber;
	public String email;
	public String preferredCommunication;
	public String emergencyContactName;
	public String emergencyContactNumber;
	
	//Other Details
	public String insuranceCarrier_1_No;
	public String insuranceCarrier_2_No;
	public String insuranceCarrier_1_Name;
	public String insuranceCarrier_2_Name;
	public String ethnicity;
	
	public List<InsuranceVM> insuranceDetails = Lists.newArrayList();
	
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public List<AddressDetailVM> getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(List<AddressDetailVM> addressDetails) {
		this.addressDetails = addressDetails;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPreferredCommunication() {
		return preferredCommunication;
	}
	public void setPreferredCommunication(String preferredCommunication) {
		this.preferredCommunication = preferredCommunication;
	}
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}
	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}
	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}
	public String getInsuranceCarrier_1_No() {
		return insuranceCarrier_1_No;
	}
	public void setInsuranceCarrier_1_No(String insuranceCarrier_1_No) {
		this.insuranceCarrier_1_No = insuranceCarrier_1_No;
	}
	public String getInsuranceCarrier_2_No() {
		return insuranceCarrier_2_No;
	}
	public void setInsuranceCarrier_2_No(String insuranceCarrier_2_No) {
		this.insuranceCarrier_2_No = insuranceCarrier_2_No;
	}
	public String getInsuranceCarrier_1_Name() {
		return insuranceCarrier_1_Name;
	}
	public void setInsuranceCarrier_1_Name(String insuranceCarrier_1_Name) {
		this.insuranceCarrier_1_Name = insuranceCarrier_1_Name;
	}
	public String getInsuranceCarrier_2_Name() {
		return insuranceCarrier_2_Name;
	}
	public void setInsuranceCarrier_2_Name(String insuranceCarrier_2_Name) {
		this.insuranceCarrier_2_Name = insuranceCarrier_2_Name;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<InsuranceVM> getInsuranceDetails() {
		return insuranceDetails;
	}
	public void setInsuranceDetails(List<InsuranceVM> insuranceVMs) {
		this.insuranceDetails = insuranceVMs;
	}
}
