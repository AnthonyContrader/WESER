package it.contrader.dto;

public class CareTutorDTO {
	private String patname;
    private String patcf;
    private String patology;
    private String carename;
    private String quantity;
    private String notes;
	int patage,careid;
	
	public CareTutorDTO(String patname, int patage,String patcf, String patology, String carename, String quantity, String notes) {
		this.patname = patname;
		this.patage = patage;
		this.patcf = patcf;
		this.patology = patology;
		this.carename = carename;
		this.quantity = quantity;
		this.notes = notes;
		
	}
	
	public CareTutorDTO() {}

	public int getCareTutorcareid() {
		return careid;
	}

	public void setCareTutorcareid(int careid) {
		this.careid = careid;
	}
	
	public String getCareTutorpatname() {
		return patname;
	}

	public void setCareTutorpatname(String patname) {
		this.patname = patname;
	}

	public String getCareTutorpatcf() {
		return patcf;
	}

	public void setCareTutorpatcf(String patcf) {
		this.patcf = patcf;
	}

	public String getCareTutorpatology() {
		return patology;
	}

	public void setCareTutorpatology(String patology) {
		this.patology = patology;
	}

	public String getCareTutorcarename() {
		return carename;
	}

	public void setCareTutorcarename(String carename) {
		this.carename = carename;
	}

	public String getCareTutorquantity() {
		return quantity;
	}

	public void setCareTutorquantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCareTutornotes() {
		return notes;
	}

	public void setCareTutornotes(String notes) {
		this.notes = notes;
	}

	public int getCareTutorpatage() {
		return patage;
	}

	public void setCareTutorpatage(int patage) {
		this.patage = patage;
	}

	
}