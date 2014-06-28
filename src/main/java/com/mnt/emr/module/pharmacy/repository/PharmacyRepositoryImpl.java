package com.mnt.emr.module.pharmacy.repository;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.mnt.emr.module.pharmacy.model.Pharmacy;
import com.mnt.emr.module.pharmacy.view.PharmacyVM;

@Service
public class PharmacyRepositoryImpl implements PharmacyRepository {
	@Override
	public Pharmacy savePharmacy(PharmacyVM pharmacyVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Pharmacy pharmacy = mapper.map(pharmacyVM, Pharmacy.class);
		pharmacy.save();
		return pharmacy;
	}

	@Override
	public PharmacyVM getPharmacyVMById(Long id) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Pharmacy pharmacy = Pharmacy.getPharmacyById(id);
		PharmacyVM vm = mapper.map(pharmacy, PharmacyVM.class);
		return vm;
	}

	@Override
	public Pharmacy updatePharmacy(PharmacyVM pharmacyVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Pharmacy pharmacy = mapper.map(pharmacyVM, Pharmacy.class);
		pharmacy.update();
		return pharmacy;
	}
	
	@Override
	public void deletePharmacy(PharmacyVM pharmacyVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Pharmacy pharmacy = mapper.map(pharmacyVM, Pharmacy.class);
		pharmacy.delete();
	}
	
	@Override
	public List<PharmacyVM> searchPharmacyByFilter(String name, String role, String dob) {
		List<Expression> expressions = new ArrayList<Expression>();
		List<Pharmacy> pharmacys = new ArrayList<>();
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
			
			pharmacys = Pharmacy.find.where(exp).findList();
		}
		else {
			pharmacys = Pharmacy.find.all();
		}
		
		List<PharmacyVM> PharmacyVMs = new ArrayList<>();
		for(Pharmacy p : pharmacys) {
			PharmacyVM vm = mapper.map(p, PharmacyVM.class);
			PharmacyVMs.add(vm);
		}
		
		return PharmacyVMs;
	}

}
