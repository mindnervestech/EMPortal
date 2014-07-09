package com.mnt.emr.module.common;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevelopersController {
	
	@RequestMapping(value = "/dev/seed/sql", method = RequestMethod.GET)
	public @ResponseBody String seedSql() {
		final ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();
		rdp.addScript(new ClassPathResource("seed.sql"));
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emr-portal", "root", "");
			rdp.populate(con);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage() + " | \n" +e.getCause().getMessage();
		}
		return "done";
	}
}
