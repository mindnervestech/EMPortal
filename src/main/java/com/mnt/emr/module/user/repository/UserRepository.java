package com.mnt.emr.module.user.repository;

import java.util.List;

import com.mnt.emr.module.user.model.UserProfile;
import com.mnt.emr.module.user.view.UserVM;


public interface UserRepository {
	UserProfile saveUser(UserVM vm);
	UserVM getUserVMById(Long id);
	List<UserVM> searchUsersByFilter(String name, Long role, String dob);	
	UserProfile updateUser(UserVM userVM);
	void deleteUser(UserVM userVM);
}
