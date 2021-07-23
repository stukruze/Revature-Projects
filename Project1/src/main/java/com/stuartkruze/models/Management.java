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
	@Column(name="is_dept_head", nullable = false)
	private boolean isDeptHead;
	
	public Management() {
		super();
	}

	public Management(int id, String position, boolean isDeptHead) {
		super();
		this.id = id;
		this.position = position;
		this.isDeptHead = isDeptHead;
	}

	public Management(String position, boolean isDeptHead) {
		super();
		this.position = position;
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

	public boolean isDeptHead() {
		return isDeptHead;
	}

	public void setDeptHead(boolean isDeptHead) {
		this.isDeptHead = isDeptHead;
	}

	@Override
	public String toString() {
		return "Management [id=" + id + ", position=" + position + ", isDeptHead=" + isDeptHead + "]";
	}


	


	
	
}
