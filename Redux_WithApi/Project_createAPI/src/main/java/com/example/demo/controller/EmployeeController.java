package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDTO;
import com.example.demo.form.EmployeeForm;
import com.example.demo.service.IEmployeeService;


@RequestMapping("/api/employee")
@RestController
public class EmployeeController implements WebMvcConfigurer  {
	@Autowired
	private IEmployeeService Service;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "/{id}")
	public EmployeeDTO getEmployeebyID(@PathVariable(name = "id") int id) {
		Employee employee = Service.getEmployeeByID(id);

		EmployeeDTO dto = modelMapper.map(employee, EmployeeDTO.class);
		return dto;
	}
	@PostMapping("/create")
	public EmployeeDTO createEmployee(@RequestBody EmployeeForm form) {
		Employee employee= Service.createEmployee(form);
		EmployeeDTO dto = modelMapper.map(employee, EmployeeDTO.class);
		return dto;
	}

	@PutMapping(value = "/update/{id}")
	public EmployeeDTO updateEmployeeById(@PathVariable(name = "id") int id, @RequestBody EmployeeForm form) {
		form.setIdcom(id);
		Service.updateEmployeeByID(form);
		EmployeeDTO dto = modelMapper.map(form, EmployeeDTO.class);
		return dto;
	}

	@DeleteMapping(value = "/delete/{id}")
	public int deleteEmployeeById(@PathVariable(name = "id") int id) {
		
		if(getEmployeebyID(id)==null) {
			return -1;
		}
		else {
			Service.deleteEmployeeByID(id);
			return id;
		}
		
	}
	
	
}
