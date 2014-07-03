package com.mnt.emr.module.user.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

import com.custom.domain.UserType;
import com.mnt.emr.module.common.model.AuthUser;
import com.mnt.emr.module.common.model.Role;
import com.mnt.emr.module.facility.model.Facility;

@Entity
public class UserProfile extends Model {
	
	@Id
	public Long id;
	
	public String firstName;
	public String middleName;
	public String lastName;
	public String gender;
	public Date dateOfBirth;
	public String email;
	public String contactNumber;
	public String address;
	public String city;
	public String state;
	public String postalCode;
	public String country;
	public String professionQualification;
	public boolean isAdminAllowed;
	
	@ManyToMany
	private List<Role> roles;
	
	@OneToOne
	public Facility facility;
	
	@OneToOne
	public AuthUser authUser;
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public boolean isAdminAllowed() {
		return isAdminAllowed;
	}

	public void setAdminAllowed(boolean isAdminAllowed) {
		this.isAdminAllowed = isAdminAllowed;
	}

	@Enumerated(EnumType.STRING)
	public UserType userType;
	
	public static Finder<Long, UserProfile> find = new Finder<>(Long.class, UserProfile.class);

	public static UserProfile getUserById(Long id) {
		UserProfile user = UserProfile.find.byId(id);
		return user;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProfessionQualification() {
		return professionQualification;
	}

	public void setProfessionQualification(String professionQualification) {
		this.professionQualification = professionQualification;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
