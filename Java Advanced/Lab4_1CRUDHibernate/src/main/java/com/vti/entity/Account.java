package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "Account" ,catalog = "TestingSystem4Spring")
public class Account implements Serializable{
	
	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "Email" , nullable = false , unique = true , updatable = false)
	private String email;
	
	@Column(name = "Username" , nullable = false , unique = true)
	private String userName	;
	
	@Column(name = "fullName" , nullable = false )
	private String fullName;
	
	@ManyToOne
	@JoinColumn(name = "DepartmentID" , nullable = false)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "PositionID" , nullable = false)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private Position position;
	
	@Column(name = "CreateDate" )
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createDate;
}
