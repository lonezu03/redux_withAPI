package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Company;
import com.example.demo.form.CompanyForm;


public interface ICompanyService {
	public Company getcompanyByID(int id);
	public void updatecompanyByID(CompanyForm form);
	public void deletecompanyByID(int id);
	public List<Company> getAllcompanys();
	public Company createcompany(CompanyForm form);
}
