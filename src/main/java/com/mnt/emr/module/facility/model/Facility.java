package com.mnt.emr.module.facility.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import play.db.ebean.Model;

import com.custom.domain.FacilityStatus;

@Entity
public class Facility extends Model {
	
	@Id
	public Long id;
	
	public String facilityName;
	public String salutation;
	public String contactName;
	public String address1;
	public String address2;
	
	public String city;
	public String state;
	public String country;
	public String zipCode;
	public String relativeUrl;
	public String website;
	public String email;
	
	@Enumerated(EnumType.STRING)
	public FacilityStatus status;
	
	public static Finder<Long, Facility> find = new Finder<Long, Facility>(Long.class, Facility.class);

	public static Facility getFacilityById(Long id) {
		return find.byId(id);
	}
	
	public static List<Facility> getFacilitiesOfIds(List<Long> ids) {
		return find.where().idIn(ids).findList();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getRelativeUrl() {
		return relativeUrl;
	}

	public void setRelativeUrl(String relativeUrl) {
		this.relativeUrl = relativeUrl;
	}

	public FacilityStatus getStatus() {
		return status;
	}

	public void setStatus(FacilityStatus status) {
		this.status = status;
	}
	
}
