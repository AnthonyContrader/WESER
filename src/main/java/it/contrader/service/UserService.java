package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ConverterUser;
import it.contrader.dao.LoginDAO;
import it.contrader.dao.RegisterDAO;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.utils.Request;


public class UserService{

	private final UserDAO usersDAO;
	private final LoginDAO loginDAO;
	private final RegisterDAO registerDAO;

	public UserService() {
		this.usersDAO = new UserDAO();
		this.loginDAO = new LoginDAO();
		this.registerDAO = new RegisterDAO();
	}

	/**
	 * Come vediamo la lista recuperata è di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perchè è sporco e poco efficiente
	 */
	public List<UserDTO> getAllUsers() {

		List<User> list = usersDAO.getAllUser();
		List<UserDTO> listDTO = new ArrayList<>();

		for (User users : list) {
			listDTO.add(ConverterUser.toDTO(users));
		}

		return listDTO;
	}
	
	public boolean insertUser(UserDTO userDTO) {
		return this.usersDAO.insertUser(ConverterUser.toEntity(userDTO));
	}
	public Request login (String username, String password) {
		return this.loginDAO.login(username, password);
	}
	
	public String register (String username, String password,String usertype,String name,String surname,String ssc) {
		return this.registerDAO.register(username, usertype,password,name,surname,ssc);
	}
	
	public boolean updateUser(UserDTO userDTO) {
		return this.usersDAO.updateUser(ConverterUser.toEntity(userDTO));
	}
	
	public boolean delete (int id_user) {
		return this.usersDAO.deleteUser(id_user);
	}
	
	public List<User> getAllUser() {
		return this.usersDAO.getAllUser();
	}
	
	
	

	
}