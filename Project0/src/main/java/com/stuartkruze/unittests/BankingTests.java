package com.stuartkruze.unittests;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.stuartkruze.app.AppDB;
import com.stuartkruze.controllers.AccountController;
import com.stuartkruze.controllers.ClientController;
import com.stuartkruze.models.Account;
import com.stuartkruze.models.Client;
import com.stuartkruze.repositories.AccountRepo;
import com.stuartkruze.repositories.AccountRepoDBImpl;
import com.stuartkruze.repositories.ClientRepo;
import com.stuartkruze.repositories.ClientRepoDBImpl;
import com.stuartkruze.services.AccountService;
import com.stuartkruze.services.AccountServiceImpl;
import com.stuartkruze.services.ClientService;
import com.stuartkruze.services.ClientServiceImpl;

public class BankingTests {

	static AppDB app;
	
	ClientRepo cr = new ClientRepoDBImpl();
	ClientService cs = new ClientServiceImpl(cr);
	ClientController cc = new ClientController(cs);
	
	AccountRepo ar = new AccountRepoDBImpl();
	AccountService as = new AccountServiceImpl(ar);
	AccountController ac = new AccountController(as);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
			System.out.println("Setting up before each test");
		app = new AppDB();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		System.out.println("Tearing things down");
		app = null;
	}
	
	@Before
	public void setUp() throws Exception{
		System.out.println("This runs before every test");
	}
	
	@After
	public void tearDown() {
		System.out.println("This runs after every test");
	}
	
	
	@Test
	public void positiveGetClientId() {
		
		Client result = cs.getClient(1);
		assertEquals("Getting Client 1 id", 1, result.getId());
	}
	
	@Test
	public void negativeGetClientId() {
		Client result = cs.getClient(1);
		assertNotEquals("Getting Client 222 id", 222, result.getId());
	}
	
	@Test
	public void positiveGetClientFN() {
		
		Client result = cs.getClient(1);
		assertEquals("Getting Client 1 first name", "Stuart", result.getFirstName());
	}
	
	@Test
	public void negativeGetClientFN() {
		Client result = cs.getClient(1);
		assertNotEquals("Getting Client 1", "Fred", result.getFirstName());
	}
	
	@Test
	public void positiveGetClientAdd() {
		
		Client result = cs.getClient(1);
		assertEquals("Getting Client 1 Address1", "639 Newark Ave.", result.getAddress1());
	}
	
	@Test
	public void negativeGetClientAdd() {
		Client result = cs.getClient(1);
		assertNotEquals("Getting Client 1 Address1", "729 Newark Ave.", result.getAddress1());
	}
	
	@Test
	public void positiveGetClientAdd2() {
		
		Client result = cs.getClient(1);
		assertEquals("Getting Client 1 Address2", "Apt. 3L", result.getAddress2());
	}
	
	@Test
	public void negativeGetClientAdd2() {
		Client result = cs.getClient(1);
		assertNotEquals("Getting Client 1 Address2", "Apt 1", result.getAddress2());
	}
	
	@Test
	public void positiveGetClientCity() {
		
		Client result = cs.getClient(1);
		assertEquals("Getting Client 1 City", "Jersey City", result.getCity());
	}
	
	@Test
	public void negativeGetClientCity() {
		Client result = cs.getClient(1);
		assertNotEquals("Getting Client 1 City", "Newark", result.getCity());
	}
	
	@Test
	public void positiveGetClientState() {
		
		Client result = cs.getClient(1);
		assertEquals("Getting Client 1 State", "NJ", result.getState());
	}
	
	@Test
	public void negativeGetClientState() {
		Client result = cs.getClient(1);
		assertNotEquals("Getting Client 1 State", "NY", result.getState());
	}
	
	@Test
	public void positiveGetClientZip() {
		
		Client result = cs.getClient(1);
		assertEquals("Getting Client 1 Zip", "07306", result.getZip());
	}
	
	@Test
	public void negativeGetClientZip() {
		Client result = cs.getClient(1);
		assertNotEquals("Getting Client 1 Zip", "00000", result.getZip());
	}	
	
	@Test
	public void positiveGetAccountId() {
		
		Account result = as.getAccountById(1,1);
		assertEquals("Getting Client 1 Account 1 Id", 1, result.getId());
	}
	
	@Test
	public void negativeGetAccountId() {
		Account result = as.getAccountById(1,1);
		assertNotEquals("Getting Client 1 Account 1 Id", 22, result.getId());
	}	
	
	@Test
	public void positiveGetAccountType() {
		Account result = as.getAccountById(1,1);
		assertEquals("Getting Client 1 Account 1 Type", "checking", result.getType());
	}	
	
	@Test
	public void negativeGetAccountType() {
		Account result = as.getAccountById(1,1);
		assertNotEquals("Getting Client 1 Account 1 Type", "savings", result.getType());
	}	
}
