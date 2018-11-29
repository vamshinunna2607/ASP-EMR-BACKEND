package com.asp.emr.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.asp.emr.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "Appointments")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Appointment {

	@Column(updatable = false, nullable = false, name = "appid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appID;
	@Column
	private Date date;
	@Column
	private Time time;
	@Column
	private String comments;
	@Column
	private String chiefComplaints;
	@Column
	private String healthStatus;
	@Column
	private String lastMedication;
	@Column
	private AppointmentStatus status;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Patient.class)
	@JoinColumn(name = "mrnum")
//	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "mrnum")
//	@JsonProperty(value = "mrnum")
//	@JsonIdentityReference(alwaysAsId = true)
	private Patient patient;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = HospitalStaff.class)
	@JoinColumn(name = "email")
//	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "email")
//	@JsonProperty(value = "email")
//	@JsonIdentityReference(alwaysAsId = true)
	private HospitalStaff hospitalStaff;

	public Appointment() {
		super();

	}

	public Appointment(int appID, Date date, Time time, String comments, String chiefComplaints, String healthStatus,
			String lastMedication, Patient patient, HospitalStaff hospitalStaff) {
		super();
		this.appID = appID;
		this.date = date;
		this.time = time;
		this.comments = comments;
		this.chiefComplaints = chiefComplaints;
		this.healthStatus = healthStatus;
		this.lastMedication = lastMedication;
		this.patient = patient;
		this.hospitalStaff = hospitalStaff;
		this.status = AppointmentStatus.PENDING;
	}

	public int getAppID() {
		return appID;
	}

	public void setAppID(int appID) {
		this.appID = appID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getChiefComplaints() {
		return chiefComplaints;
	}

	public void setChiefComplaints(String chiefComplaints) {
		this.chiefComplaints = chiefComplaints;
	}

	public String getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	public String getLastMedication() {
		return lastMedication;
	}

	public void setLastMedication(String lastMedication) {
		this.lastMedication = lastMedication;
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

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}
}
