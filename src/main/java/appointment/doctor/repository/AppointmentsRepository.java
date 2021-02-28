package appointment.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import appointment.doctor.entities.Appointments;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointments, String> {

	public Appointments findByUserId(String userId);
	
	public Appointments findByDoctorId(String doctorId);
	
	


	
}
