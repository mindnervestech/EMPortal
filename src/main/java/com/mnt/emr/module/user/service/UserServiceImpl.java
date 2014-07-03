package com.mnt.emr.module.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.emr.module.doctor.model.Doctor;
import com.mnt.emr.module.doctor.repository.DoctorRepository;
import com.mnt.emr.module.doctor.view.DoctorVM;
import com.mnt.emr.module.pharmacy.view.PharmacyVM;
import com.mnt.emr.module.user.model.UserProfile;
import com.mnt.emr.module.user.repository.UserRepository;
import com.mnt.emr.module.user.view.UserVM;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserProfile saveUser(UserVM userVM) {
		return userRepository.saveUser(userVM);
	}

	@Override
	public UserVM getUserVMById(Long id) {
		return userRepository.getUserVMById(id);
	}

	@Override
	public List<UserVM> searchUsersByFilter(String name, String role, String dob) {
		return userRepository.searchUsersByFilter(name, role, dob);
	}

	@Override
	public UserProfile updateUser(UserVM userVM) {
		return userRepository.updateUser(userVM);
	}
	
	@Override
	public void deleteUser(UserVM userVM) {
		 userRepository.deleteUser(userVM);
	}
}
