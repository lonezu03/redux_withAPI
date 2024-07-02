package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Data
@NoArgsConstructor
public class EmployeeDTO {
	@NonNull
	private Integer idem;
	
	private String nameem;
	
	private Integer idcom;

	public Integer getIdem() {
		return idem;
	}

	public void setIdem(Integer idem) {
		this.idem = idem;
	}

	public String getNameem() {
		return nameem;
	}

	public void setNameem(String nameem) {
		this.nameem = nameem;
	}

	public Integer getIdcom() {
		return idcom;
	}

	public void setIdcom(Integer idcom) {
		this.idcom = idcom;
	}

}
