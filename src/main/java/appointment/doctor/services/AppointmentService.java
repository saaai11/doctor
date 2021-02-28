package appointment.doctor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import appointment.doctor.entities.Appointments;
import appointment.doctor.entities.UserRegistration;
import appointment.doctor.repository.AppointmentsRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentsRepository appointmentsRepository;
	
	

	

	public List<AppointmentsRepository> getAppointments() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ObjectNode getEachDoctorAppointments(String doctorId) {
		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode createResponse = objectMapper.createObjectNode();


		Appointments doctor = this.appointmentsRepository.findByDoctorId(doctorId);
		
		
		
		
				
		
		 createResponse.put("status", "valid");
		 createResponse.put("data", doctor.toString());
		 return createResponse;	}
	
	
	public ObjectNode getEachAppointments(String userId) {

		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode createResponse = objectMapper.createObjectNode();


		Appointments existingUser = this.appointmentsRepository.findByUserId(userId);
		
		
		
		
				
		
		 createResponse.put("status", "valid");
		 createResponse.put("data", existingUser.toString());
		 return createResponse;
		 
	}

	public String saveAppointments(Appointments appointments) {
		
		
		Long min = (long)100000;
		Long max = (long)999999;

 
		
	      Integer accountNumber = (int)(Math.random() * (max - min + 1) + min);
	      String userId = "APP"+accountNumber;

		try {
			
			while( !appointmentsRepository.findById(userId).isEmpty()) {
		    	  accountNumber =  (int)(Math.random() * (max - min + 1) + min);  
		    	  userId = "APP"+accountNumber;
		      }

			
			
			appointments.setId(userId);
			
			appointmentsRepository.save(appointments);
			
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}


	public ResponseEntity<String> updateAppointment(Appointments appointment, String id) {
		Optional<Appointments> existingUser = this.appointmentsRepository.findById(id);
		if( !existingUser.isPresent()) {
			return new ResponseEntity<String>("Cannot delete", HttpStatus.UNAUTHORIZED);

		}	
				
		Appointments appointments = existingUser.get();
		
		
		
		
		this.appointmentsRepository.save(appointments);

		return new ResponseEntity<String>("Successfullu updated your details", HttpStatus.OK);
	}


	public ResponseEntity<String> deleteAppointment(String id) {
		Optional<Appointments> existingUser = this.appointmentsRepository.findById(id);
		if( !existingUser.isPresent()) {
			return new ResponseEntity<String>("Not a valid appointment", HttpStatus.UNAUTHORIZED);

		}		
		
		Appointments appointments = existingUser.get();

		this.appointmentsRepository.delete(appointments);
		return ResponseEntity.ok().build();
	}






}
