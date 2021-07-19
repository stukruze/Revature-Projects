package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Contact;

public interface ContactService {

	public Contact addContact(Contact c);
	public List<Contact> getAllContacts();
	public Contact getContact(int id);
	public Contact updateContact(Contact change);
	public Contact deleteContact(int id);
}
