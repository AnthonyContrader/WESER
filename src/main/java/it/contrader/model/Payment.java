package it.contrader.model;

public class Payment {
	private int pay_Id;
	private String card_type;
	private String card_number;
	private String card_owner;
	private String card_expire;
	private int CVV;

	public Payment() {
	}

	public Payment(String card_type, String card_number, String card_owner, String card_expire, int CVV) {
		this.card_type = card_type;
		this.card_number = card_number;
		this.card_owner = card_owner;
		this.card_expire = card_expire;
		this.CVV = CVV;
	}

   
	public int getPay_id() {
		return pay_Id;
	}

	public void setPay_id(int pay_Id) {
		this.pay_Id = pay_Id;
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
	
	@Override
	public String toString() {
		return this.getPay_id() + "\t" + this.getCard_type() + "\t" + this.getCard_number() + "\t" + this.getCard_owner() + "\t" + this.getCard_expire() + "\t" + this.getCVV();

	}
	
	public boolean equals(Payment paymentCompare) {
		if (!this.getCard_type().equals(paymentCompare.getCard_type())) {
			return false;
		}
		
		if (!this.getCard_number().equals(paymentCompare.getCard_number())) {
			return false;
		}
		
		if (!this.getCard_owner().equals(paymentCompare.getCard_owner())) {
			return false;
		}
		
		if (!this.getCard_expire().equals(paymentCompare.getCard_expire())) {
			return false;
		}
		
		if (!(this.getCVV() == (paymentCompare.getCVV()))) {
			return false;
		}

		return true;
	}


}
