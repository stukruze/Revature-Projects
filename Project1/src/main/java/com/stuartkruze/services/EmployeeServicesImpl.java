package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Employee;
import com.stuartkruze.repositories.EmployeeRepo;

public class EmployeeServicesImpl implements EmployeeServices {
	
	public EmployeeRepo er;

	public EmployeeServicesImpl(EmployeeRepo er) {
		this.er = er;
	}

	@Override
	public Employee addEmployee(Employee em) {
		return er.addEmployee(em);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return er.getAllEmployees();
	}

	@Override
	public Employee getEmployee(int id) {
		return er.getEmployee(id);
	}

	@Override
	public Employee updateEmployee(Employee change) {
		return er.updateEmployee(change);
	}

	@Override
	public Employee deleteEmployee(int id) {
		return er.deleteEmployee(id);
	}

	@Override
	public Employee getEmployeeByName(String fname, String lname) {
		return er.getEmployeeByName(fname, lname);
	}

}
