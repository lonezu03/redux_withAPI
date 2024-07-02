package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.Enum.Loaicom;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyDTO {
	
	private Integer idcom;
	
	private String companyname;
	private Loaicom loaicom;
	private LocalDateTime createat;
	private LocalDateTime updateat;

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

	public Loaicom getLoaicom() {
		return loaicom;
	}

	public void setLoaicom(Loaicom loaicom) {
		this.loaicom = loaicom;
	}

	private List<EmployeeDTO> employees;

	public Integer getIdcom() {
		return idcom;
	}

	public void setIdcom(Integer idcom) {
		this.idcom = idcom;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public List<EmployeeDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDTO> employees) {
		this.employees = employees;
	}

	public CompanyDTO() {
		super();
	}
	
}
