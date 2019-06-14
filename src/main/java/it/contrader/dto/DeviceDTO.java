package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {
	
	private Integer iddev;

	private String regnumber;
	
	private String devtype;

	private String description;
	
	private int minpress;
	
	private int maxpress;
	
    private int mincir;
	
	private int maxcir;

	private int minbreath;
	
	private int maxbreath;

	private float mintemp;
	
	private float maxtemp;

	public DeviceDTO(String regnumber, String devtype, String description, int minpress, int maxpress, int mincir,
			int maxcir, int minbreath, int maxbreath, float mintemp, float maxtemp) {
		super();
		this.regnumber = regnumber;
		this.devtype = devtype;
		this.description = description;
		this.minpress = minpress;
		this.maxpress = maxpress;
		this.mincir = mincir;
		this.maxcir = maxcir;
		this.minbreath = minbreath;
		this.maxbreath = maxbreath;
		this.mintemp = mintemp;
		this.maxtemp = maxtemp;
	}
	
	
}
