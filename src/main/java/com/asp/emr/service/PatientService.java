package com.asp.emr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asp.emr.model.Patient;

public interface PatientService {

	public List<Patient> getAllPatients();
	
	public void addPatient(Patient patient) ;
}
