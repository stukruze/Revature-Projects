package com.stuartkruze.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Grading")
public class Grading {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="grade")
	private String grade;
	@Column(name="presentation_url")
	private String presentationURL;
	@Column(name="cutoffdate")
	private String cutoffdate;
	@Column(name="urgent", nullable = false)
	private boolean urgent;
	@Column(name="approval_skip", nullable = false)
	private boolean approvalSkip;
	
	public Grading() {
		super();
	}

	public Grading(int id, String grade, String presentationURL, String cutoffdate, boolean urgent,
			boolean approvalSkip) {
		super();
		this.id = id;
		this.grade = grade;
		this.presentationURL = presentationURL;
		this.cutoffdate = cutoffdate;
		this.urgent = urgent;
		this.approvalSkip = approvalSkip;
	}

	public Grading(String grade, String presentationURL, String cutoffdate, boolean urgent, boolean approvalSkip) {
		super();
		this.grade = grade;
		this.presentationURL = presentationURL;
		this.cutoffdate = cutoffdate;
		this.urgent = urgent;
		this.approvalSkip = approvalSkip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPresentationURL() {
		return presentationURL;
	}

	public void setPresentationURL(String presentationURL) {
		this.presentationURL = presentationURL;
	}

	public String getCutoffdate() {
		return cutoffdate;
	}

	public void setCutoffdate(String cutoffdate) {
		this.cutoffdate = cutoffdate;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	public boolean isApprovalSkip() {
		return approvalSkip;
	}

	public void setApprovalSkip(boolean approvalSkip) {
		this.approvalSkip = approvalSkip;
	}

	@Override
	public String toString() {
		return "Grading [id=" + id + ", grade=" + grade + ", presentationURL=" + presentationURL + ", cutoffdate="
				+ cutoffdate + ", urgent=" + urgent + ", approvalSkip=" + approvalSkip + "]";
	}
	

	
	

}
