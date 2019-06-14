package it.contrader.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmergencyDTO {

	
	private int idem;

	private String emnum;
	
	public EmergencyDTO(String emnum) {
		this.emnum = emnum;

	}
	
	
	

	//private List<CureDTO> curesDTO;
	
	//private List<DeviceDTO> devicesDTO;

	//private List<EmergencyDTO> emergencysDTO;

	//private List<PatologyDTO> patologysDTO;

	//private List<PaymentDTO> paymentsDTO;
	
	//private List<ReadingDTO> readingsDTO;
	
	
	
	
}
