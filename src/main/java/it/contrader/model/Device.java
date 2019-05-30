package it.contrader.model;

public class Device {
	private int devId;
	private String regnumber;
	private String devtype;
	private String description;
	private int minpress;
	private int maxpress;
	private int mincir;
	private int maxcir;
	private int minbreath;
	private int maxbreath;
	private float mintemp;
	private float maxtemp;

	public Device() {
	}

	public Device(String regnumber, String devtype, String description, int minpress, int maxpress, int mincir, int maxcir, int minbreath, int maxbreath, float mintemp, float maxtemp) {
		this.regnumber = regnumber;
		this.devtype = devtype;
		this.description = description;
		this.minpress = minpress;
		this.maxpress = maxpress;
		this.mincir = mincir;
		this.maxcir = maxcir;
		this.minbreath = minbreath;
		this.maxbreath = maxbreath;
		this.mintemp = mintemp;
		this.maxtemp = maxtemp;
	}

	public void setDevId(int devId) {
		this.devId = devId;
	}
	
	public int getDevId() {
		return devId;
	}

	public String getRegnumber() {
		return regnumber;
	}
	public void setRegnumber(String regnumber) {
		this.regnumber = regnumber;
	}

	public String getDevtype() {
		return devtype;
	}
	public void setDevtype(String devtype) {
		this.devtype = devtype;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getMinpress() {
		return minpress;
	}
	public void setMinpress(int minpress) {
		this.minpress = minpress;
	}
	

	public int getMaxpress() {
		return maxpress;
	}
	public void setMaxpress(int maxpress) {
		this.maxpress = maxpress;
	}
	
	public int getMincir() {
		return mincir;
	}
	public void setMincir(int mincir) {
		this.mincir = mincir;
	}
	

	public int getMaxcir() {
		return maxcir;
	}
	public void setMaxcir(int maxcir) {
		this.maxcir = maxcir;
	}
	
	public int getMinbreath() {
		return minbreath;
	}
	public void setMinbreath(int minbreath) {
		this.minbreath = minbreath;
	}
	

	public int getMaxbreath() {
		return maxbreath;
	}
	public void setMaxbreath(int maxbreath) {
		this.maxbreath = maxbreath;
	}
	
	public float getMintemp() {
		return mintemp;
	}
	public void setMintemp(float mintemp) {
		this.mintemp = mintemp;
	}
	

	public float getMaxtemp() {
		return maxtemp;
	}
	public void setMaxtemp(float maxtemp) {
		this.maxtemp = maxtemp;
	}
	
	@Override
	public String toString() {
		return this.getDevId() + "\t" + this.getRegnumber() + "\t" + this.getDevtype() + "\t" + this.getDescription() + "\t" + this.getMinpress() + "\t" + this.getMaxpress() + "\t" + this.getMincir() + "\t" + this.getMaxcir() + "\t" + this.getMinbreath() + "\t" + this.getMaxbreath() + "\t" + this.getMintemp() + "\t" + this.getMaxtemp();
	}

	public boolean equals(Device deviceCompare) {
		if (!this.getRegnumber().equals(deviceCompare.getRegnumber())) {
			return false;
		}

		if (!this.getDevtype().equals(deviceCompare.getDevtype())) {
			return false;
		}
		
		if (!this.getDescription().equals(deviceCompare.getDescription())) {
			return false;
		}
		
		if (!(this.getMinpress() == (deviceCompare.getMinpress()))) {
			return false;
		}
		
		if (!(this.getMaxpress() == (deviceCompare.getMaxpress()))) {
			return false;
		}
		if (!(this.getMincir() == (deviceCompare.getMincir()))) {
			return false;
		}
		
		if (!(this.getMaxcir() == (deviceCompare.getMaxcir()))) {
			return false;
		}
        
		if (!(this.getMinbreath() == (deviceCompare.getMinbreath()))) {
			return false;
		}
		
		if (!(this.getMaxbreath() == (deviceCompare.getMaxbreath()))) {
			return false;
		}
		
		if (!(this.getMintemp() == (deviceCompare.getMintemp()))) {
			return false;
		}
		
		if (!(this.getMaxtemp() == (deviceCompare.getMaxtemp()))) {
			return false;
		}
		return true;

	}

}
