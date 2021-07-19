package com.stuartkruze.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.stuartkruze.models.Management;
import com.stuartkruze.services.ManagementService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ManagementController {

	
	Gson gson = new Gson();
	ManagementService ms;

	public ManagementController(ManagementService ms) {
		this.ms = ms;
	}

	public Handler getManagementById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Management m = ms.getManagement(id);

		populateResult(context, m);
	};

	public Handler addManagement = (context) -> {

		Management m = gson.fromJson(context.body(), Management.class);

		m = ms.addManagement(m);

		populateResult(context, m);
	};

	public Handler getAllManagements = (context) -> {

		String fname = context.queryParam("fname");
		String lname = context.queryParam("lname");

		if (fname == "" && lname == "") {

			List<Management> managements = ms.getAllManagements();
			if (managements != null) {
				context.result(gson.toJson(managements));
			} else {
				context.result("[]");
			}

		} else {
			getManagementByName(context);
		}
	};

	public Handler updateActor = (context) -> {
		Management m = gson.fromJson(context.body(), Management.class);
		m.setId(Integer.parseInt(context.pathParam("id")));

		m = ms.updateManagement(m);

		populateResult(context, m);
	};

	public Handler deleteManagement = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Management m = ms.deleteManagement(id);

		populateResult(context, m);
	};

	private void getManagementByName(Context context) {

		String fname = context.queryParam("fname");
		String lname = context.queryParam("lname");
		System.out.println(fname + " " + lname);

		Management m = ms.getManagementByName(fname, lname);

		populateResult(context, m);
	};

	private void populateResult(Context context, Management m) {
		if (m != null) {
			context.result(gson.toJson(m));
		} else {
			context.result("{}");
		}
	}
}
