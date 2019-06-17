package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {
	
	private int id;

	private String regnum;
	
	private String devtype;

	private String descr;
	
	private int minpress;
	
	private int maxpress;
	
    private int mincir;
	
	private int maxcir;

	private int minbreath;
	
	private int maxbreath;

	private float mintemp;
	
	private float maxtemp;

	public DeviceDTO(String regnum, String devtype, String descr, int minpress, int maxpress, int mincir,
			int maxcir, int minbreath, int maxbreath, float mintemp, float maxtemp) {
		super();
		this.regnum = regnum;
		this.devtype = devtype;
		this.descr = descr;
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
