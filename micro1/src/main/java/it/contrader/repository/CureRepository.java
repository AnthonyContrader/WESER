package it.contrader.repository;

import it.contrader.domain.Cure;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Cure entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CureRepository extends JpaRepository<Cure, Long> {

}
