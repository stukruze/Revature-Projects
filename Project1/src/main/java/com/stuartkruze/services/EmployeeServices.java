package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Employee;

public interface EmployeeServices {

	public Employee addEmployee(Employee em);
	public List<Employee> getAllEmployees();
	public Employee getEmployee(int id);
	public Employee getEmployeeByName(String fname, String lname);
	public Employee updateEmployee(Employee change);
	public Employee deleteEmployee(int id);
}
