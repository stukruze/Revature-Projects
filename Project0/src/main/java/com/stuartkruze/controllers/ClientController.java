package com.stuartkruze.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.stuartkruze.models.Client;
import com.stuartkruze.services.ClientService;

import io.javalin.http.Handler;


public class ClientController {

	ClientService cs;
	Gson gson = new Gson();

	public ClientController(ClientService cs) {
		this.cs = cs;
	}
	
	public Handler getAllClients = (context) -> {
		List<Client> clients = cs.getAllClients();
		context.result(gson.toJson(clients));
	};
	
	public Handler getClientById = (context) -> {
		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Client c = cs.getClient(id);
		
		if(c != null) {
			context.result(gson.toJson(c));
		} else {
			context.status(400);
		}
		
	};
	
	public Handler addClient = (context) -> {
		Client c = gson.fromJson(context.body(), Client.class);
		
		c = cs.addClient(c);
		context.result((c != null) ? gson.toJson(c) : "{}");
	};
	
	public Handler updateClient = (context) -> {
		Client c = gson.fromJson(context.body(), Client.class);
		
		c = cs.updateClient(c);
		context.result((c != null) ? gson.toJson(c) : "{}");
	};
	
	public Handler deleteClient = (context) -> {
		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		Client c = cs.deleteClient(id);
		
		context.result((c != null) ? gson.toJson(c) : "{}");
	};
	
	
}
