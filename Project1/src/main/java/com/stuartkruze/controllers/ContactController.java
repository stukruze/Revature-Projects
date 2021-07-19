package com.stuartkruze.controllers;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.stuartkruze.models.Contact;
import com.stuartkruze.services.ContactService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ContactController {

	ContactService cs;
	Gson gson = new Gson();

	final static Logger log = Logger.getLogger(ContactController.class);

	public ContactController(ContactService cs) {
		this.cs = cs;
	}

	public Handler getContactById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Contact c = cs.getContact(id);

		populateResult(context, c);
	};

	public Handler addContact = (context) -> {

		Contact c = gson.fromJson(context.body(), Contact.class);

		c = cs.addContact(c);

		populateResult(context, c);
	};

	public Handler getAllContacts = (context) -> {

		List<Contact> contacts = cs.getAllContacts();
		if (contacts != null) {
			context.result(gson.toJson(contacts));
		} else {
			context.result("[]");
		}

	};

	public Handler updateContact = (context) -> {
		Contact c = gson.fromJson(context.body(), Contact.class);
		c.setId(Integer.parseInt(context.pathParam("id")));

		c = cs.updateContact(c);

		populateResult(context, c);
	};

	public Handler deleteActor = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Contact c = cs.deleteContact(id);

		populateResult(context, c);
	};

	private void populateResult(Context context, Contact c) {
		if (c != null) {
			context.result(gson.toJson(c));
		} else {
			context.result("{}");
		}
	}
}
