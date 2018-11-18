package com.asp.emr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asp.emr.model.Patient;
import com.asp.emr.service.PatientService;
import com.asp.emr.service.PatientServiceImpl;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService patientService;
		
	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public void addPatient(@RequestBody Patient patient) {
		this.patientService.addPatient(patient);
	}
	
	@GetMapping("/allPatients")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Patient> getAllPatients( ) {
		return this.patientService.getAllPatients();
	}
}
