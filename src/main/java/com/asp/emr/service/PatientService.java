package com.asp.emr.service;

import java.util.List;

import com.asp.emr.model.Patient;
import com.asp.emr.model.User;

public interface PatientService {

	public List<Patient> getAllPatients();
	
	public User addPatient(Patient patient) ;
	
	public Patient getPatientDetails(long phone);

	public List<Patient> getPatientDetails(String firstName, String lastName);

	public Patient findUserByPhone(long phone);

	public Patient getPatientDetails(int mrNum);
}
