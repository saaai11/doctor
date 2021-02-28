package appointment.doctor.dto;

public class AddressDTO {

	private Integer id;
	private int houseNo;   
	private String streetName;
	private String county;
	private String postCode;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public int getHouseNo() {  // getter method for getting house no
		return houseNo;
	}
	// setter method for setting house no

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	
	 // getter method for getting streetName
	public String getStreetName() {
		return streetName;
	}
	// setter method for setting streetName

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	 // getter method for getting county
	public String getCounty() {
		return county;
	}
	// setter method for setting county

	public void setCounty(String county) {
		this.county = county;
	}
	 // getter method for getting postCode
	public String getPostCode() {
		return postCode;
	}
	// setter method for setting postCode

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	


}
