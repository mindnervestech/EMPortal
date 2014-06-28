package com.mnt.emr.module.doctor.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class GroupDetail extends Model {
	
	@Id
	public Long id;
	
	public String groupName;
	public String cliaNumber;
	public String providerNumber;
	public Date effectiveDate;
	public Date expirationDate;
	
	@ManyToOne
	public Doctor doctor;
	
	public static Finder<Long, GroupDetail> find = new Finder<>(Long.class, GroupDetail.class);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCliaNumber() {
		return cliaNumber;
	}

	public void setCliaNumber(String cliaNumber) {
		this.cliaNumber = cliaNumber;
	}

	public String getProviderNumber() {
		return providerNumber;
	}

	public void setProviderNumber(String providernumber) {
		this.providerNumber = providernumber;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
