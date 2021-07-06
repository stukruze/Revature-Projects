package com.stuartkruze.util;

import java.util.HashMap;
import java.util.Map;

import com.stuartkruze.models.Account;
import com.stuartkruze.models.Client;

public class FakeDB {

	public static Map<Integer, Client> clients = new HashMap<Integer, Client>();
	public static int idCount = 1;

	public static Map<Integer, Account> accounts = new HashMap<Integer, Account>();
	public static int idCount2 = 1;

	static {
		Client c1 = new Client(1, 1, "Stuart", "Kruze", "639 Newark Ave.", "Apt. 3L", "Jersey City", "New Jersey",
				"07306");

		

		Account a1 = new Account(1, 1, 100.00, "checking");

		accounts.put(idCount2++, a1);
		clients.put(idCount++, c1);

	}
}
