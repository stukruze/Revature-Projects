package com.stuartkruze.junit;




import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.eclipse.jetty.io.ssl.ALPNProcessor.Client;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.stuartkruze.app.App;

import com.stuartkruze.controllers.ContactController;
import com.stuartkruze.controllers.EmployeeController;
import com.stuartkruze.controllers.EventController;
import com.stuartkruze.controllers.GradingController;
import com.stuartkruze.controllers.ManagementController;
import com.stuartkruze.controllers.TrainingController;
import com.stuartkruze.models.Contact;
import com.stuartkruze.repositories.ContactRepo;
import com.stuartkruze.repositories.ContactRepoImpl;
import com.stuartkruze.repositories.EmployeeRepo;
import com.stuartkruze.repositories.EmployeeRepoImpl;
import com.stuartkruze.repositories.EventRepo;
import com.stuartkruze.repositories.EventRepoImpl;
import com.stuartkruze.repositories.GradingRepo;
import com.stuartkruze.repositories.GradingRepoImpl;
import com.stuartkruze.repositories.ManagementRepo;
import com.stuartkruze.repositories.ManagementRepoImpl;
import com.stuartkruze.repositories.TrainingRepo;
import com.stuartkruze.repositories.TrainingRepoImpl;
import com.stuartkruze.services.ContactServiceImpl;
import com.stuartkruze.services.EmployeeServiceImpl;
import com.stuartkruze.services.EventServiceImpl;
import com.stuartkruze.services.GradingServiceImpl;
import com.stuartkruze.services.ManagementServiceImpl;
import com.stuartkruze.services.TrainingServiceImpl;

public class junitTest {

	static App app;
	
	ContactRepo cr = new ContactRepoImpl();
	ContactServiceImpl cs = new ContactServiceImpl(cr);
	ContactController cc = new ContactController(cs);

	EmployeeRepo emr = new EmployeeRepoImpl();
	EmployeeServiceImpl ems = new EmployeeServiceImpl(emr);
	EmployeeController emc = new EmployeeController(ems);

	EventRepo evr = new EventRepoImpl();
	EventServiceImpl evs = new EventServiceImpl(evr);
	EventController evc = new EventController(evs);

	GradingRepo gr = new GradingRepoImpl();
	GradingServiceImpl gs = new GradingServiceImpl(gr);
	GradingController gc = new GradingController(gs);

	ManagementRepo mr = new ManagementRepoImpl();
	ManagementServiceImpl ms = new ManagementServiceImpl(mr);
	ManagementController mc = new ManagementController(ms);

	TrainingRepo tr = new TrainingRepoImpl();
	TrainingServiceImpl ts = new TrainingServiceImpl(tr, emr);
	TrainingController tc = new TrainingController(ts);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
			System.out.println("Setting up before each test");
		app = new App();
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
	public void nullAddContact() {
		Contact cm1 = new Contact("639 Newark Ave.", "Apt. 3L", "Jersey City", "NJ", "07306", "908-566-7322");
		Contact result = cr.addContact(cm1);
		assertNotNull(result);
	}
	
	@Test
	public void nullGetAllContacts() {
		List<Contact> result = cr.getAllContacts();
		assertNotNull(result);
	}
	
	@Test
	public void nullGetContact() {
		Contact result = cr.getContact(1);
		assertNotNull(result);
	}
	
	@Test
	public void updateContact() {
		Contact cm1 = new Contact(1,"update", "Apt. 3L", "Jersey City", "NJ", "07306", "908-566-7322");
		Contact result = cr.updateContact(cm1);
		assertNotNull(result);
	}
	
	@Test
	public void deleteContact() {
		Contact result = cr.deleteContact(2);
		assertNotNull(result);
	}
	

}
