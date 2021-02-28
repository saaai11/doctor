package appointment.doctor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import appointment.doctor.entities.UserRegistration;

import appointment.doctor.repository.UsersRepository;

@Service
public class CustomerService {
	
	@Autowired
	UsersRepository userRepository;
	
	public List<UserRegistration> getAccountss(){
		return this.userRepository.findAll();
	}
	
	
	
public String saveUserData(UserRegistration user) {
		
		
		
		Long min = (long)100000;
		Long max = (long)999999;

 
		
	      Integer accountNumber = (int)(Math.random() * (max - min + 1) + min);
	      String userId = "USER"+accountNumber;

		try {
			
			while( !userRepository.findById(userId).isEmpty()) {
		    	  accountNumber =  (int)(Math.random() * (max - min + 1) + min);  
		      }

			
			user.setUserId(userId);
			
			
			userRepository.save(user);
			
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return userId;

	}


 public ObjectNode getUserAccount(String userId) {
	 
		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode createResponse = objectMapper.createObjectNode();


		Optional<UserRegistration> existingUser = this.userRepository.findById(userId);
		if( !existingUser.isPresent()) {
			createResponse.put("status","not authorized");

			createResponse.put("error_msg", "Not a valid user");
			return createResponse;

		}	
		
		
				
		UserRegistration userRegistration = existingUser.get();
		
		 createResponse.put("status", "valid");
		 try {
			createResponse.put("data", objectMapper.writeValueAsString(userRegistration));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return createResponse;
				 
	} 
 
 
public ResponseEntity<String> updateUserAccount(String userId,UserRegistration user) {
	

	Optional<UserRegistration> existingUser = this.userRepository.findById(userId);
	if( !existingUser.isPresent()) {
		return new ResponseEntity<String>("Not a valid user", HttpStatus.UNAUTHORIZED);

	}	
			
	UserRegistration userRegistration = existingUser.get();
	userRegistration.setLastName(user.getLastName());
	
	userRegistration.setFirstName(user.getFirstName());
	
	this.userRepository.save(userRegistration);

	return new ResponseEntity<String>("Successfullu updated your details", HttpStatus.OK);

}

public ResponseEntity<String> deleteUserAccount(String userId){
	Optional<UserRegistration> existingUser = this.userRepository.findById(userId);
	if( !existingUser.isPresent()) {
		return new ResponseEntity<String>("Not a valid user", HttpStatus.UNAUTHORIZED);

	}		
	
	UserRegistration userRegistration = existingUser.get();

	this.userRepository.delete(userRegistration);
	return ResponseEntity.ok().build();
}


	

}
