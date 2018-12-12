package com.asp.emr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asp.emr.model.Patient;
import com.asp.emr.model.User;
import com.asp.emr.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService patientService;

	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public User addPatient(@RequestBody Patient patient) {
		User user = this.patientService.addPatient(patient);
		if (null == user) {
			User user2 = new User();
			user2.setUserName("ERROR");
			return user2;
		}
		return user;
	}

	@GetMapping("/{mrNum}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Patient> getPatientDetails(@PathVariable int mrNum) {
		List<Patient> patientList = new ArrayList<Patient>();
		patientList.add(patientService.getPatientDetails(mrNum));
		return patientList;
	}

	@GetMapping("phone/{phone}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Patient> getPatientDetails(@PathVariable long phone) {
		List<Patient> patientList = new ArrayList<Patient>();
		patientList.add(patientService.getPatientDetails(phone));
		return patientList;
	}

	@GetMapping("/get")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Patient> getPatientDetailsUsingNameAndDOB(@RequestParam String firstName,
			@RequestParam String lastName) {
		return patientService.getPatientDetails(firstName, lastName);
	}

	@GetMapping("/allPatients")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Patient> getAllPatients() {
		return this.patientService.getAllPatients();
	}

	@RequestMapping(value = "/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public Patient findUserByPhone(@RequestParam long phone) {
		return patientService.findUserByPhone(phone);
	}

}
