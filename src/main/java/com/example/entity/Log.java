package com.example.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "logs")
public class Log {
	
	@Id
	@SequenceGenerator(name = "LOG_ID_GENERATOR", sequenceName = "LOG_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOG_ID_GENERATOR")
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "LIBRARY_ID")
	private Integer libraryId;
	
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "RENT_DATE")
	private LocalDate rentDate;
	
	@ManyToOne
	@JoinColumn(name = "RETURN_DATE", insertable = false, updatable = false)
	private LocalDate return_date;
	
	@Column(name = "RETURN_DUE_DATE")
	private LocalDateTime return_due_date;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getLibrary_id() {
		return this.libraryId;
	}
	
	public void setLibrary_id(Integer library_id) {
		this.libraryId = library_id;
	}
	
	public Integer getUser_id() {
		return this.userId;
	}
	
	public void setUser_id(Integer user_id) {
		this.userId = user_id;
	}
	
	public LocalDate getRent_date() {
		return this.rentDate;
	}
	
	public void setRent_date(LocalDate rent_date) {
		this.rentDate = rent_date;
	}
	
	public LocalDate getReturn_date() {
		return this.return_date;
	}
	
	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}
	
	public LocalDateTime getReturn_due_date() {
		return this.return_due_date;
	}
	
	public void setReturn_due_date(LocalDateTime return_due_date) {
		this.return_due_date = return_due_date;
	}
	
	
}
