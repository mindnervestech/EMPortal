package com.mnt.emr.module.doctor.view;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

public class DoctorVM {
	
	public Long id;
	
	public String salutation;
	public String firstName;
	public String middleName;
	public String lastName;
	public String gender;
	public Date dateOfBirth;
	
	//Contact Details
	public String address;
	public String city;
	public String state;
	public String country;
	public String postalCode;
	public String contactNumber;
	public String email;
	
	//Professional Details
	public String primarySpeciality;
	public String secondarySpeciality;
	public String professionalQualification;
	public String employmentStatus;
	public String professionalRegNo;
	public String federalEin;
	public String ssn;
	public String npi;
	public String dea;
	public String stateLicense;
	public String upin;
	public String taxanomy;
	
	//group Details
	public List<GroupDetailVM> groupDetails = Lists.newArrayList();
	
	//Other Details
	public String renderingProvider;
	public String doctorColor;
	public String signature;
	public String signatureText;
	public List<String> allowedScheduledEvent;
	public boolean isExternalRefer;
	public boolean isAdmin;
	
	public String bio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimarySpeciality() {
		return primarySpeciality;
	}

	public void setPrimarySpeciality(String primarySpeciality) {
		this.primarySpeciality = primarySpeciality;
	}

	public String getSecondarySpeciality() {
		return secondarySpeciality;
	}

	public void setSecondarySpeciality(String secondarySpeciality) {
		this.secondarySpeciality = secondarySpeciality;
	}

	public String getProfessionalQualification() {
		return professionalQualification;
	}

	public void setProfessionalQualification(String professionalQualification) {
		this.professionalQualification = professionalQualification;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getProfessionalRegNo() {
		return professionalRegNo;
	}

	public void setProfessionalRegNo(String professionalRegNo) {
		this.professionalRegNo = professionalRegNo;
	}

	public String getFederalEin() {
		return federalEin;
	}

	public void setFederalEin(String federalEin) {
		this.federalEin = federalEin;
	}

	public String getStateLicense() {
		return stateLicense;
	}

	public void setStateLicense(String stateLicense) {
		this.stateLicense = stateLicense;
	}

	public String getTaxanomy() {
		return taxanomy;
	}

	public void setTaxanomy(String taxanomy) {
		this.taxanomy = taxanomy;
	}

	public List<GroupDetailVM> getGroupDetails() {
		return groupDetails;
	}

	public void setGroupDetails(List<GroupDetailVM> groupDetails) {
		this.groupDetails = groupDetails;
	}

	public String getRenderingProvider() {
		return renderingProvider;
	}

	public void setRenderingProvider(String renderingProvider) {
		this.renderingProvider = renderingProvider;
	}

	public String getDoctorColor() {
		return doctorColor;
	}

	public void setDoctorColor(String doctorColor) {
		this.doctorColor = doctorColor;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getSignatureText() {
		return signatureText;
	}

	public void setSignatureText(String signatureText) {
		this.signatureText = signatureText;
	}

	public List<String> getAllowedScheduledEvent() {
		return allowedScheduledEvent;
	}

	public void setAllowedScheduledEvent(List<String> allowedScheduledEvent) {
		this.allowedScheduledEvent = allowedScheduledEvent;
	}

	public boolean isExternalRefer() {
		return isExternalRefer;
	}

	public void setExternalRefer(boolean isExternalRefer) {
		this.isExternalRefer = isExternalRefer;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getNpi() {
		return npi;
	}

	public void setNpi(String npi) {
		this.npi = npi;
	}

	public String getDea() {
		return dea;
	}

	public void setDea(String dea) {
		this.dea = dea;
	}

	public String getUpin() {
		return upin;
	}

	public void setUpin(String upin) {
		this.upin = upin;
	}
}
