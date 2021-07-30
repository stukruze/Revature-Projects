package com.stuartkruze.junit;




import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
import com.stuartkruze.models.Employee;
import com.stuartkruze.models.Event;
import com.stuartkruze.models.Grading;
import com.stuartkruze.models.Management;
import com.stuartkruze.models.Training;
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
	
	static ContactRepo cr = new ContactRepoImpl();
	ContactServiceImpl cs = new ContactServiceImpl(cr);
	ContactController cc = new ContactController(cs);

	static EmployeeRepo emr = new EmployeeRepoImpl();
	EmployeeServiceImpl ems = new EmployeeServiceImpl(emr);
	EmployeeController emc = new EmployeeController(ems);

	static EventRepo evr = new EventRepoImpl();
	EventServiceImpl evs = new EventServiceImpl(evr);
	EventController evc = new EventController(evs);

	static GradingRepo gr = new GradingRepoImpl();
	GradingServiceImpl gs = new GradingServiceImpl(gr);
	GradingController gc = new GradingController(gs);

	static ManagementRepo mr = new ManagementRepoImpl();
	ManagementServiceImpl ms = new ManagementServiceImpl(mr);
	ManagementController mc = new ManagementController(ms);

	static TrainingRepo tr = new TrainingRepoImpl();
	TrainingServiceImpl ts = new TrainingServiceImpl(tr, emr);
	TrainingController tc = new TrainingController(ts);
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
			System.out.println("Setting up before each test");
		app = new App();
		Contact cm1 = new Contact("639 Newark Ave.", "Apt. 3L", "Jersey City", "NJ", "07306", "908-566-7322");
		cr.addContact(cm1);
		Employee em1 = new Employee("Stuart", "Kruze", 1000.00, 0, "pass", "audiolaboratory@hotmail.com", cm1, null);
		emr.addEmployee(em1);

		Contact cm2 = new Contact("1220 Arrowood Drive", "", "Jacksonville", "FL", "32216","904-521-8177");
		cr.addContact(cm2);
		Employee em2 = new Employee("Karen", "Rowley", 1000.00, 0, "pass", "KarenERowley@rhyta.com", cm2, null);
		emr.addEmployee(em2);

		Contact cm3 = new Contact("4656 Lyon Avenue", "", "Hyannis", "MA", "02601","508-957-7850");
		cr.addContact(cm3);
		Employee em3 = new Employee("Jesenia", "Ramsdell", 1000.00,0, "pass",  "JeseniaRRamsdell@teleworm.us", cm3, null);
		emr.addEmployee(em3);

		Contact cm4 = new Contact("4023 Charack Road", "", "Columbus", "IN", "47201", "812-292-9035");
		cr.addContact(cm4);
		Management mm1 = new Management("Direct Supervisor", true);
		mr.addManagement(mm1);
		Employee em4 = new Employee("Daniel", "Belanger", 1000.00,0, "pass", "DanielFBelanger@rhyta.com", cm4, mm1);
		emr.addEmployee(em4);

		Contact cm5 = new Contact("2739 Willow Oaks Lane", "", "New Iberia", "LA", "70560", "337-373-6422");
		cr.addContact(cm5);
		Management mm2 = new Management("Direct Supervisor", false);
		mr.addManagement(mm2);
		Employee em5 = new Employee("John", "Garcia", 1000.00,0, "pass", "JohnAGarcia@jourrapide.com", cm5, mm2);
		emr.addEmployee(em5);

		Contact cm6 = new Contact("4623 Clair Street", "", "Waco", "TX", "76710","254-751-7274");
		cr.addContact(cm6);
		Contact cm7 = new Contact("4623 Clair Street", "", "Waco", "TX", "76710", "254-751-7274");
		cr.addContact(cm7);
		Management mm3 = new Management("Benefits Coordinator", false);
		mr.addManagement(mm3);
		Employee em6 = new Employee("Marilyn", "Shelton", 1000.00,0, "pass", "MarilynBShelton@rhyta.com", cm6, mm3);
		emr.addEmployee(em6);
		Contact cm8 = new Contact("4623 Clair Street", "", "Waco", "TX", "76710", "254-751-7274");
		cr.addContact(cm8);
		Management mm4 = new Management("Benefits Coordinator", false);
		mr.addManagement(mm4);
		Employee em7 = new Employee("test", "test", 1000.00,0, "pass",  "MarilynBShelton@rhyta.com", cm8, mm3);
		emr.addEmployee(em7);
		
		
		Grading gr1 = new Grading();
		gr.addGrading(gr1);
		Event ev1 = new Event("University Course", "01/21/21", "01/21/21", 300.00, "Rutgers University","cloud computing", "need it", "none", gr1);
		evr.addEvent(ev1);
		Training tra1 = new Training("", false, false, false, false, false, false, 0, "", false, "", false, 0, 0, 0, ev1, mm2, em2);
		tr.addTraining(tra1);
		
		Grading gr3 = new Grading();
		gr.addGrading(gr3);
		Event ev3 = new Event("University Course", "01/21/21", "01/21/21", 300.00, "NJIT","PHP programming", "want it", "none", gr3);
		evr.addEvent(ev3);
		Training tra3 = new Training("", false, false, false, false, false, false, 0, "", false, "", false, 0, 0, 0, ev3, mm1, em3);
		tr.addTraining(tra3);
		
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
		Contact result = cr.getContact(3);
		assertNotNull(result);
	}
	
	@Test
	public void updateContact() {
		
		Contact cm1 = new Contact(1, "4656 Lyon Avenu", "", "Hyannis", "MA", "02601","508-957-7850");
		Contact result = cr.updateContact(cm1);
		assertNotNull(result);
	}

	
	@Test
	public void nullAddEmployee() {
		
		Employee e1 = new Employee(8,"Stu2", "Kruze", 1000, 0, "audiolaboaratory@hotmail.com", "pass", null, null);
		Employee result = emr.addEmployee(e1);
		assertNotNull(result);
	}
	
	@Test
	public void nullGetAllEmployees() {
		List<Employee> result = emr.getAllEmployees();
		assertNotNull(result);
	}
	
	@Test
	public void nullGetEmployee() {
		Employee result = emr.getEmployee(2);
		assertNotNull(result);
	}
	
	@Test
	public void updateEmployee() {
		
		Employee e1 = new Employee(8,"Stu3", "Kruze", 1000, 0, "audiolaboaratory@hotmail.com", "pass", null, null);
		Employee result = emr.updateEmployee(e1);
		assertNotNull(result);
	}
	
	@Test
	public void deleteEmployee() {
		Employee result = emr.deleteEmployee(1);
		assertNotNull(result);
	}

	@Test
	public void nullAddEvent() {
		Event e1 = new Event(8,"University Course", "01/21/21", "01/21/21", 300, "NJIT", "Cloud Computing", "want it", "2 weeks", null);
		Event result = evr.addEvent(e1);
		assertNotNull(result);
	}
	
	@Test
	public void nullGetAllEvents() {
		List<Event> result = evr.getAllEvents();
		assertNotNull(result);
	}
	
	@Test
	public void nullGetEvent() {
		Event result = evr.getEvent(1);
		assertNotNull(result);
	}
	
	@Test
	public void updateEvent() {
		
		Event e1 = new Event(1,"University Course", "01/21/21", "01/21/21", 300, "Rutgers", "Cloud Computing", "want it", "2 weeks", null);
		Event result = evr.updateEvent(e1);
		assertNotNull(result);
	}
	
	
	@Test
	public void nullAddGrading() {
		Grading e1 = new Grading(1,"A", "www.something.com", "01/21/21", false, false);
		Grading result = gr.addGrading(e1);
		assertNotNull(result);
	}
	
	@Test
	public void nullGetAllGradings() {
		List<Grading> result = gr.getAllGradings();
		assertNotNull(result);
	}
	
	@Test
	public void nullGetGrading() {
		Grading result = gr.getGrading(1);
		assertNotNull(result);
	}
	
	@Test
	public void updateGrading() {
		
		Grading e1 = new Grading(1,"A", "www.something.com", "01/21/21", false, false);
		Grading result = gr.updateGrading(e1);
		assertNotNull(result);
	}
	
//	@Test
//	public void deleteGrading() {
//		Grading result = gr.deleteGrading(2);
//		assertNotNull(result);
//	}
	
	@Test
	public void nullAddManagement() {
		Management e1 = new Management(1,"Direct Supervisor", false);
		Management result = mr.addManagement(e1);
		assertNotNull(result);
	}
	
	@Test
	public void nullGetAllManagements() {
		List<Management> result = mr.getAllManagements();
		assertNotNull(result);
	}
	
	@Test
	public void nullGetManagement() {
		Management result = mr.getManagement(1);
		assertNotNull(result);
	}
	
	@Test
	public void updateManagement() {
		
		Management e1 = new Management(1,"Benifits Coordinatior", false);
		Management result = mr.updateManagement(e1);
		assertNotNull(result);
	}
	
//	@Test
//	public void deleteManagement() {
//		Management result = mr.deleteManagement(3);
//		assertNotNull(result);
//	}
	
	@Test
	public void nullAddTraining() {
		Training e1 = new Training(1,"A", false,false,false,false,false,false,300,"not",false,"info",false,80,0,0,null,null,null);
		Training result = tr.addTraining(e1);
		assertNotNull(result);
	}
	
	@Test
	public void nullGetAllTrainings() {
		List<Management> result = mr.getAllManagements();
		assertNotNull(result);
	}
	
	@Test
	public void nullGetTraining() {
		Training result = tr.getTraining(1);
		assertNotNull(result);
	}
	
	@Test
	public void updateTraining() {
		
		Training e1 = new Training(1,"A", true,false,false,false,false,false,300,"not",false,"info",false,80,0,0,null,null,null);
		Training result = tr.updateTraining(e1);
		assertNotNull(result);
	}
	
	@Test
	public void deleteTraining() {
		Training result = tr.deleteTraining(2);
		assertNotNull(result);
	}
	
	
	@Test
	public void nullcomputeT() {
		Training result = ts.computeT(1);
		assertNotNull(result);
	}
	
	
	
}
