package com.mnt.emr.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.mnt.emr.module.common.model.AuthUser;

public class Helper {

	public static AuthUser getCurrentUser(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof String) {
			AuthUser user = AuthUser.findByUsername(principal.toString());
			return user;
			
		} else {
			return ((AuthUser)principal);
		}
	}
}
