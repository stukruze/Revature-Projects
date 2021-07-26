package com.stuartkruze.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "type")
	private String type;
	@Column(name = "date_of_start")
	private String dateOfStart;
	@Column(name = "date_filed")
	private String datefiled;
	@Column(name = "pending_reimbersment")
	private double pendingReimbersment;
	@Column(name = "location")
	private String location;
	@Column(name = "description")
	private String description;
	@Column(name = "justification")
	private String justification;
	@Column(name = "work_missed")
	private String workMissed;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "grading_id")
	private Grading gradingId;

	public Event() {
		super();
	}

	public Event(int id, String type, String dateOfStart, String datefiled, double pendingReimbersment, String location,
			String description, String justification, String workMissed, Grading gradingId) {
		super();
		this.id = id;
		this.type = type;
		this.dateOfStart = dateOfStart;
		this.datefiled = datefiled;
		this.pendingReimbersment = pendingReimbersment;
		this.location = location;
		this.description = description;
		this.justification = justification;
		this.workMissed = workMissed;
		this.gradingId = gradingId;
	}

	public Event(String type, String dateOfStart, String datefiled, double pendingReimbersment, String location,
			String description, String justification, String workMissed, Grading gradingId) {
		super();
		this.type = type;
		this.dateOfStart = dateOfStart;
		this.datefiled = datefiled;
		this.pendingReimbersment = pendingReimbersment;
		this.location = location;
		this.description = description;
		this.justification = justification;
		this.workMissed = workMissed;
		this.gradingId = gradingId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(String dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public String getDatefiled() {
		return datefiled;
	}

	public void setDatefiled(String datefiled) {
		this.datefiled = datefiled;
	}

	public double getPendingReimbersment() {
		return pendingReimbersment;
	}

	public void setPendingReimbersment(double pendingReimbersment) {
		this.pendingReimbersment = pendingReimbersment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getWorkMissed() {
		return workMissed;
	}

	public void setWorkMissed(String workMissed) {
		this.workMissed = workMissed;
	}

	public Grading getGradingId() {
		return gradingId;
	}

	public void setGradingId(Grading gradingId) {
		this.gradingId = gradingId;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", type=" + type + ", dateOfStart=" + dateOfStart + ", datefiled=" + datefiled
				+ ", pendingReimbersment=" + pendingReimbersment + ", location=" + location + ", description="
				+ description + ", justification=" + justification + ", workMissed=" + workMissed + ", gradingId="
				+ gradingId + "]";
	}



}
