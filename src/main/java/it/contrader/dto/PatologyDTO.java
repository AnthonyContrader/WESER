package it.contrader.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatologyDTO {

	
	private int idpato;

	private String pato;

	private String carename;

	private String patcf;
	
	private String quantity;

	private int patominpress;

	private int patomaxpress;
	
	private int patomincir;

	private int patomaxcir;
	
	private int patominbreath;

	private int patomaxbreath;
	
	private float patomintemp;

	private float patomaxtemp;

	public PatologyDTO(String pato, String carename, String patcf, String quantity, int patominpress, int patomaxpress, int patomincir, int patomaxcir, int patominbreath, int patomaxbreath, float patomintemp, float patomaxtemp) {
		this.pato = pato;
		this.carename = carename;
		this.patcf = patcf;
		this.quantity = quantity;
		this.patominpress = patominpress;
		this.patomaxpress = patomaxpress;
		this.patomincir = patomincir;
		this.patomaxcir = patomaxcir;
		this.patominbreath = patominbreath;
		this.patomaxbreath = patomaxbreath;
		this.patomintemp = patomintemp;
		this.patomaxtemp = patomaxtemp;
	}
	
}

	//private List<CureDTO> curesDTO;
	
	//private List<DeviceDTO> devicesDTO;

	//private List<EmergencyDTO> emergencysDTO;

	//private List<PatologyDTO> patologysDTO;

	//private List<PaymentDTO> paymentsDTO;
	
	//private List<ReadingDTO> readingsDTO;
	

