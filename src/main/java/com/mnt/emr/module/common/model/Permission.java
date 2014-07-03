package com.mnt.emr.module.common.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Permission extends Model {

	private static Finder<Long, Permission> find = new Finder<>(Long.class, Permission.class);
	
	@Id
	private Long id;
	private String name;
	private String displayName;
	private String url;
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public static List<Permission> findAll() {
		return find.all();
	}
	
	public static List<Permission> findAllValidPermissions() {
		return find.where().ne("url", null).findList();
	}
	public static Permission findById(Long id) {
		return find.byId(id);
	}
}
