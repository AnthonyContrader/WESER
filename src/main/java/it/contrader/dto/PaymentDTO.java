package it.contrader.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

	
	private int idpay;

	private String cardtype;

	private String cardnumb;

	private String cardown;
	
	private String cardexp;

	private int cvv;
	
	public PaymentDTO(String cardtype, String cardnumb, String cardown, String cardexp, int cvv) {
		this.cardtype = cardtype;
		this.cardnumb = cardnumb;
		this.cardown = cardown;
		this.cardexp = cardexp;
		this.cvv = cvv;
	}

	//private List<CureDTO> curesDTO;
	
	//private List<DeviceDTO> devicesDTO;

	//private List<EmergencyDTO> emergencysDTO;

	//private List<PatologyDTO> patologysDTO;

	//private List<PaymentDTO> paymentsDTO;
	
	//private List<ReadingDTO> readingsDTO;
	
	
	
	
}
