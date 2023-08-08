package com.example.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LOGS")
public class Log {
	
	@Id
	@SequenceGenerator(name = "LOG_ID_GENERATOR", sequenceName = "LOG_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOG_ID_GENERATOR")
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "LIBRARY_ID")
	private Integer library_id;
	
	@Column(name = "USER_ID")
	private Integer user_id;
	
	@Column(name = "RENT_DATE")
	private Date rent_date;
	
	@Column(name = "RETURN_DATE")
	private Date return_date;
	
	@Column(name = "RETURN_DUE_DATE")
	private Date return_due_date;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer Id) {
		this.id = id;
	}
	
	public Integer getLibrary_id() {
		return this.library_id;
	}
	
	public void setLibrary_id(Integer Library_id) {
		this.library_id = library_id;
	}
	
	public Integer getUser_id() {
		return this.user_id;
	}
	
	public void setUser_id(Integer User_id) {
		this.user_id = user_id;
	}
	
	public Date getRent_date(Date Rent_date) {
		return this.rent_date;
	}
	
	public void setRent_date(Date Rent_date) {
		this.rent_date = rent_date;
	}
	
	public Date getReturn_date(Date Return_date) {
		return this.return_date;
	}
	
	public void setReturn_date(Date Return_date) {
		this.return_date = return_date;
	}
	
	public Date getReturn_due_date(Date Return_deu_date) {
		return this.rent_date;
	}
	
	public void setReturn_due_date(Date Return_due_date) {
		this.return_due_date = return_due_date;
	}
	
	
}
