package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Event;
import com.stuartkruze.repositories.EventRepo;

public class EventServicesImpl implements EventServices {

	public EventRepo er;

	public EventServicesImpl(EventRepo er) {
		this.er = er;
	}
	
	@Override
	public Event addEvent(Event ev) {
		return er.addEvent(ev);
	}

	@Override
	public List<Event> getAllEvents() {
		return er.getAllEvents();
	}

	@Override
	public Event getEvent(int id) {
		return er.getEvent(id);
	}

	@Override
	public List<Event> getEventByType(String type) {
		return er.getEventByType(type);
	}

	@Override
	public Event updateEvent(Event change) {
		return er.updateEvent(change);
	}

	@Override
	public Event deleteEvent(int id) {
		return er.deleteEvent(id);
	}

}
