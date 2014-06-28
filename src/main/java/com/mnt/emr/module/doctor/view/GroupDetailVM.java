package com.mnt.emr.module.doctor.view;

import java.util.Date;

public class GroupDetailVM {
	public String groupName;
	public String cliaNumber;
	public String providernumber;
	
	public Date effectiveDate;
	public Date expirationDate;
	
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
	public String getProvidernumber() {
		return providernumber;
	}
	public void setProvidernumber(String providernumber) {
		this.providernumber = providernumber;
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
	
	public GroupDetailVM(String groupName, String cliaNumber,
			String providernumber, Date effectiveDate, Date expirationDate) {
		super();
		this.groupName = groupName;
		this.cliaNumber = cliaNumber;
		this.providernumber = providernumber;
		this.effectiveDate = effectiveDate;
		this.expirationDate = expirationDate;
	}
	public GroupDetailVM(){}
}
