package com.asp.emr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asp.emr.Util;
import com.asp.emr.dao.UserDao;
import com.asp.emr.model.User;
import com.asp.emr.repository.PatientRepository;
import com.asp.emr.repository.StaffRepository;
import com.asp.emr.repository.UserRepository;
import com.asp.emr.service.PasswordEncrypt;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserRepository repo;
	
	@Autowired
	PasswordEncrypt passwordEncrypt;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	StaffRepository repoStaff;
	
	@Autowired
	PatientRepository repoPatient;
	
	@Autowired
	Util util;
	
	private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMERIC = "0123456789";
	private static final String SPECIAL_CHARS = "!@#";

	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public User findUserByPasswordAndPhone(@RequestParam String phone, @RequestParam String password) {
		User user = repo.findUserByPhone(Long.parseLong(phone));
		
		if (null == user) {
			User user2 = new User();
			user2.setUserName("ERROR");
			return user2;
		}
		return user;
	}
	
	@GetMapping("/forgotPassword")
	@CrossOrigin(origins = "http://localhost:4200")
	public User findUserByDOBandPhone(@RequestParam String dob, @RequestParam String phone) {
		User user = repo.findUserByPhone(Long.parseLong(phone));
		boolean isDOB = false;
		if(user != null && user.getUserType().equalsIgnoreCase("STAFF")) {
			String DOB = repoStaff.getDOB(Long.parseLong(phone));
			if(DOB.equalsIgnoreCase(dob)) {
				isDOB = true;
			}
		}
		
		else if(user != null && user.getUserType().equalsIgnoreCase("PATIENT")){
			String DOB = repoPatient.getDOB(Long.parseLong(phone));
			if(DOB.equalsIgnoreCase(dob)) {
				isDOB = true;
			}
		}
		
		if(isDOB) {
			String password = util.generatePassword(8, ALPHA + NUMERIC + SPECIAL_CHARS);
			user.setPassword(password);
			try {
				userDao.addUser(user);
			} catch (Exception e) {
				return null;
			}
			user.setPassword(password);
		}
		return user;
	}
}
