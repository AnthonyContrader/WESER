package it.contrader.dao;



import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import org.springframework.web.bind.annotation.RequestParam;



import it.contrader.model.User;



import java.util.List;



import javax.transaction.Transactional;



public interface UserRepository extends CrudRepository<User, Integer> {



	public User findUserByUsernameAndPassword(String username,String password);

	public List<User> findAllByUsername(String username);
	
	
	
}