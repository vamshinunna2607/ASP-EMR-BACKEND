package com.asp.emr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asp.emr.model.User;
import com.asp.emr.repository.UserRepository;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	UserRepository repo;

	@Override
	public void addUser(User user) {
		repo.save(user);
	}

}
