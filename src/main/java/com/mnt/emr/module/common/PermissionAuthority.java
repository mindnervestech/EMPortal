package com.mnt.emr.module.common;

import org.springframework.security.core.GrantedAuthority;

public class PermissionAuthority implements GrantedAuthority {

	private String authority;
	
	public PermissionAuthority(String authority) {
		super();
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}
	
	@Override
    public int hashCode() {
        return authority.hashCode();
    }
 
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof PermissionAuthority)) return false;
        return ((PermissionAuthority) obj).getAuthority().equals(authority);
    }

}
