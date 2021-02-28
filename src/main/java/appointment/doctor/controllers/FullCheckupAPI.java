package appointment.doctor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import appointment.doctor.entities.FullCheckup;
import appointment.doctor.repository.CheckupsRepository;
import appointment.doctor.services.FullCheckupService;

@RestController
@RequestMapping("/pro-Medico/checkups")
public class FullCheckupAPI {

	@Autowired
	CheckupsRepository checkupsRepository;
	
	@Autowired
	FullCheckupService fullCheckupService;
	
	
	
	 @GetMapping()                                             // get mapping annotation
	  public List<FullCheckup> getAllCheckup() {
	  return fullCheckupService.getAll();
	   }
	 
	 @GetMapping("/checkup/{id}")                                             // get mapping annotation
	  public ObjectNode getAccount(@PathVariable(value="id") String checkupId) {
	  return fullCheckupService.getCheckupData(checkupId);
	   }
	 

	 
	 
	 @PostMapping( value = "bookcheckup", consumes = MediaType.APPLICATION_JSON_VALUE)
	 public String postAccount(@RequestBody FullCheckup checkup ) {
		    
		
			return fullCheckupService.saveCheckupData(checkup); 
	       }
	 

			

			  //delete user by taking userid as a primary key
			  
			  @DeleteMapping("check/{id}")
			  public ResponseEntity<String>  deleteAccount(@PathVariable ("id") String checkupId){
			  
			  return fullCheckupService.deleteCheckup(checkupId);
			  
			  }
			  
			 
	
}
