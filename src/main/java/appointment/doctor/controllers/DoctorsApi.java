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

import appointment.doctor.entities.Doctors;
import appointment.doctor.repository.DoctorsRepository;
import appointment.doctor.services.DoctorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pro-Medico/doctors")
public class DoctorsApi {
	
	

	@Autowired
	DoctorsRepository doctorRepository;
	
	@Autowired
	DoctorService doctorService;
	
	
	
	 @GetMapping()                                             // get mapping annotation
	  public List<Doctors> getAccounts() {
	  return doctorService.getAccountss();
	   }
	 
	 @GetMapping("doctors/{id}")                                             // get mapping annotation
	  public ObjectNode getAccount(@PathVariable (value="id") String id) {
	  return doctorService.getDoctorAccount(id);
	   }
	 
	 @PostMapping(value = "/login")
	 public ResponseEntity<String> login(@RequestBody Doctors doctor) {
		 
		 
		 Doctors doctorLogin = this.doctorRepository.findByEmail(doctor.getEmail());
		 
		 
		if(doctorLogin==null) {
			return new ResponseEntity<String>("Invalid email ID,check your email", HttpStatus.BAD_REQUEST);

		}
		
		 boolean isPasswordMatch = doctor.getPassword().equals(doctorLogin.getPassword());
		 System.out.println("Password : " + doctor.getPassword() + "   isPasswordMatch    : " + isPasswordMatch); 
		 
		 
		 if(isPasswordMatch)
				return new ResponseEntity<String>(""+ doctorLogin.getName(), HttpStatus.OK);
		 else 
				return new ResponseEntity<String>("Password is incorrect", HttpStatus.FORBIDDEN);


		 
	 }
	 
	 
	 @PostMapping( value = "savedetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	 public String postAccount(@RequestBody Doctors doctors ) {
		    
		
		 
		 
			return doctorService.saveDoctorData(doctors); 
	       }
	 

		@PutMapping("details/{id}")
		public ResponseEntity<String> updateAccount(@RequestBody Doctors doctor, @PathVariable (value = "id") String userId) {
			 
			return  doctorService.updateDoctorAccount(userId, doctor);
			
		}
		
		//delete user by taking userid as a primary key

		@DeleteMapping("details/{id}")
		public ResponseEntity<String> deleteAccount(@PathVariable ("id") String userId){
			
			return doctorService.deleteDoctorAccount(userId);
			
					}
		
	 
	 
			
	

}
