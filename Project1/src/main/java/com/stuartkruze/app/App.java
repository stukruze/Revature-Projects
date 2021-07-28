package com.stuartkruze.app;

import java.util.Calendar;

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

import io.javalin.Javalin;

public class App {

	public static void main(String[] args) {

		// Establish our Javalin Object
		Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());

		// Establish the Routes/Endpoints Javalin will manage
		establishRoutes(app);

		// Run Javalin
		app.start(7000);
	}

	private static void establishRoutes(Javalin app) {

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
		TrainingServiceImpl ts = new TrainingServiceImpl(tr);
		TrainingController tc = new TrainingController(ts);

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
		Training tra1 = new Training(false, false, false, false, false, false, false, 0, "", false, "", ev1, mm2, em2);
		tr.addTraining(tra1);
		
		Grading gr3 = new Grading();
		gr.addGrading(gr3);
		Event ev3 = new Event("University Course", "01/21/21", "01/21/21", 300.00, "NJIT","PHP programming", "want it", "none", gr3);
		evr.addEvent(ev3);
		Training tra3 = new Training(false, false, false, false, false, false, false, 0, "", false, "", ev3, mm1, em1);
		tr.addTraining(tra3);
		
		
		app.get("/contacts/:id", cc.getContactById);
		app.get("/contacts", cc.getAllContacts);
		app.post("/contacts", cc.addContact);
		app.put("/contacts/:id", cc.updateContact);
		app.delete("/contacts/:id", cc.deleteContact);
		app.get("/contacts/:email", cc.getContactByEmail);
		
		app.get("/login", emc.login);

		app.get("/employees/:id", emc.getEmployeeById);
		app.get("/employees", emc.getAllEmployees);
		app.post("/employees", emc.addEmployee);
		app.put("/employees/:id", emc.updateEmployee);
		app.delete("/employees/:id", emc.deleteEmployee);
		app.get("/employees2/:contact_id", emc.getEmployeeByContactId);

		app.get("/events/:id", evc.getEventById);
		app.get("/events", evc.getAllEvents);
		app.post("/events", evc.addEvent);
		app.put("/events/:id", evc.updateEvent);
		app.delete("/events/:id", evc.deleteEvent);

		app.get("/gradings/:id", gc.getGradingById);
		app.get("/gradings", gc.getAllGradings);
		app.post("/gradings", gc.addGrading);
		app.put("/gradings/:id", gc.updateGrading);
		app.delete("/gradings/:id", gc.deleteGrading);

		app.get("/managements/:id", mc.getManagementById);
		app.get("/managements", mc.getAllManagements);
		app.post("/managements", mc.addManagement);
		app.put("/managements/:id", mc.updateManagement);
		app.delete("/managements/:id", mc.deleteManagement);

		app.get("/trainings/:id", tc.getTrainingById);
		app.get("/trainings", tc.getAllTrainings);
		app.post("/trainings", tc.addTraining);
		app.put("/trainings/:id", tc.updateTraining);
		app.delete("/trainings/:id", tc.deleteTraining);
		
		app.get("/trainings2/:employee_id", tc.getTrainingsByEmployeeId);

		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		int newyear = 2021;

		if (year > newyear) {
			emr.updateEmployeeTR(1000.00);
			newyear++;
		}

	}
}
