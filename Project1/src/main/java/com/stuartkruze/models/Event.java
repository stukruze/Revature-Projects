package com.stuartkruze.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="type", nullable = false)
	private String type;
	@Column(name="date_of_start", nullable = false)
	private long dateOfStart;
	@Column(name="pending_reimbersment", nullable = false)
	private double pendingReimbersment;
	@Column(name="location", nullable = false)
	private String location;
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="grading_id")
	private Grading gradingId;

	public Event() {
		super();
	}

	public Event(int id, String type, long dateOfStart, double pendingReimbersment, String location,
			String description, Grading gradingId) {
		super();
		this.id = id;
		this.type = type;
		this.dateOfStart = dateOfStart;
		this.pendingReimbersment = pendingReimbersment;
		this.location = location;
		this.description = description;
		this.gradingId = gradingId;
	}

	public Event(String type, long dateOfStart, double pendingReimbersment, String location, String description,
			Grading gradingId) {
		super();
		this.type = type;
		this.dateOfStart = dateOfStart;
		this.pendingReimbersment = pendingReimbersment;
		this.location = location;
		this.description = description;
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

	public long getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(long dateOfStart) {
		this.dateOfStart = dateOfStart;
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

	public Grading getGradingId() {
		return gradingId;
	}

	public void setGradingId(Grading gradingId) {
		this.gradingId = gradingId;
	}

	@Override
	public String toString() {
		return "Events [id=" + id + ", type=" + type + ", dateOfStart=" + dateOfStart + ", pendingReimbersment="
				+ pendingReimbersment + ", location=" + location + ", description=" + description + ", gradingId="
				+ gradingId + "]";
	}

	
	
	
}
