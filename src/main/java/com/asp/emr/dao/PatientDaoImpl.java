package com.asp.emr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asp.emr.model.Patient;
import com.asp.emr.repository.PatientRepository;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	PatientRepository patientRepository;
	
	@Override
	public List<Patient> getAllPatients() {
		return this.patientRepository.findAll();
	}

	@Override
	public void addPatient(int MRnum, Patient patient) {
		this.patientRepository.save(patient);
	}

}
