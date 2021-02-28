package appointment.doctor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import appointment.doctor.entities.Hospitals;
import appointment.doctor.repository.HospitalsRepository;

@Service
public class HospitalService {

	@Autowired
	HospitalsRepository hospitalsRepository;
	
	public List<Hospitals> getAccountss(){
		return this.hospitalsRepository.findAll();
	}
	
	
	
public String saveHospitalData(Hospitals hospitals) {
		
		
		
		Long min = (long)100000;
		Long max = (long)999999;

 
		
	      Integer accountNumber = (int)(Math.random() * (max - min + 1) + min);
	      String userId = "DOC"+accountNumber;

		try {
			
			while( !hospitalsRepository.findById(userId).isEmpty()) {
		    	  accountNumber =  (int)(Math.random() * (max - min + 1) + min);  
		    	  userId = "HOSP"+accountNumber;
		      }

			
			
			hospitals.setId(userId);
			
			hospitalsRepository.save(hospitals);
			
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return userId;

	}




public ObjectNode getHospitalAccount(String id) {
		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode createResponse = objectMapper.createObjectNode();


		Optional<Hospitals> existingHospital = this.hospitalsRepository.findById(id);
		if( !existingHospital.isPresent()) {
			createResponse.put("status","not authorized");

			createResponse.put("error_msg", "Not a valid doctor");
			return createResponse;

		}	
		
		
				
		Hospitals hospitals  = existingHospital.get();
		
		 createResponse.put("status", "valid");
		 createResponse.put("data", hospitals.toString());
		 return createResponse;
				 
	} 


public ResponseEntity<String> updateHospitalAccount(String userId,Hospitals hospital) {
	

	Optional<Hospitals> existingHospital = this.hospitalsRepository.findById(userId);
	
	if( !existingHospital.isPresent()) {
		return new ResponseEntity<String>("Not a valid doctor", HttpStatus.UNAUTHORIZED);

	}	
			
	Hospitals hospitals  = existingHospital.get();
	
	hospitals.setName(hospital.getName());
	
	
	this.hospitalsRepository.save(hospitals);

	return new ResponseEntity<String>("Successfullu updated your details", HttpStatus.OK);

}

public ResponseEntity<String> deleteHospitalAccount(String id){
	
	Optional<Hospitals> existingHospital = this.hospitalsRepository.findById(id);
	if( !existingHospital.isPresent()) {
		return new ResponseEntity<String>("Not a valid doctor", HttpStatus.UNAUTHORIZED);

	}		
	
	Hospitals hospitals  = existingHospital.get();

	this.hospitalsRepository.delete(hospitals);
	return ResponseEntity.ok().build();
}







}

