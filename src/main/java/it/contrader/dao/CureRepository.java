package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Cure;
import it.contrader.model.Patology;
import it.contrader.model.Reading;


/**
 * Estende CrudRepository ed eredita tutti i metodi di CRUD. 
 * Definisce il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 *
 * @see CrudRepository
 *
 */
@Repository
@Transactional
public interface CureRepository extends CrudRepository<Cure, Long>{

	Cure findById(int id);
	
	List<Cure> findAllByPatology(Patology patology);
	
	List<Cure> findAllByReading(Reading reading);
	
}
