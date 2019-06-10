package it.contrader.model;

	public class Payment {
		private String cardtype;
		private String cardnum;
		private String cardown;
		private String cardexp;
		private int cvv,payId;
		
		public Payment(String cardtype, String cardnum, String cardown, String cardexp, int cvv) {
			super();
			this.cardtype = cardtype;
			this.cardnum = cardnum;
			this.cardown = cardown;
			this.cardexp = cardexp;
			this.cvv = cvv;
			this.payId=payId;
			
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

		public int getPayId() {
			return payId;
		}

		public void setPayId(int payId) {
			this.payId = payId;
		}
	}
		
		
		