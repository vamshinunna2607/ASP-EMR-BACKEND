package com.asp.emr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asp.emr.model.HospitalStaff;
import com.asp.emr.model.User;
import com.asp.emr.service.StaffService;

@RestController
@RequestMapping("/staff")
public class MedicalstaffController {

	@Autowired
	StaffService staffService;

	@GetMapping("/entireStaff")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<HospitalStaff> getAllStaff() {
		return this.staffService.getStaffData();
	}

	@RequestMapping(value = "/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public HospitalStaff findUserByPhone(@RequestParam int phone) {
		return staffService.findUserByPhone(phone);
	}

	@RequestMapping(value = "/addStaff", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public User addStaff(@RequestBody HospitalStaff hospitalStaff) {
		return this.staffService.addStaff(hospitalStaff);
	}
}
