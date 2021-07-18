package com.stuartkruze.models;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Managment")
public class Management {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="position", nullable = false)
	private String position;
	@Column(name="first_name", nullable = false)
	private String firstName;
	@Column(name="last_name", nullable = false)
	private String lastName;
	@Column(name="is_dept_head", nullable = false)
	private boolean isDeptHead;
	
	public Management() {
		super();
	}

	public Management(int id, String position, String firstName, String lastName, boolean isDeptHead) {
		super();
		this.id = id;
		this.position = position;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isDeptHead = isDeptHead;
	}

	public Management(String position, String firstName, String lastName, boolean isDeptHead) {
		super();
		this.position = position;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isDeptHead = isDeptHead;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	public boolean isDeptHead() {
		return isDeptHead;
	}

	public void setDeptHead(boolean isDeptHead) {
		this.isDeptHead = isDeptHead;
	}

	@Override
	public String toString() {
		return "Managment [id=" + id + ", position=" + position + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", isDeptHead=" + isDeptHead + "]";
	}
	


	
	
}
