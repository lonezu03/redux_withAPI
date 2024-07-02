package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Company;
import com.example.demo.form.CompanyForm;
import com.example.demo.repository.ICompanyRepository;
@Service
public class CompanyService implements ICompanyService {
	@Autowired
	private ICompanyRepository service;
	
	

	@Autowired 
	private ModelMapper modelMapper;
	
	
	
	
	@Override
	public Company getcompanyByID(int id) {
		// TODO Auto-generated method stub
		return service.findById(id).get();
	}

	@Override
	public void updatecompanyByID(CompanyForm form) {
		// TODO Auto-generated method stub
		Company department=modelMapper.map(form, Company.class);
		service.save(department);
	}

	@Override
	public void deletecompanyByID(int id) {
		// TODO Auto-generated method stub
		service.deleteById(id);

	}

	@Override
	public List<Company> getAllcompanys() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	@Override
	public Company createcompany(CompanyForm form) {
		// TODO Auto-generated method stub
		Company company=modelMapper.map(form, Company.class);
		service.save(company);
		return company;	}

	
	
	
	
}
