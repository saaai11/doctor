package appointment.doctor.Util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import appointment.doctor.dto.AddressDTO;
import appointment.doctor.dto.DoctorsDTO;
import appointment.doctor.dto.UserRegistrationDTO;
import appointment.doctor.entities.Address;
import appointment.doctor.entities.Doctors;
import appointment.doctor.entities.UserRegistration;

public class ResponseUtil {
	
	
	public static void createResponse(Object sourceObject,Object destinationObject) {
		
		if(sourceObject instanceof UserRegistration && destinationObject instanceof UserRegistrationDTO) {
			UserRegistration userRegistration = (UserRegistration)sourceObject;
			UserRegistrationDTO userRegistrationDTO = (UserRegistrationDTO)destinationObject;
			List<Address> address = userRegistration.getAddress();
			 List<AddressDTO> addresses = new ArrayList<AddressDTO>();
			 for (Address add : address) {
				 AddressDTO addressDTO = new AddressDTO();
			    BeanUtils.copyProperties(add,addressDTO);
			    addresses.add(addressDTO);
			}
			 
			 userRegistrationDTO.setAddress(addresses);	

		}else if(sourceObject instanceof Doctors && destinationObject instanceof DoctorsDTO) {
			Doctors doctor = (Doctors)sourceObject;
			DoctorsDTO doctorDTO = (DoctorsDTO)destinationObject;
			List<Address> address = doctor.getAddress();
			 List<AddressDTO> addresses = new ArrayList<AddressDTO>();
			 for (Address add : address) {
				 AddressDTO addressDTO = new AddressDTO();
			    BeanUtils.copyProperties(add,addressDTO);
			    addresses.add(addressDTO);
			}
			 
			 doctorDTO.setAddress(addresses);	
		}
		
	}
	
}
