package com.asp.emr.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asp.emr.Util;
import com.asp.emr.dao.StaffDao;
import com.asp.emr.dao.UserDao;
import com.asp.emr.model.HospitalStaff;
import com.asp.emr.model.User;

@Component
public class StaffServiceImpl implements StaffService {

	@Autowired
	StaffDao staffDao;

	@Autowired
	UserDao userDao;

	@Autowired
	Util util;

	private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMERIC = "0123456789";
	private static final String SPECIAL_CHARS = "!@#";

	public List<HospitalStaff> getStaffData() {
		return this.staffDao.getStaffData();
	}

	@Override
	public HospitalStaff findUserByEmail(String email, String password) {
		Optional<HospitalStaff> staff = staffDao.findUserByEmail(email, password);
		if (staff.isPresent()) {
			String dbPassword = staff.get().getPassword();
			if (password.equals(dbPassword)) {
				return staff.get();
			} else {
				throw new RuntimeException("UserId/Password does not match");
			}
		} else {
			throw new RuntimeException("UserId/Password does not match");
		}

	}

	@Override
	@Transactional
	public User addStaff(HospitalStaff hospitalStaff) {
		try {
			staffDao.addStaff(hospitalStaff);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		User user = new User();
		user.setUserPhone((int) hospitalStaff.getMobileNo());
		user.setUserType("STAFF");
		user.setUserName(hospitalStaff.getFirstName() + " " + hospitalStaff.getLastName());
		String password = util.generatePassword(8, ALPHA + NUMERIC + SPECIAL_CHARS);
		user.setPassword(password);
		try {
			userDao.addUser(user);
			return user;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public HospitalStaff findUserByPhone(int phone) {
		return staffDao.findUserByPhone(phone);
	}

}
