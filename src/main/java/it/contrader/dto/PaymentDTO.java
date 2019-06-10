package it.contrader.dto;

public class PaymentDTO {

	private int payId;
	private String cardtype;
	private String cardnum;
	private String cardown;
	private String cardexp;
	private int cvv;
	
	public PaymentDTO() {}
	public PaymentDTO(String cardtype, String cardnum, String cardown, String cardexp, int cvv) {
		super();
		this.payId = payId;
		this.cardtype = cardtype;
		this.cardnum = cardnum;
		this.cardown = cardown;
		this.cardexp = cardexp;
		this.cvv = cvv;
	}

	public int getPayid() {
		return payId;
	}

	public void setPayid(int payId) {
		this.payId = payId;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getCardown() {
		return cardown;
	}

	public void setCardown(String cardown) {
		this.cardown = cardown;
	}

	public String getCardexp() {
		return cardexp;
	}

	public void setCardexp(String cardexp) {
		this.cardexp = cardexp;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	}