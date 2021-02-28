package appointment.doctor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import appointment.doctor.entities.Appointments;
import appointment.doctor.repository.AppointmentsRepository;
import appointment.doctor.services.AppointmentService;

@RestController
@RequestMapping("/pro-Medico/appointments/")
public class AppointmentsApi {
	
	@Autowired
	AppointmentsRepository appointmentsRepository;
	
	@Autowired
	AppointmentService appointmentService;
	
	
	 @GetMapping("/appointment")                                             // get mapping annotation
	  public List<AppointmentsRepository> getAccounts() {
	  return appointmentService.getAppointments();
	   }
	 
	
	 
	 @GetMapping("appointment/{userid}")                                             // get mapping annotation
	  public ObjectNode fetchAppointment(@PathVariable(value="userid") String userId) {
		 return appointmentService.getEachAppointments(userId);
	   }
	 
	 @GetMapping("appointment/{doctorid}")                                             // get mapping annotation
	  public ObjectNode fetchAppointmentDoctor(@PathVariable (value="doctorid") String doctorId) {
		 return appointmentService.getEachDoctorAppointments(doctorId);
	   }
	 
	@PostMapping(value = "bookappointments", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createAppointments(@RequestBody Appointments appointments){
		
		return appointmentService.saveAppointments(appointments);
		
	}
	
	
	
	
	
	

}
