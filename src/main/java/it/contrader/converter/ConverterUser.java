package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.UserDTO;
import it.contrader.model.User;

public class ConverterUser {

	public static UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO( user.getUsername(), user.getUsertype(), user.getPassword(), user.getName(), user.getSurname(), user.getCf());
			userDTO.setUserId(user.getUserId());
		}
		return userDTO;
	}

     public static User toEntity(UserDTO userDTO) {
    	 User user = null;
    	 if (userDTO != null) {
    		 user= new User(userDTO.getUsername(),
			userDTO.getUsertype(),
			userDTO.getPassword(),
			userDTO.getName(),
			userDTO.getSurname(),
			userDTO.getCf());
			
			if (userDTO.getUserId() != 0)
				user.setUserId(userDTO.getUserId ());
	
    	 }
    	 return user;
     }

	/*
	 * public static List<UserDTO> toListDTO(List<User> list) { List<UserDTO>
	 * listUserDTO = new ArrayList<>(); if (!list.isEmpty()) { for (User user :
	 * list) { listUserDTO.add(ConverterUser.toDTO(user)); } } return listUserDTO; }
	 * 
	 * public static List<User> toListEntity(List<UserDTO> listUserDTO) { List<User>
	 * list = new ArrayList<>(); if (!listUserDTO.isEmpty()) { for (UserDTO userDTO
	 * : listUserDTO) { list.add(ConverterUser.toEntity(userDTO)); } } return list;
	 * }
	 */
     
}
