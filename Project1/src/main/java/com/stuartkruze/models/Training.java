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
@Table(name="Traning")
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="grade")
	private String Grade;
	@Column(name="approved_by_DS")
	private boolean approvedByDS;
	@Column(name="approved_by_DH")
	private boolean approvedByDH;
	@Column(name="approved_by_BC")
	private boolean approvedByBC;
	@Column(name="denied_by_DS")
	private boolean deniedByDS;
	@Column(name="denied_by_DH")
	private boolean deniedByDH;
	@Column(name="denied_by_BC")
	private boolean deniedByBC;
	@Column(name="awardedReimbursment")
	private double awardedReimbursment;
	@Column(name="denied_by_reason")
	private String deniedByReason;
	@Column(name="cancelled_by_employee")
	private boolean cancelledByEmployee;
	@Column(name="additional_info")
	private String additionalInfo;
	@Column(name="insufficient")
	private boolean insufficient;
	@Column(name="percent")
	private double percent;
	@Column(name="awarded")
	private double awarded;
	@Column(name="adjusted")
	private double adjusted;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="event_id")
	private Event eventId;
	
	@ManyToOne
	@JoinColumn(name="management_id")
	private Management managementId;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employeeId;
	

	public Training() {
		super();
	}


	public Training(int id, String grade, boolean approvedByDS, boolean approvedByDH, boolean approvedByBC,
			boolean deniedByDS, boolean deniedByDH, boolean deniedByBC, double awardedReimbursment,
			String deniedByReason, boolean cancelledByEmployee, String additionalInfo, boolean insufficient,
			double percent, double awarded, double adjusted, Event eventId, Management managementId,
			Employee employeeId) {
		super();
		this.id = id;
		Grade = grade;
		this.approvedByDS = approvedByDS;
		this.approvedByDH = approvedByDH;
		this.approvedByBC = approvedByBC;
		this.deniedByDS = deniedByDS;
		this.deniedByDH = deniedByDH;
		this.deniedByBC = deniedByBC;
		this.awardedReimbursment = awardedReimbursment;
		this.deniedByReason = deniedByReason;
		this.cancelledByEmployee = cancelledByEmployee;
		this.additionalInfo = additionalInfo;
		this.insufficient = insufficient;
		this.percent = percent;
		this.awarded = awarded;
		this.adjusted = adjusted;
		this.eventId = eventId;
		this.managementId = managementId;
		this.employeeId = employeeId;
	}


	public Training(String grade, boolean approvedByDS, boolean approvedByDH, boolean approvedByBC, boolean deniedByDS,
			boolean deniedByDH, boolean deniedByBC, double awardedReimbursment, String deniedByReason,
			boolean cancelledByEmployee, String additionalInfo, boolean insufficient, double percent, double awarded,
			double adjusted, Event eventId, Management managementId, Employee employeeId) {
		super();
		Grade = grade;
		this.approvedByDS = approvedByDS;
		this.approvedByDH = approvedByDH;
		this.approvedByBC = approvedByBC;
		this.deniedByDS = deniedByDS;
		this.deniedByDH = deniedByDH;
		this.deniedByBC = deniedByBC;
		this.awardedReimbursment = awardedReimbursment;
		this.deniedByReason = deniedByReason;
		this.cancelledByEmployee = cancelledByEmployee;
		this.additionalInfo = additionalInfo;
		this.insufficient = insufficient;
		this.percent = percent;
		this.awarded = awarded;
		this.adjusted = adjusted;
		this.eventId = eventId;
		this.managementId = managementId;
		this.employeeId = employeeId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getGrade() {
		return Grade;
	}


	public void setGrade(String grade) {
		Grade = grade;
	}


	public boolean isApprovedByDS() {
		return approvedByDS;
	}


	public void setApprovedByDS(boolean approvedByDS) {
		this.approvedByDS = approvedByDS;
	}


	public boolean isApprovedByDH() {
		return approvedByDH;
	}


	public void setApprovedByDH(boolean approvedByDH) {
		this.approvedByDH = approvedByDH;
	}


	public boolean isApprovedByBC() {
		return approvedByBC;
	}


	public void setApprovedByBC(boolean approvedByBC) {
		this.approvedByBC = approvedByBC;
	}


	public boolean isDeniedByDS() {
		return deniedByDS;
	}


	public void setDeniedByDS(boolean deniedByDS) {
		this.deniedByDS = deniedByDS;
	}


	public boolean isDeniedByDH() {
		return deniedByDH;
	}


	public void setDeniedByDH(boolean deniedByDH) {
		this.deniedByDH = deniedByDH;
	}


	public boolean isDeniedByBC() {
		return deniedByBC;
	}


	public void setDeniedByBC(boolean deniedByBC) {
		this.deniedByBC = deniedByBC;
	}


	public double getAwardedReimbursment() {
		return awardedReimbursment;
	}


	public void setAwardedReimbursment(double awardedReimbursment) {
		this.awardedReimbursment = awardedReimbursment;
	}


	public String getDeniedByReason() {
		return deniedByReason;
	}


	public void setDeniedByReason(String deniedByReason) {
		this.deniedByReason = deniedByReason;
	}


	public boolean isCancelledByEmployee() {
		return cancelledByEmployee;
	}


	public void setCancelledByEmployee(boolean cancelledByEmployee) {
		this.cancelledByEmployee = cancelledByEmployee;
	}


	public String getAdditionalInfo() {
		return additionalInfo;
	}


	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}


	public boolean isInsufficient() {
		return insufficient;
	}


	public void setInsufficient(boolean insufficient) {
		this.insufficient = insufficient;
	}


	public double getPercent() {
		return percent;
	}


	public void setPercent(double percent) {
		this.percent = percent;
	}


	public double getAwarded() {
		return awarded;
	}


	public void setAwarded(double awarded) {
		this.awarded = awarded;
	}


	public double getAdjusted() {
		return adjusted;
	}


	public void setAdjusted(double adjusted) {
		this.adjusted = adjusted;
	}


	public Event getEventId() {
		return eventId;
	}


	public void setEventId(Event eventId) {
		this.eventId = eventId;
	}


	public Management getManagementId() {
		return managementId;
	}


	public void setManagementId(Management managementId) {
		this.managementId = managementId;
	}


	public Employee getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}


	@Override
	public String toString() {
		return "Training [id=" + id + ", Grade=" + Grade + ", approvedByDS=" + approvedByDS + ", approvedByDH="
				+ approvedByDH + ", approvedByBC=" + approvedByBC + ", deniedByDS=" + deniedByDS + ", deniedByDH="
				+ deniedByDH + ", deniedByBC=" + deniedByBC + ", awardedReimbursment=" + awardedReimbursment
				+ ", deniedByReason=" + deniedByReason + ", cancelledByEmployee=" + cancelledByEmployee
				+ ", additionalInfo=" + additionalInfo + ", insufficient=" + insufficient + ", percent=" + percent
				+ ", awarded=" + awarded + ", adjusted=" + adjusted + ", eventId=" + eventId + ", managementId="
				+ managementId + ", employeeId=" + employeeId + "]";
	}

	
}
