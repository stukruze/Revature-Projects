package com.stuartkruze.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.stuartkruze.models.Client;
import com.stuartkruze.util.FakeDB;

public class ClientRepoImpl implements ClientRepo {

	@Override
	public Client getClient(int id) {
		
		return FakeDB.clients.get(id);
	}

	@Override
	public List<Client> getAllClients() {
		List<Client> clientList = new ArrayList<Client>();
		Set<Integer> keys = FakeDB.clients.keySet();
//		for(Integer key : keys) {
//			movieList.add(FakeDB.movies.get(key));
//		}
		keys.forEach(key -> clientList.add(FakeDB.clients.get(key)));
		
		return clientList;
	}

	@Override
	public Client addClient(Client c) {
		
		c.setId(FakeDB.idCount++);
		
		FakeDB.clients.put(c.getId(), c);
		
		return c;
	}

	@Override
	public Client updateClient(Client change) {
		FakeDB.clients.replace(change.getId(), change);
		return change;
	}

	@Override
	public Client deleteClient(int id) {
		return FakeDB.clients.remove(id);
		
	}

}
