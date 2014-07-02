package com.mnt.emr.module.facility.repository;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.custom.domain.FacilityStatus;
import com.mnt.emr.module.facility.model.Facility;
import com.mnt.emr.module.facility.view.FacilityVM;

@Service
public class FacilityRepositoryImpl implements FacilityRepository {

	@Override
	public Facility saveFacility(FacilityVM facility) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Facility f = mapper.map(facility, Facility.class);
        f.save();
        return f;
	}

	@Override
	public FacilityVM getFacilityVMById(Long id) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Facility facility = Facility.getFacilityById(id);
		FacilityVM vm = mapper.map(facility, FacilityVM.class);
		return vm;
	}

	@Override
	public List<FacilityVM> searchFacilitiesByFilter(String name, String role,
			String dob) {
		List<Expression> expressions = new ArrayList<Expression>();
		List<Facility> facilities = new ArrayList<>();
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		
		if (name != null && name.length() != 0) {
			expressions.add(Expr.ilike("facilityName", "%" + name + "%"));
		}
		
		expressions.add(Expr.ne("id", -1L));
		expressions.add(Expr.eq("status", FacilityStatus.DISAPPROVED.name()));
		
		if(expressions.size() != 0) {
			Expression exp = expressions.get(0);
			for(int i =1;i<expressions.size();i++)
			{
				exp = Expr.and(exp, expressions.get(i));
			}
			
			facilities = Facility.find.where(exp).findList();
		}
		
		List<FacilityVM> facilityVMs = new ArrayList<>();
		for(Facility f : facilities) {
			FacilityVM vm = mapper.map(f, FacilityVM.class);
			facilityVMs.add(vm);
		}
		
		return facilityVMs;
	}

	@Override
	public Facility updateFacility(FacilityVM facilityVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Facility facility = mapper.map(facilityVM, Facility.class);
		facility.update();
		return facility;
	}
}
