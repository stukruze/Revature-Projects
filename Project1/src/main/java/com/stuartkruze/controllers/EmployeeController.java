package com.stuartkruze.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.stuartkruze.models.Contact;
import com.stuartkruze.models.Employee;
import com.stuartkruze.services.EmployeeService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EmployeeController {

	Gson gson = new Gson();
	EmployeeService es;

	public EmployeeController(EmployeeService es) {
		this.es = es;
	}

	public Handler getEmployeeById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Employee a = es.getEmployee(id);

		populateResult(context, a);
	};
	
	public Handler getEmployeeByContactId = (context) -> {

		String input = context.pathParam("contact_id");
		int contact_id;
		try {
			contact_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			contact_id = -1;
		}
		Employee a = es.getEmployeeByContactId(contact_id);

		populateResult(context, a);
	};

	public Handler addEmployee = (context) -> {

		Employee em = gson.fromJson(context.body(), Employee.class);

		em = es.addEmployee(em);

		populateResult(context, em);
	};

	public Handler getAllEmployees = (context) -> {

		String fname = context.queryParam("fname");
		String lname = context.queryParam("lname");
		
		if (fname == null && lname == null) {

			List<Employee> employees = es.getAllEmployees();
			if (employees != null) {
				context.result(gson.toJson(employees));
			} else {
				context.result("[]");
			}

		} else {
			getEmployeeByName(context);
		}
	};

	public Handler updateEmployee = (context) -> {
		Employee em = gson.fromJson(context.body(), Employee.class);
		em.setId(Integer.parseInt(context.pathParam("id")));

		em = es.updateEmployee(em);

		populateResult(context, em);
	};

	public Handler deleteEmployee = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Employee em = es.deleteEmployee(id);

		populateResult(context, em);
	};

	private void getEmployeeByName(Context context) {

		String fname = context.queryParam("fname");
		String lname = context.queryParam("lname");
		System.out.println(fname + " " + lname);

		Employee a = es.getEmployeeByName(fname, lname);

		populateResult(context, a);
	};
	
	public Handler login = (context) -> {

		String user = context.queryParam("user");
		String pass = context.queryParam("pass");
		System.out.println(user);
		
		List<Employee> employees = es.getAllEmployees();
		
		int temp = 0;
		
		for (int i = 0; i < employees.size(); i++) {
            String u  = employees.get(i).getEmail();
            String p = employees.get(i).getPassword();
            System.out.println(u);
			if (user.equals(u) && pass.equals(p)) {
				temp = i;
			}
		}
		
		Employee em = employees.get(temp);
		populateResult(context, em);

	};

	
	private void populateResult(Context context, Employee em) {
		if (em != null) {
			context.result(gson.toJson(em));
		} else {
			context.result("{}");
		}
	}
	
}
