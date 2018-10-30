package com.asp.emr.dao;

import java.util.List;

import com.asp.emr.model.Patient;

public interface PatientDao {
	
public List<Patient> getAllPatients();

public void addPatient(int MRnum,Patient patient) ;	
}
