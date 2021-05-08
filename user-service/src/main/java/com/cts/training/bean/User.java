package com.cts.training.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
//@Table(name="user_details")
public class User {
	@Id
	@Column(name="user_id")
	private Long id;
	@NotEmpty(message="The username field can not be empty!")
	//@Size(min=8,max=50,message="The username shold be minimum 8 characters")
	private String username;
	@NotBlank
	private String password;
	@NotEmpty(message="itsholudbe not empty")
	private String address;
	private Long phone;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
}
