package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatologyDTO {

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
	
}
