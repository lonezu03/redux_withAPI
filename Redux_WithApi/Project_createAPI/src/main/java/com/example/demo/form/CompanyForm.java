package com.example.demo.form;

import java.util.List;

import com.example.demo.entity.EmployeeDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyForm {
	private int idcom;
	private String companyname;
	private List<EmployeeDTO> employees;
	public int getIdcom() {
		return idcom;
	}
	public void setIdcom(int idcom) {
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
	
}
