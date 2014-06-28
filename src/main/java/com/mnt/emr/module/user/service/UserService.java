package com.mnt.emr.module.user.service;

import java.util.List;

import com.mnt.emr.module.user.model.UserModel;
import com.mnt.emr.module.user.view.UserVM;


public interface UserService {
	UserModel saveUser(UserVM userVM);
	UserVM getUserVMById(Long id);	
	List<UserVM> searchUsersByFilter(String name, String role, String dob);
	UserModel updateUser(UserVM userVM);
	void deleteUser(UserVM userVM );
}
