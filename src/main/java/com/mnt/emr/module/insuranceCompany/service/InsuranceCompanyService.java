package com.mnt.emr.module.insuranceCompany.service;

import java.util.List;

import com.mnt.emr.module.insuranceCompany.model.InsuranceCompany;
import com.mnt.emr.module.insuranceCompany.view.InsuranceCompanyVM;


public interface InsuranceCompanyService {
	InsuranceCompany saveinsuranceCompany(InsuranceCompanyVM insuranceCompanyVM);
	InsuranceCompanyVM getinsuranceCompanyVMById(Long id);	
	List<InsuranceCompanyVM> searchinsuranceCompanyByFilter(String name, String role, String dob);
	InsuranceCompany updateinsuranceCompany(InsuranceCompanyVM insuranceCompanyVM);
	void deleteinsuranceCompany(InsuranceCompanyVM insuranceCompanyVM );
}
