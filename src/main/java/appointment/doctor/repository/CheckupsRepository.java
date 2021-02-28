package appointment.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import appointment.doctor.entities.FullCheckup;


public interface CheckupsRepository extends JpaRepository<FullCheckup, String> {

}
