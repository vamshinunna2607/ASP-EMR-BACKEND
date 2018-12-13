package com.asp.emr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asp.emr.model.User;
import com.asp.emr.repository.UserRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserRepository repo;

	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public User findUserByPasswordAndPhone(@RequestParam String phone, @RequestParam String password) {
		User user = repo.findUserByPhoneAndPassword(Long.parseLong(phone), password);
		if (null == user) {
			User user2 = new User();
			user2.setUserName("ERROR");
			return user2;
		}
		return user;
	}
}
