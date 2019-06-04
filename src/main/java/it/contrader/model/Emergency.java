package it.contrader.model;

public class Emergency {
	private int id_em;
	private String em_num;


	public Emergency() {}
	public Emergency(String em_num) {
		this.em_num = em_num;

	}

	public int getId_Em() {
		return id_em;
	}

	public void setId_em(int id_em) {
		this.id_em=id_em;
	}

	public String getEm_num() {
		return em_num;
	}
	public void setEm_num (String em_num) {
		this.em_num = em_num;
	}

    
	@Override
	public String toString() {
		return this.getId_Em() + "\t" + this.getEm_num();
	}

	public boolean equals(Emergency emergencyCompare) {
		if (!this.getEm_num().equals(emergencyCompare.getEm_num())) {
			return false;
		}


		return true;

	}

}
