package it.contrader.model;

public class User {
	private int userId;
	private String username;
	private String password;
	private String usertype;
	private String cf;
	private String surname;
	private String name;
	
	public User() {}
	
	public User(String username, String usertype, String password,String name,String surname,String cf) {
		this.username=username;
		this.usertype=usertype;
		this.password=password;
		this.name=name;
		this.surname=surname;
		this.cf=cf;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUser(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	
	@Override
	public String toString() {
		return this.getUserId()+"\t"+this.getUsername()+"\t"+
				this.getPassword()+"\t"+this.getUsertype();
	}
	
	public boolean equals(User userCompare)  {
		if (!this.getUsername().equals(userCompare.getUsername())) {
			return false;
		}
		
		if (!this.getPassword().equals(userCompare.getPassword())) {
			return false;
		}
		
		if (!this.getUsertype().equals(userCompare.getUsertype())) {
			return false;
		}
		
		return true;
				
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
