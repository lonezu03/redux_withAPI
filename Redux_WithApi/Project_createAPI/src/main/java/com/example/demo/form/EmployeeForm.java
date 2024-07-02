package com.example.demo.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeForm {
	private int idem;
	private String nameem;
	private int idcom;
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
	public int getIdcom() {
		return idcom;
	}
	public void setIdcom(int idcom) {
		this.idcom = idcom;
	}
}
