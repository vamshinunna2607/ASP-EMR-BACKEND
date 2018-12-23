package com.asp.emr.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncryptImpl implements PasswordEncrypt{

	@Override
	public String encryptPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
		}
}
