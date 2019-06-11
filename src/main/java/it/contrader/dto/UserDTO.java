package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private Integer iduser;
	
	private String username;
	
	private String password;

	private String usertype;
	
	private String name;
	
	private String surname;
	
	private String ssn;
}
