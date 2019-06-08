package it.contrader.model;



	
		
	public class Doctor {
		private int careid;
		private String parname;
		private String patcf;
		private int patage;
		private String carename;
		private String quantity;
		private String patology;
		private String notes;
		
		public Doctor( String parname, String patcf, int patage, String patology,String carename, String quantity,
				String notes) {
			super();
			this.parname = parname;
			this.patcf = patcf;
			this.patage = patage;
			this.carename = carename;
			this.quantity = quantity;
			this.notes = notes;
			this.patology=patology;
			
			
		}

		
	public String getParname() {
		return parname;
	}

	public void setParname(String parname) {
		this.parname = parname;
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


	public String getPatology() {
		return patology;
	}


	public void setPatology(String patology) {
		this.patology = patology;
	}


	public int getCareid() {
		return careid;
	}


	public void setCareid(int careid) {
		this.careid = careid;
	}
	
	
}
