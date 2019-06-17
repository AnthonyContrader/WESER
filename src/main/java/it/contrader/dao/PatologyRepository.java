package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Patology;

public interface PatologyRepository extends CrudRepository<Patology, Integer> {

	public List<Patology> findAllByPato(String pato);

}
 