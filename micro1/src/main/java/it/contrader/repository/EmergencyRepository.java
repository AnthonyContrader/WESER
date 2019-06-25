package it.contrader.repository;

import it.contrader.domain.Emergency;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Emergency entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmergencyRepository extends JpaRepository<Emergency, Long> {

}
