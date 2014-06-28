package com.mnt.emr.module.insuranceCompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.emr.module.insuranceCompany.model.InsuranceCompany;
import com.mnt.emr.module.insuranceCompany.repository.InsuranceCompanyRepository;
import com.mnt.emr.module.insuranceCompany.view.InsuranceCompanyVM;

@Service
public class InsuranceCompanyServiceImpl implements InsuranceCompanyService{
	@Autowired
	InsuranceCompanyRepository insuranceCompanyRepository;
	
	@Override
	public InsuranceCompany saveinsuranceCompany(InsuranceCompanyVM insuranceCompanyVM) {
		return insuranceCompanyRepository.saveinsuranceCompany(insuranceCompanyVM);
	}

	@Override
	public InsuranceCompanyVM getinsuranceCompanyVMById(Long id) {
		return insuranceCompanyRepository.getinsuranceCompanyVMById(id);
	}

	@Override
	public List<InsuranceCompanyVM> searchinsuranceCompanyByFilter(String name, String role, String dob) {
		return insuranceCompanyRepository.searchinsuranceCompanyByFilter(name, role, dob);
	}

	@Override
	public InsuranceCompany updateinsuranceCompany(InsuranceCompanyVM insuranceCompanyVM) {
		return insuranceCompanyRepository.updateinsuranceCompany(insuranceCompanyVM);
	}
	
	@Override
	public void deleteinsuranceCompany(InsuranceCompanyVM insuranceCompanyVM) {
		insuranceCompanyRepository.deleteinsuranceCompany(insuranceCompanyVM);
	}
}
