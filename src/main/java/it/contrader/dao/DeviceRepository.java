package it.contrader.dao;



import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.model.Device;



import java.util.List;



import javax.transaction.Transactional;



public interface DeviceRepository extends CrudRepository<Device, Integer> {


	public static List<Device> findAllById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}