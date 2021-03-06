package com.stuartkruze.controllers;

import java.util.List;


import com.google.gson.Gson;
import com.stuartkruze.models.Event;
import com.stuartkruze.services.EventService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EventController {

	Gson gson = new Gson();
	EventService es;

	public EventController(EventService es) {
		this.es = es;
	}

	public Handler getEventById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Event ev = es.getEvent(id);

		populateResult(context, ev);
	};

	public Handler addEvent = (context) -> {

		Event ev = gson.fromJson(context.body(), Event.class);

		ev = es.addEvent(ev);

		populateResult(context, ev);
	};
	
	

	public Handler getAllEvents = (context) -> {


			List<Event> events = es.getAllEvents();
			if (events != null) {
				context.result(gson.toJson(events));
			} else {
				context.result("[]");
			}

		
	};

	public Handler updateEvent = (context) -> {
		Event ev = gson.fromJson(context.body(), Event.class);
		ev.setId(Integer.parseInt(context.pathParam("id")));

		ev = es.updateEvent(ev);

		populateResult(context, ev);
	};

	public Handler deleteEvent = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Event ev = es.deleteEvent(id);

		populateResult(context, ev);
	};


	private void populateResult(Context context, Event ev) {
		if (ev != null) {
			context.result(gson.toJson(ev));
		} else {
			context.result("{}");
		}
	}
	
}
