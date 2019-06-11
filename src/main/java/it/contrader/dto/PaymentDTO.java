package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

	private String cardtype;
	
	private String cardnumb;

	private String cardown;
	
	private String cardexp;
	
	private int cvv;
	
}
