package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Reading;

public interface ReadingRepository extends CrudRepository<Reading, Integer> {

	public List<Reading> findAllByPatcf(String patcf);
}