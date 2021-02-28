package appointment.doctor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import appointment.doctor.entities.Doctors;
import appointment.doctor.entities.UserRegistration;
import appointment.doctor.repository.DoctorsRepository;
import appointment.doctor.repository.UsersRepository;

@Service
public class DoctorService {

	@Autowired
	DoctorsRepository doctorsRepository;
	
	public List<Doctors> getAccountss(){
		return this.doctorsRepository.findAll();
	}
	
	
	
public String saveDoctorData(Doctors doctor) {
		
		
		
		Long min = (long)100000;
		Long max = (long)999999;

 
		
	      Integer accountNumber = (int)(Math.random() * (max - min + 1) + min);
	      String userId = "DOC"+accountNumber;

		try {
			
			while( !doctorsRepository.findById(userId).isEmpty()) {
		    	  accountNumber =  (int)(Math.random() * (max - min + 1) + min);  
		    	  userId = "DOC"+accountNumber;
		      }

			
			
			doctor.setId(userId);
			
			doctorsRepository.save(doctor);
			
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return userId;

	}




public ObjectNode getDoctorAccount(String id) {
		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode createResponse = objectMapper.createObjectNode();


		Optional<Doctors> existingDoctor = this.doctorsRepository.findById(id);
		if( !existingDoctor.isPresent()) {
			createResponse.put("status","not authorized");

			createResponse.put("error_msg", "Not a valid doctor");
			return createResponse;

		}	
		
		
				
		Doctors doctors  = existingDoctor.get();
		
		 createResponse.put("status", "valid");
		 createResponse.put("data", doctors.toString());
		 return createResponse;
				 
	} 


public ResponseEntity<String> updateDoctorAccount(String userId,Doctors doctor) {
	

	Optional<Doctors> existingUser = this.doctorsRepository.findById(userId);
	if( !existingUser.isPresent()) {
		return new ResponseEntity<String>("Not a valid doctor", HttpStatus.UNAUTHORIZED);

	}	
			
	Doctors doctors = existingUser.get();
	
	doctors.setName(doctor.getName());
	
	
	this.doctorsRepository.save(doctors);

	return new ResponseEntity<String>("Successfullu updated your details", HttpStatus.OK);

}

public ResponseEntity<String> deleteDoctorAccount(String id){
	
	Optional<Doctors> existingDoctor = this.doctorsRepository.findById(id);
	if( !existingDoctor.isPresent()) {
		return new ResponseEntity<String>("Not a valid doctor", HttpStatus.UNAUTHORIZED);

	}		
	
	Doctors doctors = existingDoctor.get();

	this.doctorsRepository.delete(doctors);
	return ResponseEntity.ok().build();
}



}

