package com.mnt.emr.module.insuranceCompany.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.mnt.emr.module.pharmacy.model.Pharmacy;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class InsuranceCompany extends Model{
	@Id
	public Long id;
	
	public String name;
	public String attn;
	public String address;
	public String address2;
	public String city;
	public String state;
	public String postalCode;
	public String phone;
	public String cmsId;
	public String payerType;
	
	public static Finder<Long, InsuranceCompany> find = new Finder<>(Long.class, InsuranceCompany.class);
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttn() {
		return attn;
	}

	public void setAttn(String attn) {
		this.attn = attn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCmsId() {
		return cmsId;
	}

	public void setCmsId(String cmsId) {
		this.cmsId = cmsId;
	}

	public String getPayerType() {
		return payerType;
	}

	public void setPayerType(String payerType) {
		this.payerType = payerType;
	}

	public static Finder<Long, InsuranceCompany> getFind() {
		return find;
	}

	public static void setFind(Finder<Long, InsuranceCompany> find) {
		InsuranceCompany.find = find;
	}

	public static InsuranceCompany getinsuranceCompanyById(Long id) {
		InsuranceCompany insuranceCompany = InsuranceCompany.find.byId(id);
		return insuranceCompany;
	}


}
