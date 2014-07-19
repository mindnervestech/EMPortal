package com.mnt.emr.module.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mnt.emr.module.user.service.UserService;
import com.mnt.emr.module.user.view.UserVM;
import com.mnt.emr.util.Json;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	private static String USERGRIDCOLUMN_JSON = getStringFromInputStream(Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("user_grid.json"));
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> saveUser(@RequestBody UserVM userVM   ) {
		logger.info("inside save user");
		userService.saveUser(userVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "User Saved Successfully!");
		return message;
	}
	
	
	@RequestMapping(value = "/template/user.main.html", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("gridData","[]");
		model.addAttribute("gridColumn",USERGRIDCOLUMN_JSON);
		return "user.main.html";
	}
	
	@RequestMapping(value = "/user-search", method = RequestMethod.GET)
	@ResponseBody
	public List<UserVM> searchUser(@RequestParam(required=false, value="name") String name, @RequestParam(required=false, value="roleType") Long role, @RequestParam(required=false, value="dob") String dob) {
		return userService.searchUsersByFilter(name, role, dob);
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public @ResponseBody Map<String,String> updateUser(@RequestBody UserVM userVM   ) {
		logger.info("inside update user");
		userService.updateUser(userVM);
		System.out.println(userVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "User Saved Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.PUT)
	public @ResponseBody Map<String,String> deleteUser(@RequestBody UserVM userVM   ) {
		logger.info("inside delete user");
		userService.deleteUser(userVM);
		System.out.println(userVM);
		Map<String,String> message = new HashMap<String, String>();
		message.put("success", "User Deleted Successfully!");
		return message;
	}
	
	@RequestMapping(value = "/add-edit-user.html/{id}", method = RequestMethod.GET)
	public String displayUser(@PathVariable Long id, Model model) {
		UserVM userVM = null;
		if(id == -1) {
			userVM = new UserVM();
		} else {
			userVM = userService.getUserVMById(id);
		}
		model.addAttribute("asJson", Json.toJson(userVM));
		model.addAttribute("user", userVM);
		return "add-edit-user.html";
	}
	
	private static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
}
