package com.asp.emr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asp.emr.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM USER WHERE USER_PHONE =?1 AND USER_PASSWORD = ?2", nativeQuery = true)
	User findUserByPhoneAndPassword(long l, String password);
	
	@Query(value = "SELECT * FROM USER WHERE USER_PHONE =?1", nativeQuery = true)
	User findUserByPhone(long l);
}
