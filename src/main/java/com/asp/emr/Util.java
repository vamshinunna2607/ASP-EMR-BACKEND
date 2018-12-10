package com.asp.emr;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class Util {

	public String generatePassword(int len, String dic) {
		SecureRandom random = new SecureRandom();
		String result = "";
		for (int i = 0; i < len; i++) {
			int index = random.nextInt(dic.length());
			result += dic.charAt(index);
		}
		return result;
	}
}
