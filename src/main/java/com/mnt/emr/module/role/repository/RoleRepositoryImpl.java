package com.mnt.emr.module.role.repository;

import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.avaje.ebean.Ebean;
import com.google.common.collect.Lists;
import com.mnt.emr.module.common.model.Role;
import com.mnt.emr.module.facility.model.Facility;
import com.mnt.emr.module.role.view.RoleVM;

@Service
public class RoleRepositoryImpl implements RoleRepository {
	@Override
	public void saveRoles(List<RoleVM> roles, Facility facility) {
		List<Role> roleList = Lists.newArrayList();
		for(RoleVM vm : roles) {
			Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
			Role role = mapper.map(vm, Role.class);
			System.out.println(facility.facilityName);
			if(role.getId() == null){
				role.setFacility(facility);
				roleList.add(role);
			}
		}
		Ebean.save(roleList);
	}

	@Override
	public List<RoleVM> getAllRoleVMsByFacility(Facility facility) {
		List<RoleVM> roleList = Lists.newArrayList();
		List<Role> roles = Role.getAllRolesByFacility(facility);
		
		for(Role _r : roles) {
			Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
			RoleVM role = mapper.map(_r, RoleVM.class);
			roleList.add(role);
		}
		return roleList;
	}

}
