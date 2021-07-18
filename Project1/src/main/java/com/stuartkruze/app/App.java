package com.stuartkruze.app;



import com.stuartkruze.repositories.ContactRepo;
import com.stuartkruze.repositories.ContactRepoImpl;

import io.javalin.Javalin;

public class App {

	public static void main(String[] args) {
		
		//Establish our Javalin Object
		Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());
		
		//Establish the Routes/Endpoints Javalin will manage
		establishRoutes(app);
		
		//Run Javalin
		app.start(7000);		
	}
	
	private static void establishRoutes(Javalin app) {
		
		ContactRepo ar = new ContactRepoImpl();
		

		ar.getContact(0);
		
		
		
	}
}
