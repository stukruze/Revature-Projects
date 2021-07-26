package com.stuartkruze.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="first_name", nullable = false)
	private String firstName;
	@Column(name="last_name", nullable = false)
	private String lastName;
	@Column(name="t_reimbur", nullable = false)
	private double tReimbur;
	@Column(name="l_reimbur")
	private long lReimbur;
	@Column(name="password", nullable = false)
	private String password;
	@Column(name="email")
	private String email;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="contact_id")
	private Contact contactId;
	
	@OneToOne
	@JoinColumn(name="managment_id")
	private Management managmentId;

	public Employee() {
		super();
	}



	public Employee(String firstName, String lastName, double tReimbur, long lReimbur, String password, String email,
			Contact contactId, Management managmentId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.tReimbur = tReimbur;
		this.lReimbur = lReimbur;
		this.password = password;
		this.email = email;
		this.contactId = contactId;
		this.managmentId = managmentId;
	}



	public Employee(int id, String firstName, String lastName, double tReimbur, long lReimbur, String password,
			String email, Contact contactId, Management managmentId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tReimbur = tReimbur;
		this.lReimbur = lReimbur;
		this.password = password;
		this.email = email;
		this.contactId = contactId;
		this.managmentId = managmentId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double gettReimbur() {
		return tReimbur;
	}

	public void settReimbur(double tReimbur) {
		this.tReimbur = tReimbur;
	}

	public Contact getContactId() {
		return contactId;
	}

	public void setContactId(Contact contactId) {
		this.contactId = contactId;
	}
	
	public Management getManagmentId() {
		return managmentId;
	}


	public void setManagmentId(Management managmentId) {
		this.managmentId = managmentId;
	}
	
	public long getlReimbur() {
		return lReimbur;
	}

	public void setlReimbur(long lReimbur) {
		this.lReimbur = lReimbur;
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", tReimbur=" + tReimbur
				+ ", lReimbur=" + lReimbur + ", password=" + password + ", email=" + email + ", contactId=" + contactId
				+ ", managmentId=" + managmentId + "]";
	}



	


	
	
}
