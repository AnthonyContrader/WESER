package it.contrader.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadingDTO {
	
	private Integer id;

	private String patcf;
	
	private String regdev;
	
	private int minpress;
	
	private int maxpress;
	
    private int cir;

	private int breath;

	private float temp;
	
	private String giornora;
	
	
	//private Date period;

	public ReadingDTO(String patcf, String regdev, int minpress, int maxpress, int cir, int breath, float temp, String giornora) {
		super();
		this.patcf = patcf;
		this.regdev = regdev;
		this.minpress = minpress;
		this.maxpress = maxpress;
		this.cir = cir;
		this.breath = breath;
		this.temp = temp;
		this.giornora = giornora;
		//this.period = period;
	}
	
	

//	public void setPeriod(java.util.Date period) {
//		// TODO Auto-generated method stub
//		
//	}

	//public java.util.Date getPeriod() {
		// TODO Auto-generated method stub
	//}
}
