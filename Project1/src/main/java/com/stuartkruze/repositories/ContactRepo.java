package com.stuartkruze.repositories;

import java.util.List;

import com.stuartkruze.models.Contact;

public interface ContactRepo {

	public Contact addContact(Contact c);
	public List<Contact> getAllContacts();
	public Contact getContact(int id);
	public Contact updateContact(Contact change);
	public Contact deleteContact(int id);	
}
