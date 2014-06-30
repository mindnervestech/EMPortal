package com.mnt.emr.module.common.service;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.mnt.emr.module.common.model.AuthUser;
import com.mnt.emr.module.common.model.Privileges;

@Component("permissionEvaluator")
public class EmrPermissionEvaluator  implements PermissionEvaluator  {

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		boolean hasPermission = false;
		
		if ( authentication != null &&  permission instanceof String){
			String[] accessSet = permission.toString().split("==");
			Privileges privileges = null;
			
			if(accessSet.length == 1) {
				privileges = ((AuthUser)authentication.getPrincipal()).getPrivilegeMap().get(permission);
				return privileges != null && !privileges.getDenied();
			}
			
			if(accessSet.length == 2) {
				privileges = ((AuthUser)authentication.getPrincipal()).getPrivilegeMap().get(accessSet[0].trim());
				if(privileges != null && "READ_ONLY".equalsIgnoreCase(accessSet[1].trim())) {
					return privileges.getRead() && !privileges.getDenied();
				}
				
				if(privileges != null && "WRITE".equalsIgnoreCase(accessSet[1].trim())) {
					return privileges.getWrite()  && !privileges.getDenied();
				}
			}
		}
		// TODO Auto-generated method stub
		return hasPermission;
	}

	@Override
	public boolean hasPermission(Authentication arg0, Serializable arg1,
			String arg2, Object arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
