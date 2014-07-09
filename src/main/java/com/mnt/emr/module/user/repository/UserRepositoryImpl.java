package com.mnt.emr.module.user.repository;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.mnt.core.utils.RandomPasswordGenerator;
import com.mnt.core.utils.RandomPasswordGenerator.Mode;
import com.mnt.emr.module.common.model.AuthUser;
import com.mnt.emr.module.common.model.Role;
import com.mnt.emr.module.user.model.UserProfile;
import com.mnt.emr.module.user.view.UserVM;

@Service
public class UserRepositoryImpl implements UserRepository {
	
	@Override
	public UserProfile saveUser(UserVM userVM) {
		
		AuthUser user = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof String) {
			user = AuthUser.findByUsername(principal.toString());
		} else {
			user = (AuthUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		
		AuthUser authUser = null;
		if(userVM.isWebAccess()) {
			authUser = new AuthUser();
			authUser.setUsername(userVM.getEmail());
			authUser.setPassword(RandomPasswordGenerator.generateRandomString(6, Mode.ALPHANUMERIC));
			authUser.setEnabled(true);
			authUser.setFacility(user.getFacility());
			
			if(authUser.getRoles() == null) {
				List<Role> roles = new ArrayList<>();
				roles.add(Role.findById(userVM.userType));
				authUser.setRoles(roles);
				authUser.save();
				Ebean.saveManyToManyAssociations(authUser, "roles");
			}
		}
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		UserProfile userModel = mapper.map(userVM, UserProfile.class);
		if(userVM.isWebAccess()) {
			userModel.setAuthUser(authUser);
			authUser.setUserProfile(userModel);
		}
		userModel.setFacility(user.getFacility());
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
		/*try {
				if(!role.equals("")){
					expressions.add(Expr.ilike("userType", "%" + role + "%")); 
				}
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}*/
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
