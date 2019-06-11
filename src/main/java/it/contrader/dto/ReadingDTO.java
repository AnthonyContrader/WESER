package it.contrader.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadingDTO {
	
	private Integer idread;

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
	
	private Date period;
	
	

//	public void setPeriod(java.util.Date period) {
//		// TODO Auto-generated method stub
//		
//	}

	//public java.util.Date getPeriod() {
		// TODO Auto-generated method stub
	//}
}
