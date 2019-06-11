package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Emergency;

public interface EmergencyRepository extends CrudRepository<Emergency, Integer> {

	public List<Emergency> findAllByEmergency(Emergency emergency);
}
 