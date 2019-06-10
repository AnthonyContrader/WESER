package it.contrader.dto;

public class PatologyDTO {

	private int patologyid;
	private String patology;
	private String carename;
	private String patcf;
	private String quantity;
	private int patominpress;
	private int patomaxpress;
	private int patomincir;
	private int patomaxcir;
	private int patominbreath;
	private int patomaxbreath;
	private float patomintemp;
	private float patomaxtemp;
	public PatologyDTO(String patology, String carename, String patcf, String quantity, int patominpress,
			int patomaxpress, int patomincir, int patomaxcir, int patominbreath, int patomaxbreath, float patomintemp,
			float patomaxtemp) {
		super();
		this.patology = patology;
		this.carename = carename;
		this.patcf = patcf;
		this.quantity = quantity;
		this.patominpress = patominpress;
		this.patomaxpress = patomaxpress;
		this.patomincir = patomincir;
		this.patomaxcir = patomaxcir;
		this.patominbreath = patominbreath;
		this.patomaxbreath = patomaxbreath;
		this.patomintemp = patomintemp;
		this.patomaxtemp = patomaxtemp;
	}
	public int getPatologyid() {
		return patologyid;
	}
	public void setPatologyid(int patologyid) {
		this.patologyid = patologyid;
	}
	public String getPatology() {
		return patology;
	}
	public void setPatology(String patology) {
		this.patology = patology;
	}
	public String getCarename() {
		return carename;
	}
	public void setCarename(String carename) {
		this.carename = carename;
	}
	public String getPatcf() {
		return patcf;
	}
	public void setPatcf(String patcf) {
		this.patcf = patcf;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getPatominpress() {
		return patominpress;
	}
	public void setPatominpress(int patominpress) {
		this.patominpress = patominpress;
	}
	public int getPatomaxpress() {
		return patomaxpress;
	}
	public void setPatomaxpress(int patomaxpress) {
		this.patomaxpress = patomaxpress;
	}
	public int getPatomincir() {
		return patomincir;
	}
	public void setPatomincir(int patomincir) {
		this.patomincir = patomincir;
	}
	public int getPatomaxcir() {
		return patomaxcir;
	}
	public void setPatomaxcir(int patomaxcir) {
		this.patomaxcir = patomaxcir;
	}
	public int getPatominbreath() {
		return patominbreath;
	}
	public void setPatominbreath(int patominbreath) {
		this.patominbreath = patominbreath;
	}
	public int getPatomaxbreath() {
		return patomaxbreath;
	}
	public void setPatomaxbreath(int patomaxbreath) {
		this.patomaxbreath = patomaxbreath;
	}
	public float getPatomintemp() {
		return patomintemp;
	}
	public void setPatomintemp(float patomintemp) {
		this.patomintemp = patomintemp;
	}
	public float getPatomaxtemp() {
		return patomaxtemp;
	}
	public void setPatomaxtemp(float patomaxtemp) {
		this.patomaxtemp = patomaxtemp;
	}

	
	
	
	}
