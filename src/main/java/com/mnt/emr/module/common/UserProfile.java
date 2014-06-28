package com.mnt.emr.module.common;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserProfile implements  UserDetails {

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<PermissionAuthority> authorities = new HashSet<PermissionAuthority>();
		PermissionAuthority produxAuthority = new PermissionAuthority("ROLE_ABC");
        authorities.add(produxAuthority);
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
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
		return false;
	}

}
