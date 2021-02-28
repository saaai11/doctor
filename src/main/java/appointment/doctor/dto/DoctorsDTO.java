package appointment.doctor.dto;

import java.util.List;

public class DoctorsDTO {

	
	
	private String Id;

	
	private String name;
	
	private String email;
	
	private String fee;
	
	private String availableTimings;
	
	
	private String mobileNumber;
	
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String homeNumber;
	
	private String dob;
	
	private String bloodGroup;
	
	private String specialization;
	
	private String gender;
	
	private String city;
	
	private String registrationNumber;
	
	private String registrationCouncil;
	
	private String registrationYear;
	
	private String degree;
	
	private String college;
	
	private String yearOfCompletion;
	
	private String experience;
	
	private List<AddressDTO> address;


	public List<AddressDTO> getAddress() {
		return address;
	}

	public void setAddress(List<AddressDTO> address) {
		this.address = address;
	}

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
