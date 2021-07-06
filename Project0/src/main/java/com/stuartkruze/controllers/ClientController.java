package com.stuartkruze.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import com.google.gson.Gson;
import com.stuartkruze.models.Client;
import com.stuartkruze.services.ClientService;

import io.javalin.http.Handler;

public class ClientController {

	ClientService cs;
	Gson gson = new Gson();
	final static Logger log = Logger.getLogger(ClientController.class);

	public ClientController(ClientService cs) {
		this.cs = cs;
	}

	public Handler getAllClients = (context) -> {
		List<Client> clients = cs.getAllClients();
		context.result(gson.toJson(clients));
		log.info("All Clients Checked");
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

		if (c != null) {
			context.result(gson.toJson(c));
		} else {
			context.status(404);
		}

	};

	public Handler addClient = (context) -> {
		Client c = gson.fromJson(context.body(), Client.class);

		c = cs.addClient(c);
		if (c != null) {
			context.result((c != null) ? gson.toJson(c) : "{}");
			context.status(201);
			log.info("Client Created");
		} else {
			context.status(500);
			log.error("something went wrong creating a client");
		}
	};

	public Handler updateClient = (context) -> {
		
		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}

		
		Client c = gson.fromJson(context.body(), Client.class);
		
		c = cs.updateClient(c, id);
		
		if (c != null) {
			context.result((c != null) ? gson.toJson(c) : "{}");
			context.status(201);
			log.info("Update Made to client " + id);
		} else {
			context.status(404);
			log.error("something went wrong updating a client");
		}
		
		
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
