package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CureDTO {
	
	private int id;
	
	private String patname;
	
	private String patcf;

	private int patage;
	
	private String pato;
	
	private String curename;
	
	private String quantity;
	
	private String notes;

	public CureDTO(String patname, String patcf, int patage, String pato, String curename, String quantity,
			String notes) {
		super();
		this.patname = patname;
		this.patcf = patcf;
		this.patage = patage;
		this.pato = pato;
		this.curename = curename;
		this.quantity = quantity;
		this.notes = notes;
	}
	
	
}
