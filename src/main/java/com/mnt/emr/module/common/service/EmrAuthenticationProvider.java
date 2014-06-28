package com.mnt.emr.module.common.service;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.mnt.emr.module.common.UserProfile;

@Component(value = "authenticationProvider")
public class EmrAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication arg0)
			throws AuthenticationException {
		 UserProfile profile = new UserProfile(); 
		 UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(profile, null, profile.getAuthorities());
		 return token;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(UsernamePasswordAuthenticationToken.class);
	}

}
