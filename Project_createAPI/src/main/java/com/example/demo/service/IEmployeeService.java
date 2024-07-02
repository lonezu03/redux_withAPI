package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.form.EmployeeForm;



public interface IEmployeeService {
	public Employee getEmployeeByID(int id);
	public void updateEmployeeByID(EmployeeForm form);
	public void deleteEmployeeByID(int id);
	public List<Employee> getAllEmployees();
	public Employee createEmployee(EmployeeForm form);
}
