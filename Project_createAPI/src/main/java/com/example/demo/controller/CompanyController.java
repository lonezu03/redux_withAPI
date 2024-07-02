package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.example.demo.entity.Company;
import com.example.demo.entity.CompanyDTO;
import com.example.demo.form.CompanyForm;
import com.example.demo.service.ICompanyService;
import com.example.demo.service.IEmployeeService;

@RestController
@RequestMapping("/api/company")
public class CompanyController implements  WebMvcConfigurer{
	@Override
  public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**")
              .allowedOrigins("http://26.22.243.2:5173","http://localhost:5173") // URL của ứng dụng React
              .allowedMethods("GET", "POST", "PUT", "DELETE")
              .allowedHeaders("*")
              .allowCredentials(true);
	}
	@Autowired
	private ICompanyService service;
	
	@Autowired
	private IEmployeeService serviceEm; 
	
	@Autowired private ModelMapper modelMapper;
	
	@GetMapping
	public List<CompanyDTO> getAllCompany() {
		List<Company> list = service.getAllcompanys();
		List<CompanyDTO> dtos = modelMapper.map(list, new TypeToken<List<CompanyDTO>>() {
		}.getType());
		return dtos;
	}
	
	@GetMapping(value = "/{id}")
	public CompanyDTO getCompanybyID(@PathVariable(name = "id") int id) {
		try {
			Company company = service.getcompanyByID(id);
			CompanyDTO dto = modelMapper.map(company, CompanyDTO.class);
			return dto;
		} catch (Exception e) {
			return null;
		}
		
	}

	@PostMapping("/create")
	public CompanyDTO createCompany(@RequestBody CompanyForm form) {
	    Company department= service.createcompany(form);

		CompanyDTO dto = modelMapper.map(department, CompanyDTO.class);
		return dto;
	}

	@PutMapping(value = "/update/{id}")
	public CompanyDTO updateCompanyById(@PathVariable(name = "id") int id, @RequestBody CompanyForm form) {
		form.setIdcom(id);
		service.updatecompanyByID(form);
		CompanyDTO dto = modelMapper.map(form, CompanyDTO.class);
		return dto;
	}
	@DeleteMapping(value = "/delete/{id}")
	public int deleteCompanyById(@PathVariable(name = "id") int id) {
			if(getCompanybyID(id)==null)
				return -1;
			else {
				service.deletecompanyByID(id);
				return id;
			}
	}
}
