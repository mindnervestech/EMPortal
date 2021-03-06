package com.mnt.emr.module.common.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

import com.avaje.ebean.Expr;
import com.mnt.emr.module.facility.model.Facility;

@Entity
public class Role extends Model {

	private static Finder<Long, Role> find = new Finder<>(Long.class, Role.class);
	
	@Id
	private Long id;
	
	private String name;
	
	@ManyToOne
	private Facility facility;
	
	@ManyToMany
	public List<Privileges> rights;

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public List<Privileges> getRights() {
		return rights;
	}

	public void setRights(List<Privileges> rights) {
		this.rights = rights;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static List<Privileges> getAllPrivilleges(Long id) {
		return find.byId(id).getRights();
	}
	public static List<Role> getAllRolesByFacility(Facility facility) {
		return find.where().and(Expr.eq("facility", facility), Expr.ne("name", "FADMIN")).findList();
	}
	
	public static List<Role> getAllFacilityAdmins() {
		return find.where().eq("name", "FADMIN").findList();
	}
	
	public static Role findById(Long id) {
		return find.byId(id);
	}
}
