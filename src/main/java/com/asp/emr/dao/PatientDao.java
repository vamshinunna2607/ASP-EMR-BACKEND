package com.asp.emr.dao;

import java.util.List;

import com.asp.emr.model.Patient;

public interface PatientDao {

	public List<Patient> getAllPatients();

	public String addPatient(Patient patient);

	public Patient getPatientDetails(int mrNum);

	public List<Patient> getPatientDetails(String firstName, String lastName);

	public Patient findUserByPhone(long phone);

	public Patient getPatientDetails(long phone);
}
