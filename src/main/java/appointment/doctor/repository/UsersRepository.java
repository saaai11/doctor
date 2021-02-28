package appointment.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import appointment.doctor.entities.UserRegistration;

@Repository
public interface UsersRepository extends JpaRepository<UserRegistration, String>{

	public UserRegistration findByEmail(String email);

	
}
