package com.stuartkruze.app;

import com.stuartkruze.controllers.AccountController;
import com.stuartkruze.controllers.ClientController;
import com.stuartkruze.repositories.AccountRepo;
import com.stuartkruze.repositories.AccountRepoDBImpl;
import com.stuartkruze.repositories.ClientRepo;
import com.stuartkruze.repositories.ClientRepoDBImpl;
import com.stuartkruze.services.AccountService;
import com.stuartkruze.services.AccountServiceImpl;
import com.stuartkruze.services.ClientService;
import com.stuartkruze.services.ClientServiceImpl;

import io.javalin.Javalin;

public class AppDB {

	public static void main(String[] args) {

		Javalin app = Javalin.create();

		establishRoutes(app);

		app.start(7000);
		
	}

	private static void establishRoutes(Javalin app) {
		
		ClientRepo cr = new ClientRepoDBImpl();
		ClientService cs = new ClientServiceImpl(cr);
		ClientController cc = new ClientController(cs);
		
		AccountRepo ar = new AccountRepoDBImpl();
		AccountService as = new AccountServiceImpl(ar);
		AccountController ac = new AccountController(as);

		app.get("/", (context) -> context.result("This is Our Client App Home Page!"));
		app.get("/hello", (context) -> context.result("Hello World!"));
		
		app.get("/clients", cc.getAllClients);
		app.get("/clients/:id", cc.getClientById);
		
		app.post("/clients", cc.addClient);
		
		app.put("/clients/:id", cc.updateClient);
		
		app.delete("/clients/:id", cc.deleteClient);
		
		
		
		app.get("/accounts", ac.getAllAccounts);
		
		app.get("/clients/:id/accounts", ac.getAllAccountsById);
		
		app.get("/clients/:id/accounts/:id2", ac.getAccountById2);
		
		app.post("/clients/:id/accounts", ac.addAccount);
		
		app.put("/clients/:id/accounts/:id2", ac.updateAccount);
		
		app.delete("/clients/:id/accounts/:id2", ac.deleteAccount);
		
		app.patch("/clients/:id/accounts/:id2", ac.depositWithdraw);
		
		app.patch("/clients/:id/accounts/:id2/transfer/:id3", ac.transfer);
		
		
	}
	
}
