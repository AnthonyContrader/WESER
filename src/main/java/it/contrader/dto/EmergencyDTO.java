package it.contrader.dto;

public class EmergencyDTO {

	private Integer emId;
	private String emnum;
	
	

	
	public EmergencyDTO(String emnum) {
		super();
		//this.id = id;
		this.emnum = emnum;
	}

	public String getEmnum() {
		return emnum;
	}

	public void setName(String emnum) {
		this.emnum = emnum;
	}

	public Integer getEmId() {
		return emId;
	}

	public void setEmId(Integer emId) {
		this.emId = emId;
	}

	public boolean equals(EmergencyDTO emergencyCompare)  {
		if (!this.getEmnum().equals(emergencyCompare.getEmnum())) {
			return false;
		}
		return false;
			
	}
	

}