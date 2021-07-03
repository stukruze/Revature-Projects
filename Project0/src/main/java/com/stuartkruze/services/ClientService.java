package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Client;

public interface ClientService {

	public Client getClient(int id);

	public List<Client> getAllClients();

	public Client addClient(Client c);

	public Client updateClient(Client change);

	public Client deleteClient(int id);

}
