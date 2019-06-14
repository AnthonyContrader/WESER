package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Cure;

import java.util.List;

public interface CureRepository extends CrudRepository<Cure, Integer> {

	public List<Cure> findAllByCurename(String curename);
}
