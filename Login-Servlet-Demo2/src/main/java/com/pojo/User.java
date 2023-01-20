package com.pojo;

public class User {
	
	private String name;
	private String address;
	private String mobile_no;
	private String email;
	private String password;
	
	
	
	public User(String name, String address, String mobile_no, String email, String password) {
		super();
		this.name = name;
		this.address = address;
		this.mobile_no = mobile_no;
		this.email = email;
		this.password = password;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + ", mobile_no=" + mobile_no + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
	

}
