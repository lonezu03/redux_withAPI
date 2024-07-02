package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.Enum.Loaicom;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="company")
@Data
@NoArgsConstructor
public class Company implements Serializable{
	private static final long serialVersionUID=1l;

	@Column(name="idcom")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcom;
	
	@Column(name="companyname",length = 30,updatable = true)
	private String companyname;
	@Column (name="loaicom",updatable=true)
	@Enumerated(EnumType.STRING)
	private Loaicom loaicom;
	@Column(name="createat",updatable = false,insertable = false,columnDefinition = "datetime default current_timestamp")
	private LocalDateTime createat;
	@Column(name="updateat",updatable = false,insertable = false,columnDefinition = "datetime default current_timestamp on update current_timestamp")
	private LocalDateTime updateat;
	@OneToMany(mappedBy ="idcom")
	private List<Employee> employees;

	
	public Loaicom getLoaicom() {
		return loaicom;
	}

	public void setLoaicom(Loaicom loaicom) {
		this.loaicom = loaicom;
	}

	public int getIdcom() {
		return idcom;
	}

	public void setIdcom(int idcom) {
		this.idcom = idcom;
	}

	public LocalDateTime getCreateat() {
		return createat;
	}

	public void setCreateat(LocalDateTime createat) {
		this.createat = createat;
	}

	public LocalDateTime getUpdateat() {
		return updateat;
	}

	public void setUpdateat(LocalDateTime updateat) {
		this.updateat = updateat;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Company() {
		super();
	}
	
	
}
