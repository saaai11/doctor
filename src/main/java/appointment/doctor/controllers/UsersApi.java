package appointment.doctor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import appointment.doctor.entities.UserRegistration;
import appointment.doctor.repository.UsersRepository;
import appointment.doctor.services.CustomerService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pro-Medico/users")
public class UsersApi {
	
	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	CustomerService customerService;
	
	
	
	 @GetMapping()                                             // get mapping annotation
	  public List<UserRegistration> getAccounts() {
	  return customerService.getAccountss();
	   }
	 
	 @GetMapping("user/{id}")                                             // get mapping annotation
	  public ObjectNode getAccount(@PathVariable (value="id") String id) {
	  return customerService.getUserAccount(id);
	   }
	 
	 @PostMapping(value = "/login")
	 public ResponseEntity<String> login(@RequestBody UserRegistration user) {
		 
		 
		 UserRegistration userLogin = this.userRepository.findByEmail(user.getEmail());
		 
		 
		if(userLogin==null) {
			return new ResponseEntity<String>("Invalid email ID,check your email", HttpStatus.BAD_REQUEST);

		}
		
		 boolean isPasswordMatch = user.getPassword().equals(userLogin.getPassword());
		 System.out.println("Password : " + user.getPassword() + "   isPasswordMatch    : " + isPasswordMatch); 
		 
		 
		 if(isPasswordMatch)
				return new ResponseEntity<String>(""+ userLogin.getFirstName(), HttpStatus.OK);
		 else 
				return new ResponseEntity<String>("Password is incorrect", HttpStatus.FORBIDDEN);


		 
	 }
	 
	 @PostMapping( value = "savedetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	 public String postAccount(@RequestBody UserRegistration user ) {
		    
		// String password =  user.getPassword();
		 
		// user.setPassword(password);
		 
		 System.out.println(user.getFirstName());
		 
			return customerService.saveUserData(user); 
	       }
	 
	 
		@PutMapping("details/{id}")
		public ResponseEntity<String> updateAccount(@RequestBody UserRegistration user, @PathVariable (value = "id") String userId) {
			 
			return  customerService.updateUserAccount(userId, user);
			
		}
		
		//delete user by taking userid as a primary key

		@DeleteMapping("details/{id}")
		public ResponseEntity<String> deleteAccount(@PathVariable ("id") String userId){
			
			return customerService.deleteUserAccount(userId);
			
					}
			
	

}
