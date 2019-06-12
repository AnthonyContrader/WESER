package it.contrader.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	
	private int iduser;

	private String username;

	private String password;

	private String usertype;
	
	private String name;

	private String surname;

	private String ssn;
	
	

	//private List<CureDTO> curesDTO;
	
	//private List<DeviceDTO> devicesDTO;

	//private List<EmergencyDTO> emergencysDTO;

	//private List<PatologyDTO> patologysDTO;

	//private List<PaymentDTO> paymentsDTO;
	
	//private List<ReadingDTO> readingsDTO;
	
	
	
	
}
