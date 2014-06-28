package com.mnt.emr.module.user.repository;

import java.util.List;

import com.mnt.emr.module.user.model.UserModel;
import com.mnt.emr.module.user.view.UserVM;


public interface UserRepository {
	UserModel saveUser(UserVM vm);
	UserVM getUserVMById(Long id);
	List<UserVM> searchUsersByFilter(String name, String role, String dob);	
	UserModel updateUser(UserVM userVM);
	void deleteUser(UserVM userVM);
}
