package it.contrader.dto;

public class DoctorDTO {

	private int careid;
	private String patname;
	private String patcf;
	private int patage;
	private String patology;
	private String carename;
	private String quantity;
	private String notes;
	
	public DoctorDTO(String patname,String patcf, int patage, String patology, String carename, String quantity, String notes) {
		super();
		this.careid = careid;
		this.patname = patname;
		this.patcf = patcf;
		this.patage = patage;
		this.patology=patology;
		this.carename=carename;
		this.quantity=quantity;
		this.notes=notes;
	}




	public int getCareid() {
		return careid;
	}




	public void setCareid(int careid) {
		this.careid = careid;
	}




	public String getPatcf() {
		return patcf;
	}


	public void setPatcf(String patcf) {
		this.patcf = patcf;
	}


	public int getPatage() {
		return patage;
	}


	public void setPatage(int patage) {
		this.patage = patage;
	}


	public String getPatology() {
		return patology;
	}


	public void setPatology(String patology) {
		this.patology = patology;
	}


	public String getCarename() {
		return carename;
	}


	public void setCarename(String carename) {
		this.carename = carename;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getPatname() {
		return patname;
	}

	public void setPatname(String patname) {
		this.patname = patname;
	}
	

}