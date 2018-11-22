package com.asp.emr.service;

import java.util.List;

import com.asp.emr.model.Patient;

public interface PatientService {

	public List<Patient> getAllPatients();
	
	public void addPatient(Patient patient) ;
	
	public Patient getPatientDetails(int mrNum);
}
