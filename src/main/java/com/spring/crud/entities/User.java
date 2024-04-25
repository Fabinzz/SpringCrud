package com.spring.crud.entities;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {
	@Id
	private String id;
	private String cpf;
	private String name;
	private String phone;
	private String email;
	private String password;
	private Date updateDate;
	private Date registrationDate;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String id, String cpf, String name, String phone, String email, String password,
			Date updateDate, Date registrationDate) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.updateDate = updateDate;
		this.registrationDate = registrationDate;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
}

