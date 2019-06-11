package it.contrader.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadingDTO {
	
	private int idread;

	private String patcf;
	
	private String regdev;
	
	private int minpress;
	
	private int maxpress;
	
    private int mincir;
	
	private int maxcir;

	private int minbreath;
	
	private int maxbreath;

	private float mintemp;
	
	private float maxtemp;

	public void setPeriod(java.util.Date period) {
		// TODO Auto-generated method stub
		
	}

	public java.util.Date getPeriod() {
		// TODO Auto-generated method stub
		return null;
	}
}
