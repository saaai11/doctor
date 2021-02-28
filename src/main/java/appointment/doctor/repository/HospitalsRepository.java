package appointment.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import appointment.doctor.entities.Hospitals;

@Repository
public interface HospitalsRepository extends JpaRepository<Hospitals, String> {

	public Hospitals findByEmail(String email);

	
}

