package com.stuartkruze.repositories;

import java.util.List;

import com.stuartkruze.models.Client;

public interface ClientRepo {

	public Client getClient(int id);
	
	public List<Client> getAllClients();
	
	public Client addClient(Client c);
	
	public Client updateClient(Client change, int id);
	
	public Client deleteClient(int id);
	
}
