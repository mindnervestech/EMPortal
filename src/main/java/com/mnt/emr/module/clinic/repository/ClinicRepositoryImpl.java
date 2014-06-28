package com.mnt.emr.module.clinic.repository;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.mnt.emr.module.clinic.model.Clinic;
import com.mnt.emr.module.clinic.view.ClinicVM;
import com.mnt.emr.module.pharmacy.model.Pharmacy;
import com.mnt.emr.module.pharmacy.view.PharmacyVM;

@Service
public class ClinicRepositoryImpl implements ClinicRepository {
	@Override
	public Clinic saveClinic(ClinicVM clinicVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Clinic clinic = mapper.map(clinicVM, Clinic.class);
		clinic.save();
		return clinic;
	}

	@Override
	public ClinicVM getClinicVMById(Long id) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Clinic clinic = Clinic.getClinicById(id);
		ClinicVM vm = mapper.map(clinic, ClinicVM.class);
		return vm;
	}

	@Override
	public Clinic updateClinic(ClinicVM clinicVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Clinic clinic = mapper.map(clinicVM, Clinic.class);
		clinic.update();
		return clinic;
	}
	
	@Override
	public void deleteClinic(ClinicVM clinicVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Clinic clinic = mapper.map(clinicVM, Clinic.class);
		clinic.delete();
	}
	
	@Override
	public List<ClinicVM> searchClinicByFilter(String name, String role, String dob) {
		List<Expression> expressions = new ArrayList<Expression>();
		List<Clinic> clinics = new ArrayList<>();
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		
		try {
				if(!name.equals("")){
					expressions.add(Expr.ilike("name", "%" + name + "%")); 
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
			
			clinics = Clinic.find.where(exp).findList();
		}
		else {
			clinics = Clinic.find.all();
		}
		
		List<ClinicVM> clinicVMs = new ArrayList<>();
		for(Clinic c : clinics) {
			ClinicVM vm = mapper.map(c, ClinicVM.class);
			clinicVMs.add(vm);
		}
		
		return clinicVMs;
	}

}
