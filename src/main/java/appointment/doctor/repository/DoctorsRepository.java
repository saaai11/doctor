package appointment.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import appointment.doctor.entities.Doctors;
import appointment.doctor.entities.UserRegistration;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, String> {

	public Doctors findByEmail(String email);

	
}
