package it.contrader.repository;

import it.contrader.domain.Patology;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Patology entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PatologyRepository extends JpaRepository<Patology, Long> {

}
