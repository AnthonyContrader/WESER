package it.contrader.service;


import java.util.ArrayList;
import java.util.*;

import it.contrader.converter.UserConverter;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class UserServiceDTO {

	private final UserDAO userDAO;

	public UserServiceDTO() {
		this.userDAO = new UserDAO();
	}

	/**
	 * Come vediamo la lista recuperata � di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perch� � sporco e poco efficiente
	 */
	public List<UserDTO> getAllUsers() {

		List<User> list = userDAO.getAllUser();
		List<UserDTO> listDTO = new ArrayList<>();

		for (User user : list) {
			listDTO.add(UserConverter.toDTO(user));
		}

		return listDTO;
	}
	
	public UserDTO getUserByUsernameAndPasword(String username, String password) {
		return UserConverter.toDTO(userDAO.login(username, password));
	}

	public UserDTO readUser(UserDTO userDTO) {
		return UserConverter.toDTO(this.userDAO.readUser(UserConverter.toEntity(userDTO)));
	}
	
	public boolean updateUser(UserDTO userDTO) {
		return this.userDAO.updateUser(UserConverter.toEntity(userDTO));
		
}
	
	public boolean deleteUsers (UserDTO userDTO) {
		return this.userDAO.deleteUser(UserConverter.toEntity(userDTO));
		
}
	
	public boolean insertUsers (UserDTO usersDTO) {
		return this.userDAO.insertUser(UserConverter.toEntity(usersDTO));
	
}
		
	
	
}
