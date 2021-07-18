package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Contact;
import com.stuartkruze.repositories.ContactRepo;

public class ContactServicesImpl implements ContactServices{
	
	public ContactRepo cr;

	public ContactServicesImpl(ContactRepo cr) {
		this.cr = cr;
	}

	@Override
	public Contact addContact(Contact c) {
		return cr.addContact(c);
	}

	@Override
	public List<Contact> getAllContacts() {
		return cr.getAllContacts();
	}

	@Override
	public Contact getContact(int id) {
		return cr.getContact(id);
	}

	@Override
	public Contact updateContact(Contact change) {
		return cr.updateContact(change);
	}

	@Override
	public Contact deleteContact(int id) {
		return cr.deleteContact(id);
	}

}
