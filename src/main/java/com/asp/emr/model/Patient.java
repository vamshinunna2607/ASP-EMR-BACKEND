package com.asp.emr.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="patientRegistration")
public class Patient {

	@Column(updatable = false, nullable = false,name="mrnum")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int MRnum;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String salutation;
	@Column
	private Date dob;
	@Column
	private String race;
	@Column
	private String ethnicity;
	@Column
	private String gender;
	@Column
	private String genderIdentity;
	@Column
	private String occupation;
	@Column
	private String sexOrientation;
	@Column
	private String maritalStatus;
	@Column
	private String preferredLanguage;
	@Column
	private String communicationPreferences;
	@Column
	private String disabilityStatus;
	@Column
	private Date firstVisit;
	@Column
	private int SSN;
	@Column
	private String addressline1;
	@Column
	private String addressline2;
	@Column
	private int zipCode;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private int homeTelephone;
	@Column
	private int mobileNo;
	@Column
	private String Kin_First;
	@Column
	private String Kin_Last;
	@Column
	private String Kin_Address;
	@Column
	private String Kin_Telephone;
	@Column
	private String relationship;
	
	public int getMRnum() {
		return MRnum;
	}
	public void setMRnum(int mRnum) {
		MRnum = mRnum;
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
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGenderIdentity() {
		return genderIdentity;
	}
	public void setGenderIdentity(String genderIdentity) {
		this.genderIdentity = genderIdentity;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getSexOrientation() {
		return sexOrientation;
	}
	public void setSexOrientation(String sexOrientation) {
		this.sexOrientation = sexOrientation;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getPreferredLanguage() {
		return preferredLanguage;
	}
	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}
	public String getCommunicationPreferences() {
		return communicationPreferences;
	}
	public void setCommunicationPreferences(String communicationPreferences) {
		this.communicationPreferences = communicationPreferences;
	}
	public String getDisabilityStatus() {
		return disabilityStatus;
	}
	public void setDisabilityStatus(String disabilityStatus) {
		this.disabilityStatus = disabilityStatus;
	}
	public Date getFirstVisit() {
		return firstVisit;
	}
	public void setFirstVisit(Date firstVisit) {
		this.firstVisit = firstVisit;
	}
	public int getSSN() {
		return SSN;
	}
	public void setSSN(int sSN) {
		SSN = sSN;
	}
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getHomeTelephone() {
		return homeTelephone;
	}
	public void setHomeTelephone(int homeTelephone) {
		this.homeTelephone = homeTelephone;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getKin_First() {
		return Kin_First;
	}
	public void setKin_First(String kin_First) {
		Kin_First = kin_First;
	}
	public String getKin_Last() {
		return Kin_Last;
	}
	public void setKin_Last(String kin_Last) {
		Kin_Last = kin_Last;
	}
	public String getKin_Address() {
		return Kin_Address;
	}
	public void setKin_Address(String kin_Address) {
		Kin_Address = kin_Address;
	}
	public String getKin_Telephone() {
		return Kin_Telephone;
	}
	public void setKin_Telephone(String kin_Telephone) {
		Kin_Telephone = kin_Telephone;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	  
}

