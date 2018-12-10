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
		try {
			return this.patientRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String addPatient(Patient patient) {
		this.patientRepository.save(patient);
		return "success";
	}

	@Override
	public Patient getPatientDetails(int mrNum) {
		try {
			return this.patientRepository.findById(mrNum).orElseThrow(RuntimeException::new);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Patient> getPatientDetails(String kin_first, String kin_last) {
		try {
			kin_first = kin_first + "%";
			kin_last = kin_last + "%";
			return this.patientRepository.findByNameAndDob(kin_first, kin_last);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Patient findUserByPhone(long phone) {
		try {
			return this.patientRepository.findByPhone(phone);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Patient getPatientDetails(long phone) {
		try {
			return this.patientRepository.findByPhone(phone);

		} catch (Exception e) {
			return null;
		}
	}
}
