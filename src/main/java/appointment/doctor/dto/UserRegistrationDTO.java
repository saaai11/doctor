package appointment.doctor.dto;

import java.util.List;

public class UserRegistrationDTO {
		
		private String userId;
		
		private String firstName;
		
		private String lastName;
		
		private String email;
		
		private long mobile;
		
		private String gender;
		
		private String password;
		
		 
		private List<AddressDTO> address;
		
		
		public List<AddressDTO> getAddress() {
			return address;
		}

		public void setAddress(List<AddressDTO> address) {
			this.address = address;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public long getMobile() {
			return mobile;
		}

		public void setMobile(long mobile) {
			this.mobile = mobile;
		}

		public String isGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}
	}


