package it.contrader.model;

public class Payment {
	private int payId;
	private String cardnum;
	private String cardtype;
	private int cvv;
	private String cardexp;
	private String cardown;
	
	public Payment() {}
	
	public Payment(String cardtype, String cardnum,String cardown,String cardexp,int cvv) {
		this.cardtype=cardtype;
		this.cardnum=cardnum;
		this.cardown=cardown;
		this.cardexp=cardexp;
		this.cvv=cvv;
	}
	
	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}


	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	
	public int getCVV() {
		return cvv;
	}

	public void setCVV(int cvv) {
		this.cvv = cvv;
	}

	public String getCardexp() {
		return cardexp;
	}

	public void setCardexp(String cardexp) {
		this.cardexp = cardexp;
	}

	public String getCardown() {
		return cardown;
	}

	public void setCardown(String cardown) {
		this.cardown = cardown;
	}

}
