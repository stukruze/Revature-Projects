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
@Table(name="Traning")
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="approved_by_grade", nullable = false)
	private boolean approvedByGrade;
	@Column(name="approved_by_DS", nullable = false)
	private boolean approvedByDS;
	@Column(name="approved_by_DH", nullable = false)
	private boolean approvedByDH;
	@Column(name="approved_by_BC", nullable = false)
	private boolean approvedByBC;
	@Column(name="awardedReimbursment")
	private double awardedReimbursment;
	@Column(name="date_filed", nullable = false)
	private long dateFiled;
	@Column(name="justification")
	private String justification;
	@Column(name="event_attachment_URL")
	private String eventAttachmentURL;
	@Column(name="approval_attachment_URL")
	private String approvalAttachmentURL;
	@Column(name="type_of_approval")
	private String typeOfApproval;
	@Column(name="work_missed", nullable = false)
	private long workMissed;
	@Column(name="additional_info_DS")
	private boolean additionalInfoDS;
	@Column(name="additional_info_DH")
	private boolean additionalInfoDH;
	@Column(name="additional_info_BC")
	private boolean additionalInfoBC;
	@Column(name="denied_by_reason")
	private String deniedByDSReason;
	@Column(name="cancelled_by_employee")
	private boolean cancelledByEmployee;	
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private Event eventId;
	
	@ManyToOne
	@JoinColumn(name="DS_id")
	private Management DSId;
	
	@ManyToOne
	@JoinColumn(name="DH_id")
	private Management DHId;
	
	@ManyToOne
	@JoinColumn(name="BC_id")
	private Management BCId;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employeeId;

	public Training() {
		super();
	}

	public Training(int id, boolean approvedByGrade, boolean approvedByDS, boolean approvedByDH, boolean approvedByBC,
			double awardedReimbursment, long dateFiled, String justification, String eventAttachmentURL,
			String approvalAttachmentURL, String typeOfApproval, long workMissed, boolean additionalInfoDS,
			boolean additionalInfoDH, boolean additionalInfoBC, String deniedByDSReason, boolean cancelledByEmployee,
			Event eventId, Management dSId, Management dHId, Management bCId, Employee employeeId) {
		super();
		this.id = id;
		this.approvedByGrade = approvedByGrade;
		this.approvedByDS = approvedByDS;
		this.approvedByDH = approvedByDH;
		this.approvedByBC = approvedByBC;
		this.awardedReimbursment = awardedReimbursment;
		this.dateFiled = dateFiled;
		this.justification = justification;
		this.eventAttachmentURL = eventAttachmentURL;
		this.approvalAttachmentURL = approvalAttachmentURL;
		this.typeOfApproval = typeOfApproval;
		this.workMissed = workMissed;
		this.additionalInfoDS = additionalInfoDS;
		this.additionalInfoDH = additionalInfoDH;
		this.additionalInfoBC = additionalInfoBC;
		this.deniedByDSReason = deniedByDSReason;
		this.cancelledByEmployee = cancelledByEmployee;
		this.eventId = eventId;
		DSId = dSId;
		DHId = dHId;
		BCId = bCId;
		this.employeeId = employeeId;
	}

	public Training(boolean approvedByGrade, boolean approvedByDS, boolean approvedByDH, boolean approvedByBC,
			double awardedReimbursment, long dateFiled, String justification, String eventAttachmentURL,
			String approvalAttachmentURL, String typeOfApproval, long workMissed, boolean additionalInfoDS,
			boolean additionalInfoDH, boolean additionalInfoBC, String deniedByDSReason, boolean cancelledByEmployee,
			Event eventId, Management dSId, Management dHId, Management bCId, Employee employeeId) {
		super();
		this.approvedByGrade = approvedByGrade;
		this.approvedByDS = approvedByDS;
		this.approvedByDH = approvedByDH;
		this.approvedByBC = approvedByBC;
		this.awardedReimbursment = awardedReimbursment;
		this.dateFiled = dateFiled;
		this.justification = justification;
		this.eventAttachmentURL = eventAttachmentURL;
		this.approvalAttachmentURL = approvalAttachmentURL;
		this.typeOfApproval = typeOfApproval;
		this.workMissed = workMissed;
		this.additionalInfoDS = additionalInfoDS;
		this.additionalInfoDH = additionalInfoDH;
		this.additionalInfoBC = additionalInfoBC;
		this.deniedByDSReason = deniedByDSReason;
		this.cancelledByEmployee = cancelledByEmployee;
		this.eventId = eventId;
		DSId = dSId;
		DHId = dHId;
		BCId = bCId;
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

	public long getDateFiled() {
		return dateFiled;
	}

	public void setDateFiled(long dateFiled) {
		this.dateFiled = dateFiled;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
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

	public long getWorkMissed() {
		return workMissed;
	}

	public void setWorkMissed(long workMissed) {
		this.workMissed = workMissed;
	}

	public boolean isAdditionalInfoDS() {
		return additionalInfoDS;
	}

	public void setAdditionalInfoDS(boolean additionalInfoDS) {
		this.additionalInfoDS = additionalInfoDS;
	}

	public boolean isAdditionalInfoDH() {
		return additionalInfoDH;
	}

	public void setAdditionalInfoDH(boolean additionalInfoDH) {
		this.additionalInfoDH = additionalInfoDH;
	}

	public boolean isAdditionalInfoBC() {
		return additionalInfoBC;
	}

	public void setAdditionalInfoBC(boolean additionalInfoBC) {
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

	public Management getDSId() {
		return DSId;
	}

	public void setDSId(Management dSId) {
		DSId = dSId;
	}

	public Management getDHId() {
		return DHId;
	}

	public void setDHId(Management dHId) {
		DHId = dHId;
	}

	public Management getBCId() {
		return BCId;
	}

	public void setBCId(Management bCId) {
		BCId = bCId;
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
				+ awardedReimbursment + ", dateFiled=" + dateFiled + ", justification=" + justification
				+ ", eventAttachmentURL=" + eventAttachmentURL + ", approvalAttachmentURL=" + approvalAttachmentURL
				+ ", typeOfApproval=" + typeOfApproval + ", workMissed=" + workMissed + ", additionalInfoDS="
				+ additionalInfoDS + ", additionalInfoDH=" + additionalInfoDH + ", additionalInfoBC=" + additionalInfoBC
				+ ", deniedByDSReason=" + deniedByDSReason + ", cancelledByEmployee=" + cancelledByEmployee
				+ ", eventId=" + eventId + ", DSId=" + DSId + ", DHId=" + DHId + ", BCId=" + BCId + ", employeeId="
				+ employeeId + "]";
	}


	
}
