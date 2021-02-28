package appointment.doctor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import appointment.doctor.entities.Doctors;
import appointment.doctor.entities.UserRegistration;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, String> {

	public Doctors findByEmail(String email);
	
	public List<Doctors> findBySpecialization(String specialization);

	
}
