package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Cure;

public interface CureRepository extends CrudRepository<Cure, Integer> {

	public List<Cure> findAllByCure(Cure cure);
}
 