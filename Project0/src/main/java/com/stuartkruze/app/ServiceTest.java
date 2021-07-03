package com.stuartkruze.app;


import com.stuartkruze.models.Client;

import com.stuartkruze.repositories.ClientRepo;
import com.stuartkruze.repositories.ClientRepoImpl;
import com.stuartkruze.services.ClientService;
import com.stuartkruze.services.ClientServiceImpl;

public class ServiceTest {

	public static void main(String[] args) {
		ClientRepo cr = new ClientRepoImpl();
		ClientService cs = new ClientServiceImpl(cr);
		
		Client c = cs.getClient(1);
		System.out.println(c);

	}

}
