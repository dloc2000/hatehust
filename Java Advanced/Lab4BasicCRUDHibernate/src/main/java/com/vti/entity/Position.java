package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Data;


@Entity
@Data
@Table(name = "Position" ,catalog = "TestingSystem4Spring")
public class Position implements Serializable{
	
	@Column(name = "PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id ;
	
	@Column(name = "PositionName" , nullable = false ,unique = true)
	@Enumerated(EnumType.STRING)
	private PositionName name;
	
	public enum PositionName {
		Dev , Test ,Scrum_Master , PM
	}
	
	@OneToMany(mappedBy = "position", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private List<Account> account ;
	
}
