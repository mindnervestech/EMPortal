package com.mnt.emr.module.user.repository;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.mnt.emr.module.doctor.model.Doctor;
import com.mnt.emr.module.doctor.view.DoctorVM;
import com.mnt.emr.module.pharmacy.model.Pharmacy;
import com.mnt.emr.module.pharmacy.view.PharmacyVM;
import com.mnt.emr.module.user.model.UserProfile;
import com.mnt.emr.module.user.view.UserVM;

@Service
public class UserRepositoryImpl implements UserRepository {
	
	@Override
	public UserProfile saveUser(UserVM userVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		UserProfile userModel = mapper.map(userVM, UserProfile.class);
		userModel.save();
		return userModel;
	}

	@Override
	public UserVM getUserVMById(Long id) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		UserProfile userModel = UserProfile.getUserById(id);
		UserVM vm = mapper.map(userModel, UserVM.class);
		return vm;
	}

	@Override
	public UserProfile updateUser(UserVM userVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		UserProfile userModel = mapper.map(userVM, UserProfile.class);
		userModel.update();
		return userModel;
	}
	
	@Override
	public void deleteUser(UserVM userVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		UserProfile userModel = mapper.map(userVM, UserProfile.class);
		userModel.delete();
	}
	
	@Override
	public List<UserVM> searchUsersByFilter(String name, String role, String dob) {
		List<Expression> expressions = new ArrayList<Expression>();
		List<UserProfile> userModels = new ArrayList<>();
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		
		try {
				if(!name.equals("")){
					expressions.add( Expr.or (Expr.or(Expr.ilike("firstName", "%" + name + "%"), 
								Expr.ilike("middleName", "%" + name + "%")), Expr.ilike("lastName", "%" + name + "%")));
				}
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		try {
				if(!role.equals("")){
					expressions.add(Expr.ilike("userType", "%" + role + "%")); 
				}
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		if(expressions.size()!=0)
		{
			Expression exp = expressions.get(0);
			for(int i =1;i<expressions.size();i++)
			{
				exp = Expr.and(exp, expressions.get(i));
			}
			
			userModels = UserProfile.find.where(exp).findList();
		}
		else {
			userModels = UserProfile.find.all();
		}
		
		List<UserVM> userVMs = new ArrayList<>();
		for(UserProfile u : userModels) {
			UserVM vm = mapper.map(u, UserVM.class);
			userVMs.add(vm);
		}
		
		return userVMs;
	}

	
}
