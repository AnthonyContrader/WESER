package it.contrader.model;

public class Care {
	private int careId;
	private String patname;
	private String patcf;
	private int patage;
	private String patology;
	private String carename;
	private String quantity;
	private String notes;
	

	public Care() {
	}

	public Care(String patname, String patcf, int patage, String patology, String carename, String quantity, String notes ) {
		this.patname = patname;
		this.patcf = patcf;
		this.patage = patage;
		this.patology = patology;
		this.carename = carename;
		this.quantity = quantity;
		this.notes = notes;
	}

	public int getCareId() {
		return careId;
	}

	public void setCareId(int careId) {
		this.careId = careId;
	}

	public String getPatname() {
		return patname;
	}
	public void setPatname(String patname) {
		this.patname = patname;
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
	
	
	
	@Override
	public String toString() {
		return this.getCareId() + "\t" + this.getPatname() + "\t" + this.getPatcf() + "\t" + this.getPatage() + "\t" + this.getPatology() + "\t" + this.getCarename() + "\t" + this.getQuantity() + "\t" + this.getNotes() ;
	}

	public boolean equals(Care careCompare) {
		if (!this.getPatname().equals(careCompare.getPatname())) {
			return false;
		}

		if (!this.getPatcf().equals(careCompare.getPatcf())) {
			return false;
		}
		
		
		if (!(this.getPatage() == (careCompare.getPatage()))) {
			return false;
		}
		
		if (!this.getPatology().equals(careCompare.getPatology())) {
			return false;
		}
		
		if (!this.getCarename().equals(careCompare.getCarename())) {
			return false;
		}
		
		if (!this.getQuantity().equals(careCompare.getQuantity())) {
			return false;
		}
		
		if (!this.getNotes().equals(careCompare.getNotes())) {
			return false;
		}
		
		return true;

	}

}
