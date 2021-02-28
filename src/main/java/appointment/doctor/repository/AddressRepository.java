package appointment.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import appointment.doctor.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
