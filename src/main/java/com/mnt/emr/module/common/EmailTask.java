package com.mnt.emr.module.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mnt.emr.module.common.model.AuthUser;

@Service(value="emailTask")
public class EmailTask {
	
	@Autowired
	@Qualifier("mail")
	Mail mail;
	
	public void sendEmail(AuthUser au) {
			mail.sendMail("dhairyashil.bankar@gmail.com",
	    		   au.getUsername(),"Account Creation Success","You Account is created successfully!\n"
	    		   		+ "Your password is:" + au.getPassword());
	        System.out.println("Hello Sending Mail");
	}
}
