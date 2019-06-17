package it.contrader.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	
	private int id;

	private String username;

	private String password;

	private String usertype;
	
	private String name;

	private String surname;

	private String ssn;

	public UserDTO( String username, String password, String usertype, String name, String surname,
			String ssn) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.name = name;
		this.surname = surname;
		this.ssn = ssn;
	}
	
	
	
}
