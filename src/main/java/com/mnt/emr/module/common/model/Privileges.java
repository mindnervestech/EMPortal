package com.mnt.emr.module.common.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Privileges extends Model {
	
	@Id
	private Long id;
	
	private String name;
	
	private Boolean isRead = false;
	private Boolean isWrite = false;
	private Boolean isDenied = true;
	
	@ManyToOne
	private Permission permision;
	
	public Privileges(){}
	public Privileges(Permission permision, Boolean isDenied) {
		this.permision = permision;
		if(isDenied == false) {
			this.isWrite = false;
			this.isDenied =false;
		}
	}
	
	public void setReadOnlyRights() {
		this.isRead = true;
		this.isWrite = false;
		this.isDenied = false;
	}
	
	public void setWriteRights() {
		this.isRead = true;
		this.isWrite = true;
		this.isDenied = false;
	}
	
	public void setDeniedRights() {
		this.isRead = false;
		this.isWrite = false;
		this.isDenied = true;
	}
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
	public Boolean getRead() {
		return isRead;
	}
	public void setRead(Boolean isRead) {
		this.isRead = isRead;
	}
	public Boolean getWrite() {
		return isWrite;
	}
	public void setWrite(Boolean isWrite) {
		this.isWrite = isWrite;
	}
	public Boolean getDenied() {
		return isDenied;
	}
	public void setDenied(Boolean isDenied) {
		this.isDenied = isDenied;
	}
	public Permission getPermision() {
		return permision;
	}
	public void setPermision(Permission permision) {
		this.permision = permision;
	}
	

}
