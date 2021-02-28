package appointment.doctor.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "doctors")

public class Doctors {
	
	@Id
	@Column(name = "id")
	private String Id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name="fee")
	private String fee;
	
	@Column(name="availabletimings")
	private String availableTimings;
	
	
	@Column(name = "mobilenumber")
	private String mobileNumber;
	
	@Column(name = "password")
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "homenumber")
	private String homeNumber;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "bloodgroup")
	private String bloodGroup;
	
	@Column(name = "specialization")
	private String specialization;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "registrationnumber")
	private String registrationNumber;
	
	@Column(name = "registrationcouncil")
	private String registrationCouncil;
	
	@Column(name = "registrationyear")
	private String registrationYear;
	
	@Column(name = "degree")
	private String degree;
	
	@Column(name = "college")
	private String college;
	
	@Column(name = "yearofcompletion")
	private String yearOfCompletion;
	
	@Column(name = "experience")
	private String experience;
	
	 
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "doctor")
	private List<Address> address;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getRegistrationCouncil() {
		return registrationCouncil;
	}

	public void setRegistrationCouncil(String registrationCouncil) {
		this.registrationCouncil = registrationCouncil;
	}

	public String getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(String registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getYearOfCompletion() {
		return yearOfCompletion;
	}

	public void setYearOfCompletion(String yearOfCompletion) {
		this.yearOfCompletion = yearOfCompletion;
	}

	public String getExperience() {
		return experience;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getAvailableTimings() {
		return availableTimings;
	}

	public void setAvailableTimings(String availableTimings) {
		this.availableTimings = availableTimings;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	
	
}
