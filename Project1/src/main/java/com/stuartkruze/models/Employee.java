package com.stuartkruze.models;

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
	
	@OneToOne
	@JoinColumn(name="contact_id")
	private Contact contactId;

	public Employee() {
		super();
	}

	public Employee(int id, String firstName, String lastName, double tReimbur, Contact contactId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tReimbur = tReimbur;
		this.contactId = contactId;
	}

	public Employee(String firstName, String lastName, double tReimbur, Contact contactId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.tReimbur = tReimbur;
		this.contactId = contactId;
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", tReimbur=" + tReimbur
				+ ", contactId=" + contactId + "]";
	}
	


	
	
}
