package com.asp.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.asp.emr.dao.PatientDao;
import com.asp.emr.dao.PatientDaoImpl;
import com.asp.emr.model.Patient;

@Component
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientDao patientDao;
	
	@Override
	public List<Patient> getAllPatients() {
		
		return this.patientDao.getAllPatients();
	}

	@Override
	public void addPatient(int MRnum, Patient patient) {
		
		this.patientDao.addPatient(MRnum, patient);
	}

}
