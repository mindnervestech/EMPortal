package com.mnt.emr.module.schedular.view;

import com.mnt.emr.module.doctor.model.Doctor;
import com.mnt.emr.module.doctor.view.DoctorVM;

public class DoctorResourceVM {
	public String label;
	public Long key;
	public String firstName;
	
	public DoctorResourceVM(DoctorVM vm) {
		this.label = vm.getFirstName()+ " " +vm.getLastName();
		this.key = vm.getId();
		this.firstName = vm.getLastName();
	}
	
	public DoctorResourceVM(Doctor doctor) {
		this.label = doctor.getFirstName()+ " " +doctor.getLastName();
		this.key = doctor.getId();
		this.firstName = doctor.getLastName();
	}
}
