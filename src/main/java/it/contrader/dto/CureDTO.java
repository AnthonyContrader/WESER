package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CureDTO {
	
	private int idcure;
	
	private String patname;
	
	private String patcf;
	
	private int patage;
	
	private String pato;
	
	private String carename;

	private String quantity;
	
	private String notes;
	
}
