package it.contrader.dto;

public class UserDTO {
	private int userId;
	private String username;
	private String usertype;
	private String password;
	private String name;
	private String surname;
	private String cf;
	
	public UserDTO(String username, String usertype, String password, String name, String surname, String cf) {
		this.username = username;
		this.usertype = usertype;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.cf = cf;
	}
	
	public UserDTO() {} 
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}
	
}
