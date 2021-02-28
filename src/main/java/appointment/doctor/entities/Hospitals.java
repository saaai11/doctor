package appointment.doctor.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hospitals")
public class Hospitals {
	
	@Id
	@Column(name = "id")
	private String Id;

	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="timings")
	private String timings;
	
	@Column(name="paymentmodes")
	private String paymentModes;
	
	@Column(name="beds")
	private String beds;
	
	@Column(name="ambulance")
	private String ambulance;
	
	@Column(name="amenities")
	private String awards;
	
	@Column(name="totaldoctors")
	private String totalDoctors;
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public String getPaymentModes() {
		return paymentModes;
	}

	public void setPaymentModes(String paymentModes) {
		this.paymentModes = paymentModes;
	}

	public String getBeds() {
		return beds;
	}

	public void setBeds(String beds) {
		this.beds = beds;
	}

	public String getAmbulance() {
		return ambulance;
	}

	public void setAmbulance(String ambulance) {
		this.ambulance = ambulance;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getTotalDoctors() {
		return totalDoctors;
	}

	public void setTotalDoctors(String totalDoctors) {
		this.totalDoctors = totalDoctors;
	}

	public String getServices() {
		return Services;
	}

	public void setServices(String services) {
		Services = services;
	}

	public String getHospitalContactNumber() {
		return hospitalContactNumber;
	}

	public void setHospitalContactNumber(String hospitalContactNumber) {
		this.hospitalContactNumber = hospitalContactNumber;
	}

	public String getHospitalContactNumber2() {
		return hospitalContactNumber2;
	}

	public void setHospitalContactNumber2(String hospitalContactNumber2) {
		this.hospitalContactNumber2 = hospitalContactNumber2;
	}

	@Column(name="services")
	private String Services;
	
	@Column(name="hospitalcontactnumber1")
	private String hospitalContactNumber;
	
	@Column(name="hospitalcontactnumber2")
	private String hospitalContactNumber2;
	
	
	

}
