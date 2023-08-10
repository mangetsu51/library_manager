package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "USER_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer Id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setId(String Name) {
		this.name = name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String Email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String Password) {
		this.password = password;
	}
}
