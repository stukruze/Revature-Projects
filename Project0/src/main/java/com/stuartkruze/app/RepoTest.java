package com.stuartkruze.app;

import java.util.List;

import com.stuartkruze.models.Client;
import com.stuartkruze.repositories.ClientRepo;
import com.stuartkruze.repositories.ClientRepoImpl;

public class RepoTest {

	public static void main(String[] args) {
		

		ClientRepo cr = new ClientRepoImpl();
		
		List<Client> clients = cr.getAllClients();
		System.out.println(clients);
		
		System.out.println(cr.getClient(1));
		
		Client c = new Client(2, 1, "Arme", "Kruze", "236 Warren Street", "", "Newark", "New Jersey", "07103");
		
		c = cr.addClient(c);
		System.out.println("====ADD CLIENT====");
		System.out.println(c);
		System.out.println(cr.getAllClients());
		

		c.setId(3);
		c = cr.updateClient(c, 3);
		System.out.println("===UPDATE CLIENT===");
		System.out.println(c);
		System.out.println(cr.getClient(c.getId()));
		
		cr.deleteClient(c.getId());
		System.out.println("===DELETE MOVIE===");
		System.out.println(cr.getAllClients());
	}

}
