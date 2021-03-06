package com.mnt.emr.module.patient.view;

public class AddressDetailVM {

	public Long id;
	public String address;
	public String city;
	public String state;
	public String country;
	public String postalCode;
	public boolean isDefaultContact;
	
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
	public boolean isDefaultContact() {
		return isDefaultContact;
	}
	public void setDefaultContact(boolean isDefaultContact) {
		this.isDefaultContact = isDefaultContact;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
