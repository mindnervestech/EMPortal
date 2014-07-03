package com.mnt.emr.module.common.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class Menu extends Model {
	public static Finder<Long, Menu> find = new Finder<>(Long.class, Menu.class);
	
	@Id
	private Long id;
	
	@OneToOne
	private Permission permission;
	
	private Long pid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public static List<Menu> findAll() {
		return find.all();
		
	}
	
	
	

}
