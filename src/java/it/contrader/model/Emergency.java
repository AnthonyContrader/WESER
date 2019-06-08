package it.contrader.model;

public class Emergency {
	private int emId;
	private String emnum;
	
	
	public Emergency() {}
	
	public Emergency(String emnum) {
		this.emnum=emnum;
	}
	
	public int getEmId() {
		return emId;
	}

	public void setEmId(int emId) {
		this.emId = emId;
	}

	public String getEmnum() {
		return emnum;
	}

	public void setEmergency(String emnum) {
		this.emnum = emnum;
	}
	
	@Override
	public String toString() {
		return this.getEmId()+"\t"+this.getEmnum();
	}
	
	public boolean equals(Emergency emergencyCompare)  {
		if (!this.getEmnum().equals(emergencyCompare.getEmnum())) {
			return false;
		}
		
		return true;
				
	}
}
