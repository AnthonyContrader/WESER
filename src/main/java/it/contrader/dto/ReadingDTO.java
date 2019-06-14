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

	public ReadingDTO(String patcf, String regdev, int minpress, int maxpress, int mincir, int maxcir, int minbreath,
			int maxbreath, float mintemp, float maxtemp, Date period) {
		super();
		this.patcf = patcf;
		this.regdev = regdev;
		this.minpress = minpress;
		this.maxpress = maxpress;
		this.mincir = mincir;
		this.maxcir = maxcir;
		this.minbreath = minbreath;
		this.maxbreath = maxbreath;
		this.mintemp = mintemp;
		this.maxtemp = maxtemp;
		this.period = period;
	}
	
	

//	public void setPeriod(java.util.Date period) {
//		// TODO Auto-generated method stub
//		
//	}

	//public java.util.Date getPeriod() {
		// TODO Auto-generated method stub
	//}
}
