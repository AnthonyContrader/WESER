package it.contrader.converter;

import it.contrader.dto.UserDTO;
import it.contrader.model.User;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class UserConverter {

	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static User toEntity(UserDTO userDTO) {

		User user = null;
		if (userDTO != null) {
			user = new User(userDTO.getUsername(),userDTO.getUsertype(),userDTO.getPassword(),userDTO.getName(),userDTO.getSurname(),userDTO.getCf());

			if (userDTO.getId() != 0)
				user.setUserId(userDTO.getId());
		}
		
		
		return user;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */

	public static UserDTO toDTO(User user) {

		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO(user.getUsername(),  user.getUsertype(),user.getPassword(),user.getName(),user.getSurname(),user.getCf());
			userDTO.setId(user.getUserId());
			// userDTO.setId(user.getUserId());
		}

		return userDTO;
	}

}