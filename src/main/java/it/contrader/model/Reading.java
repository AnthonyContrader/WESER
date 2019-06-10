package it.contrader.model;

public class Reading {
	private int readId;
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
	
	public Reading() {}

	public Reading(String patcf, String regdev, int minpress, int maxpress, int mincir, int maxcir, int minbreath, int maxbreath, float mintemp, float maxtemp) {
		//this.readId = readId;
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
	}



	public int getReadId() {
		return readId;
	}



	public void setReadId(int readId) {
		this.readId = readId;
	}



	public String getPatcf() {
		return patcf;
	}



	public void setPatcf(String patcf) {
		this.patcf = patcf;
	}



	public String getRegdev() {
		return regdev;
	}



	public void setRegdev(String regdev) {
		this.regdev = regdev;
	}


	public int getMinpress() {
		return minpress;
	}



	public void setMinpress(int minpress) {
		this.minpress = minpress;
	}



	public int getMaxpress() {
		return maxpress;
	}



	public void setMaxpress(int maxpress) {
		this.maxpress = maxpress;
	}



	public int getMincir() {
		return mincir;
	}



	public void setMincir(int mincir) {
		this.mincir = mincir;
	}



	public int getMaxcir() {
		return maxcir;
	}



	public void setMaxcir(int maxcir) {
		this.maxcir = maxcir;
	}



	public int getMinbreath() {
		return minbreath;
	}



	public void setMinbreath(int minbreath) {
		this.minbreath = minbreath;
	}



	public int getMaxbreath() {
		return maxbreath;
	}



	public void setMaxbreath(int maxbreath) {
		this.maxbreath = maxbreath;
	}



	public float getMintemp() {
		return mintemp;
	}



	public void setMintemp(float mintemp) {
		this.mintemp = mintemp;
	}



	public float getMaxtemp() {
		return maxtemp;
	}



	public void setMaxtemp(float maxtemp) {
		this.maxtemp = maxtemp;
	}
	
}