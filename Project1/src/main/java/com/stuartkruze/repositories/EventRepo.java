package com.stuartkruze.repositories;

import java.util.List;

import com.stuartkruze.models.Event;

public interface EventRepo {

	public Event addEvent(Event ev);
	public List<Event> getAllEvents();
	public Event getEvent(int id);
	public List<Event> getEventByType(String type);
	public Event updateEvent(Event change);
	public Event deleteEvent(int id);	
}
