package it.contrader.dto;

public class PaymentDTO {
	private int pay_id;
	private String card_type;
	private String card_number;
	private String card_owner;
	private String card_expire;
	private int CVV;
	
	public PaymentDTO(String card_type, String card_number, String card_owner, String card_expire, int CVV) {
		this.card_type = card_type;
		this.card_number = card_number;
		this.card_owner = card_owner;
		this.card_expire = card_expire;
		this.CVV = CVV;
	}
	
	public PaymentDTO() {} 
	
	public int getPay_id() {
		return pay_id;
	}

	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}

    public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	
	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getCard_owner() {
		return card_owner;
	}

	public void setCard_owner(String card_owner) {
		this.card_owner = card_owner;
	}
	
	public String getCard_expire() {
		return card_expire;
	}

	public void setCard_expire(String card_expire) {
		this.card_expire = card_expire;
	}
	
	public int getCVV() {
		return CVV;
	}

	public void setCVV(int CVV) {
		this.CVV = CVV;
	}
	
}