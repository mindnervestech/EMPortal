package com.mnt.emr.module.common.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import play.db.ebean.Model;

import com.avaje.ebean.Expr;
import com.mnt.emr.module.common.PermissionAuthority;
import com.mnt.emr.module.facility.model.Facility;
import com.mnt.emr.module.user.model.UserProfile;

@Entity
public class AuthUser extends Model implements  UserDetails {

	@Id
	private Long id;
	
	public static Finder<Long, AuthUser> find = new Finder<>(Long.class, AuthUser.class);
	
	private String password;
	private String username;
	@ManyToMany
	private List<Role> roles; 
	
	@ManyToOne
	private Facility facility;
	
	@OneToOne
	public UserProfile userProfile;
	
	@Transient
	private Map<String, Privileges> privilegeMap= new HashMap<>();
	private boolean enabled;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<PermissionAuthority> authorities = new HashSet<PermissionAuthority>();
		for(Role _r: getRoles()) {
			PermissionAuthority produxAuthority = new PermissionAuthority(_r.getName());
	        authorities.add(produxAuthority);
	        
	        for(Privileges p : _r.getRights()) {
	        	privilegeMap.put(p.getPermision().getName(),p);
	        }
			
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public static AuthUser findByUserName(String string) {
		return find.where().eq("username", string).findUnique();
	}

	public static AuthUser findByFacility(Facility facility) {
		return find.where().and(Expr.eq("facility", facility), Expr.eq("roles.name", "FADMIN")).findUnique();
	}

	public Map<String, Privileges> getPrivilegeMap() {
		return privilegeMap;
	}

	public static AuthUser findByUsername(String principal) {
		return find.where().eq("username", principal).findUnique();
		
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
		public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
}
