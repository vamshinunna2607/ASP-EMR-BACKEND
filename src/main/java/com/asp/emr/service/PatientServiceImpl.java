package com.asp.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asp.emr.Util;
import com.asp.emr.dao.PatientDao;
import com.asp.emr.dao.UserDao;
import com.asp.emr.model.Patient;
import com.asp.emr.model.User;

@Component
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientDao patientDao;

	@Autowired
	UserDao userDao;

	@Autowired
	Util util;

	private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMERIC = "0123456789";
	private static final String SPECIAL_CHARS = "!@#";

	@Override
	public List<Patient> getAllPatients() {
		return this.patientDao.getAllPatients();
	}

	@Override
	public User addPatient(Patient patient) {
		try {
			patientDao.addPatient(patient);
		} catch (Exception e) {
			return null;
		}
		User user = new User();
		user.setUserPhone(patient.getMobileNo());
		user.setUserType("PATIENT");
		user.setUserName(patient.getFirstName() + " " + patient.getLastName());
		String password = util.generatePassword(8, ALPHA + NUMERIC + SPECIAL_CHARS);
		user.setPassword(password);
		try {
			userDao.addUser(user);
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Patient getPatientDetails(int mrNum) {
		return this.patientDao.getPatientDetails(mrNum);
	}

	@Override
	public List<Patient> getPatientDetails(String firstName, String lastName) {
		return this.patientDao.getPatientDetails(firstName, lastName);
	}

	@Override
	public Patient findUserByPhone(long phone) {
		return this.patientDao.findUserByPhone(phone);
	}

	@Override
	public Patient getPatientDetails(long phone) {
		return this.patientDao.getPatientDetails(phone);
	}
}
