package com.asp.emr.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity(name = "soap")
public class Soap {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int soapId;
	@Column
	private String subjectiveNote;
	@Column
	private String objectiveNote;
	@Column
	private String assessmentNote;
	@Column
	private String planNote;

	@Column
	private Date soapDate;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Patient.class)
	@JoinColumn(name = "mrnum")
	private Patient patient;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = HospitalStaff.class)
	@JoinColumn(name = "email")
	private HospitalStaff hospitalStaff;

	@PrePersist
	public void prePresist() {
		this.soapDate = new Date(System.currentTimeMillis());
	}

	public Soap() {
		super();
	}

	public int getSoapId() {
		return soapId;
	}

	public void setSoapId(int soapId) {
		this.soapId = soapId;
	}

	public String getSubjectiveNote() {
		return subjectiveNote;
	}

	public void setSubjectiveNote(String subjectiveNote) {
		this.subjectiveNote = subjectiveNote;
	}

	public String getObjectiveNote() {
		return objectiveNote;
	}

	public void setObjectiveNote(String objectiveNote) {
		this.objectiveNote = objectiveNote;
	}

	public String getAssessmentNote() {
		return assessmentNote;
	}

	public void setAssessmentNote(String assessmentNote) {
		this.assessmentNote = assessmentNote;
	}

	public String getPlanNote() {
		return planNote;
	}

	public void setPlanNote(String planNote) {
		this.planNote = planNote;
	}

	public Date getSoapDate() {
		return soapDate;
	}

	public void setSoapDate(Date soapDate) {
		this.soapDate = soapDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public HospitalStaff getHospitalStaff() {
		return hospitalStaff;
	}

	public void setHospitalStaff(HospitalStaff hospitalStaff) {
		this.hospitalStaff = hospitalStaff;
	}

}
