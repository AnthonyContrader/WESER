package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Emergency;

import java.util.List;

public interface EmergencyRepository extends CrudRepository<Emergency, Integer> {
	
	public List<Emergency> findAllByEmnum(String emnum);


	
}