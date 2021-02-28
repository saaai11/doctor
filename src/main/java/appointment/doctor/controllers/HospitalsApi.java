
	
package appointment.doctor.controllers;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import appointment.doctor.entities.Hospitals;
import appointment.doctor.repository.HospitalsRepository;
import appointment.doctor.services.HospitalService;

	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("/pro-Medico/hospitals")
	public class HospitalsApi {
		
		

		@Autowired
		HospitalsRepository hospitalRepository;
		
		@Autowired
		HospitalService hospitalService;
		
		
		
		
		 @GetMapping()                                             // get mapping annotation
		  public List<Hospitals> getAccounts() {
		  return hospitalService.getAccountss();
		   }
		 
		 @GetMapping("hospital/{id}")                                             // get mapping annotation
		  public ObjectNode getAccount(@PathVariable (value="id") String id) {
		  return hospitalService.getHospitalAccount(id);
		   }
		 
		 @PostMapping(value = "/login")
		 public ResponseEntity<String> login(@RequestBody Hospitals hospital) {
			 
			 
			 Hospitals hospitalLogin = this.hospitalRepository.findByEmail(hospital.getEmail());
			 
			 
			if(hospitalLogin==null) {
				return new ResponseEntity<String>("Invalid email ID,check your email", HttpStatus.BAD_REQUEST);

			}
			
			 boolean isPasswordMatch = hospital.getPassword().equals(hospitalLogin.getPassword());
			 System.out.println("Password : " + hospital.getPassword() + "   isPasswordMatch    : " + isPasswordMatch); 
			 
			 
			 if(isPasswordMatch)
					return new ResponseEntity<String>(""+ hospitalLogin.getName(), HttpStatus.OK);
			 else 
					return new ResponseEntity<String>("Password is incorrect", HttpStatus.FORBIDDEN);


			 
		 }
		 
		 
		 @PostMapping( value = "savedetails", consumes = MediaType.APPLICATION_JSON_VALUE)
		 public String postAccount(@RequestBody Hospitals hospital ) {
			    
			
			 
			 
				return hospitalService.saveHospitalData(hospital); 
		       }
		 

			@PutMapping("details/{id}")
			public ResponseEntity<String> updateAccount(@RequestBody Hospitals hospital, @PathVariable (value = "id") String Id) {
				 
				return  hospitalService.updateHospitalAccount(Id, hospital);
				
			}
			
			//delete user by taking userid as a primary key

			@DeleteMapping("details/{id}")
			public ResponseEntity<String> deleteAccount(@PathVariable ("id") String Id){
				
				return hospitalService.deleteHospitalAccount(Id);
				
						}
			
		 
		 
				
		

	}



