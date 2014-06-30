package com.mnt.emr.module.common.service;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mnt.emr.module.common.model.AuthUser;

@Component(value = "authenticationProvider")
public class EmrAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		 AuthUser user = AuthUser.findByUserName(authentication.getPrincipal().toString());
		 if(user == null){
	            throw new UsernameNotFoundException(String.format("Invalid credentials", authentication.getPrincipal()));
	     }
		 
		 if(!user.getPassword().equals(authentication.getCredentials().toString())){
			 throw new BadCredentialsException("Invalid credentials");
		 }
		 
		 //String suppliedPasswordHash = DigestUtils..shaHex(authentication.getCredentials().toString());
		 UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		 return token;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(UsernamePasswordAuthenticationToken.class);
	}

}
