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
	@Column(name="approved_by_grade")
	private boolean approvedByGrade;
	@Column(name="approved_by_DS")
	private boolean approvedByDS;
	@Column(name="approved_by_DH")
	private boolean approvedByDH;
	@Column(name="approved_by_BC")
	private boolean approvedByBC;
	@Column(name="awardedReimbursment")
	private double awardedReimbursment;
	@Column(name="event_attachment_URL")
	private String eventAttachmentURL;
	@Column(name="approval_attachment_URL")
	private String approvalAttachmentURL;
	@Column(name="type_of_approval")
	private String typeOfApproval;
	@Column(name="additional_info_DS")
	private String additionalInfoDS;
	@Column(name="additional_info_DH")
	private String additionalInfoDH;
	@Column(name="additional_info_BC")
	private String additionalInfoBC;
	@Column(name="denied_by_reason")
	private String deniedByDSReason;
	@Column(name="cancelled_by_employee")
	private boolean cancelledByEmployee;	
	
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

	public Training(int id, boolean approvedByGrade, boolean approvedByDS, boolean approvedByDH, boolean approvedByBC,
			double awardedReimbursment, String eventAttachmentURL, String approvalAttachmentURL, String typeOfApproval,
			String additionalInfoDS, String additionalInfoDH, String additionalInfoBC, String deniedByDSReason,
			boolean cancelledByEmployee, Event eventId, Management managementId, Employee employeeId) {
		super();
		this.id = id;
		this.approvedByGrade = approvedByGrade;
		this.approvedByDS = approvedByDS;
		this.approvedByDH = approvedByDH;
		this.approvedByBC = approvedByBC;
		this.awardedReimbursment = awardedReimbursment;
		this.eventAttachmentURL = eventAttachmentURL;
		this.approvalAttachmentURL = approvalAttachmentURL;
		this.typeOfApproval = typeOfApproval;
		this.additionalInfoDS = additionalInfoDS;
		this.additionalInfoDH = additionalInfoDH;
		this.additionalInfoBC = additionalInfoBC;
		this.deniedByDSReason = deniedByDSReason;
		this.cancelledByEmployee = cancelledByEmployee;
		this.eventId = eventId;
		this.managementId = managementId;
		this.employeeId = employeeId;
	}

	public Training(boolean approvedByGrade, boolean approvedByDS, boolean approvedByDH, boolean approvedByBC,
			double awardedReimbursment, String eventAttachmentURL, String approvalAttachmentURL, String typeOfApproval,
			String additionalInfoDS, String additionalInfoDH, String additionalInfoBC, String deniedByDSReason,
			boolean cancelledByEmployee, Event eventId, Management managementId, Employee employeeId) {
		super();
		this.approvedByGrade = approvedByGrade;
		this.approvedByDS = approvedByDS;
		this.approvedByDH = approvedByDH;
		this.approvedByBC = approvedByBC;
		this.awardedReimbursment = awardedReimbursment;
		this.eventAttachmentURL = eventAttachmentURL;
		this.approvalAttachmentURL = approvalAttachmentURL;
		this.typeOfApproval = typeOfApproval;
		this.additionalInfoDS = additionalInfoDS;
		this.additionalInfoDH = additionalInfoDH;
		this.additionalInfoBC = additionalInfoBC;
		this.deniedByDSReason = deniedByDSReason;
		this.cancelledByEmployee = cancelledByEmployee;
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

	public boolean isApprovedByGrade() {
		return approvedByGrade;
	}

	public void setApprovedByGrade(boolean approvedByGrade) {
		this.approvedByGrade = approvedByGrade;
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

	public double getAwardedReimbursment() {
		return awardedReimbursment;
	}

	public void setAwardedReimbursment(double awardedReimbursment) {
		this.awardedReimbursment = awardedReimbursment;
	}

	public String getEventAttachmentURL() {
		return eventAttachmentURL;
	}

	public void setEventAttachmentURL(String eventAttachmentURL) {
		this.eventAttachmentURL = eventAttachmentURL;
	}

	public String getApprovalAttachmentURL() {
		return approvalAttachmentURL;
	}

	public void setApprovalAttachmentURL(String approvalAttachmentURL) {
		this.approvalAttachmentURL = approvalAttachmentURL;
	}

	public String getTypeOfApproval() {
		return typeOfApproval;
	}

	public void setTypeOfApproval(String typeOfApproval) {
		this.typeOfApproval = typeOfApproval;
	}

	public String getAdditionalInfoDS() {
		return additionalInfoDS;
	}

	public void setAdditionalInfoDS(String additionalInfoDS) {
		this.additionalInfoDS = additionalInfoDS;
	}

	public String getAdditionalInfoDH() {
		return additionalInfoDH;
	}

	public void setAdditionalInfoDH(String additionalInfoDH) {
		this.additionalInfoDH = additionalInfoDH;
	}

	public String getAdditionalInfoBC() {
		return additionalInfoBC;
	}

	public void setAdditionalInfoBC(String additionalInfoBC) {
		this.additionalInfoBC = additionalInfoBC;
	}

	public String getDeniedByDSReason() {
		return deniedByDSReason;
	}

	public void setDeniedByDSReason(String deniedByDSReason) {
		this.deniedByDSReason = deniedByDSReason;
	}

	public boolean isCancelledByEmployee() {
		return cancelledByEmployee;
	}

	public void setCancelledByEmployee(boolean cancelledByEmployee) {
		this.cancelledByEmployee = cancelledByEmployee;
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
		return "Training [id=" + id + ", approvedByGrade=" + approvedByGrade + ", approvedByDS=" + approvedByDS
				+ ", approvedByDH=" + approvedByDH + ", approvedByBC=" + approvedByBC + ", awardedReimbursment="
				+ awardedReimbursment + ", eventAttachmentURL=" + eventAttachmentURL + ", approvalAttachmentURL="
				+ approvalAttachmentURL + ", typeOfApproval=" + typeOfApproval + ", additionalInfoDS="
				+ additionalInfoDS + ", additionalInfoDH=" + additionalInfoDH + ", additionalInfoBC=" + additionalInfoBC
				+ ", deniedByDSReason=" + deniedByDSReason + ", cancelledByEmployee=" + cancelledByEmployee
				+ ", eventId=" + eventId + ", managementId=" + managementId + ", employeeId=" + employeeId + "]";
	}





	
}
