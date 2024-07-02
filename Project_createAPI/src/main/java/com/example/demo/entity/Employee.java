package com.example.demo.entity;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="Employee")
@Data
@NoArgsConstructor
public class Employee implements Serializable{
	private static final long serialVersionUID=1l;
	
	@Column(name="idem")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idem;
	
	@Column(name="nameem",length = 50,updatable = true)
	private String nameem;
	
	@ManyToOne
	@JoinColumn(name="idcom")
	private Company idcom;

	public int getIdem() {
		return idem;
	}

	public void setIdem(int idem) {
		this.idem = idem;
	}

	public String getNameem() {
		return nameem;
	}

	public void setNameem(String nameem) {
		this.nameem = nameem;
	}

	public Company getIdcom() {
		return idcom;
	}

	public void setIdcom(Company idcom) {
		this.idcom = idcom;
	}

	
	

}
