package com.mnt.emr.module.insuranceCompany.repository;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.mnt.emr.module.insuranceCompany.model.InsuranceCompany;
import com.mnt.emr.module.insuranceCompany.view.InsuranceCompanyVM;

@Service
public class InsuranceCompanyRepositoryImpl implements InsuranceCompanyRepository{
	@Override
	public InsuranceCompany saveinsuranceCompany(InsuranceCompanyVM insuranceCompanyVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		InsuranceCompany insuranceCompany = mapper.map(insuranceCompanyVM, InsuranceCompany.class);
		insuranceCompany.save();
		return insuranceCompany;
	}

	@Override
	public InsuranceCompanyVM getinsuranceCompanyVMById(Long id) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		InsuranceCompany insuranceCompany = InsuranceCompany.getinsuranceCompanyById(id);
		InsuranceCompanyVM vm = mapper.map(insuranceCompany, InsuranceCompanyVM.class);
		return vm;
	}

	@Override
	public InsuranceCompany updateinsuranceCompany(InsuranceCompanyVM insuranceCompanyVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		InsuranceCompany insuranceCompany = mapper.map(insuranceCompanyVM, InsuranceCompany.class);
		insuranceCompany.update();
		return insuranceCompany;
	}
	
	@Override
	public void deleteinsuranceCompany(InsuranceCompanyVM insuranceCompanyVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		InsuranceCompany insuranceCompany = mapper.map(insuranceCompanyVM, InsuranceCompany.class);
		insuranceCompany.delete();
	}
	
	@Override
	public List<InsuranceCompanyVM> searchinsuranceCompanyByFilter(String name, String role, String dob) {
		List<Expression> expressions = new ArrayList<Expression>();
		List<InsuranceCompany> insuranceCompanys = new ArrayList<>();
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
			
			insuranceCompanys = InsuranceCompany.find.where(exp).findList();
		}
		else {
			insuranceCompanys = InsuranceCompany.find.all();
		}
		
		List<InsuranceCompanyVM> insuranceCompanyVMs = new ArrayList<>();
		for(InsuranceCompany i : insuranceCompanys) {
			InsuranceCompanyVM vm = mapper.map(i, InsuranceCompanyVM.class);
			insuranceCompanyVMs.add(vm);
		}
		
		return insuranceCompanyVMs;
	}

}
