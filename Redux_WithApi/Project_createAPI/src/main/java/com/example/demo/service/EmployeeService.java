package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.form.EmployeeForm;
import com.example.demo.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired 
	private IEmployeeRepository service;
	
	@Autowired  ModelMapper modelMapper;
	
	@Override
	public Employee getEmployeeByID(int id) {
		// TODO Auto-generated method stub
		return service.findById(id).get();
	}

	@Override
	public void updateEmployeeByID(EmployeeForm form) {
		// TODO Auto-generated method stub
		Employee em=modelMapper.map(form, Employee.class);
		service.save(em);
	}

	@Override
	public void deleteEmployeeByID(int id) {
		// TODO Auto-generated method stub
		service.deleteById(id);

	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	@Override
	public Employee createEmployee(EmployeeForm form) {
		// TODO Auto-generated method stub
		Employee em=modelMapper.map(form, Employee.class);
		service.save(em);
		return em;	}

}
