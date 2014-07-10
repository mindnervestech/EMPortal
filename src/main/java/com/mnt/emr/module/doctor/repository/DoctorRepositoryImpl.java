package com.mnt.emr.module.doctor.repository;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.mnt.emr.module.doctor.model.Doctor;
import com.mnt.emr.module.doctor.view.DoctorVM;

@Service
public class DoctorRepositoryImpl implements DoctorRepository{

	@Override
	public Doctor saveDoctor(DoctorVM doctorVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Doctor doctor = mapper.map(doctorVM, Doctor.class);
		doctor.save();
		return doctor;
	}

	@Override
	public DoctorVM getDoctorVMById(Long id) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Doctor doctor = Doctor.getDoctorById(id);
		DoctorVM vm = mapper.map(doctor, DoctorVM.class);
		return vm;
	}

	@Override
	public List<DoctorVM> searchDoctorsByFilter(String name, String role, String dob) {
		List<Expression> expressions = new ArrayList<Expression>();
		List<Doctor> doctors = new ArrayList<>();
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		
		if (name != null && name.length() != 0) {
			expressions.add( Expr.or (Expr.or(Expr.ilike("firstName", "%" + name + "%"), 
						Expr.ilike("middleName", "%" + name + "%")), Expr.ilike("lastName", "%" + name + "%")));
		}
		
		if(expressions.size() != 0) {
			Expression exp = expressions.get(0);
			for(int i =1;i<expressions.size();i++)
			{
				exp = Expr.and(exp, expressions.get(i));
			}
			
			doctors = Doctor.find.where(exp).findList();
		}
		else {
			doctors = Doctor.find.all();
		}
		
		List<DoctorVM> doctorVMs = new ArrayList<>();
		for(Doctor d : doctors) {
			DoctorVM vm = mapper.map(d, DoctorVM.class);
			doctorVMs.add(vm);
		}
		
		return doctorVMs;
	}

	@Override
	public Doctor updateDoctor(DoctorVM doctorVM) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		Doctor doctor = mapper.map(doctorVM, Doctor.class);
		doctor.update();
		return doctor;
	}

	@Override
	public List<Doctor> getDoctorsByIds(String resourceIds) {
		return Doctor.getDoctorsByIds(resourceIds);
	}
}
