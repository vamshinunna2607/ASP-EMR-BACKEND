package com.asp.emr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.asp.emr.model.User;
import com.asp.emr.repository.UserRepository;
import com.asp.emr.service.PasswordEncrypt;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	UserRepository repo;
	
	@Autowired
	PasswordEncrypt passwordEncrypt;

	@Override
	public User addUser(User user) {
		String dbPassword;
		if(!StringUtils.isEmpty(user.getPassword())) {
			dbPassword = passwordEncrypt.encryptPassword(user.getPassword());
			user.setPassword(dbPassword);
		}
		System.out.println("user object is" +user);
		repo.save(user);
		return user;
	}
}
