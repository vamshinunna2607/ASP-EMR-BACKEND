package com.asp.emr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asp.emr.dao.StaffDao;
import com.asp.emr.model.HospitalStaff;

@Component
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	StaffDao staffDao;
	
	public List<HospitalStaff> getStaffData(){
		return this.staffDao.getStaffData();
	}

	@Override
	public HospitalStaff findUserByEmail(String email, String password) {
		Optional<HospitalStaff> staff = staffDao.findUserByEmail(email, password);
		if(staff.isPresent())
		{
			String dbPassword = staff.get().getPassword();
			if(password.equals(dbPassword)) {
				return staff.get();
			}else {
				throw new RuntimeException("UserId/Password does not match");
			}
		}else {
			throw new RuntimeException("UserId/Password does not match");
		}
		
		
	}

}
