package it.contrader.dto;

public class EmergencyDTO {
	private int Id_em;
	private String em_num;
	public EmergencyDTO(String em_num) {
		this.em_num = em_num;
	}
	
	public EmergencyDTO() {} 
	
	public int getId_em() {
		return Id_em;
	}

	public void setId_em(int Id_em) {
		this.Id_em = Id_em;
	}

	public String getEm_num() {
		return em_num;
	}

	public void setEm_num(String em_num) {
		this.em_num = em_num;
	}
	
}