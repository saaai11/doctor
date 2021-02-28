package appointment.doctor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import appointment.doctor.entities.Doctors;
import appointment.doctor.entities.FullCheckup;
import appointment.doctor.repository.CheckupsRepository;

@Service
public class FullCheckupService {
	
	@Autowired
	CheckupsRepository checkupsRepository;

	public List<FullCheckup> getAll() {

		
		return checkupsRepository.findAll();
	}

	
	public ObjectNode getCheckupData(String checkupId) {
		
		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode createResponse = objectMapper.createObjectNode();


		Optional<FullCheckup> existingDoctor = this.checkupsRepository.findById(checkupId);
		
		if( !existingDoctor.isPresent()) {
			createResponse.put("status","not authorized");

			createResponse.put("error_msg", "Not a valid doctor");
			return createResponse;

		}	
		
		
				
		FullCheckup fullCheckup  = existingDoctor.get();
		
		 createResponse.put("status", "valid");
		 createResponse.put("data", fullCheckup.toString());
		 return createResponse;
	}
	
	

	public String saveCheckupData(FullCheckup checkup) {
		
		Long min = (long)100000;
		Long max = (long)999999;

 
		
	      Integer accountNumber = (int)(Math.random() * (max - min + 1) + min);
	      String checkupId = "CHKP"+accountNumber;

		try {
			
			while( !checkupsRepository.findById(checkupId).isEmpty()) {
		    	  accountNumber =  (int)(Math.random() * (max - min + 1) + min);  
		    	  checkupId = "CHKP"+accountNumber;
		      }

			
			
			checkup.setCheckupId(checkupId);
			
			checkupsRepository.save(checkup);
			
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return checkupId;

	}

	
	public ResponseEntity<String> deleteCheckup(String checkupId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
