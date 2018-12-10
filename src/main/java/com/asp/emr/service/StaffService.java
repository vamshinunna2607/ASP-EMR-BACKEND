
package com.asp.emr.service;

import java.util.List;

import com.asp.emr.model.HospitalStaff;
import com.asp.emr.model.User;

public interface StaffService {

	public List<HospitalStaff> getStaffData();
	
	HospitalStaff findUserByEmail(String email, String password);

	public User addStaff(HospitalStaff hospitalStaff);

	public HospitalStaff findUserByPhone(int phone);
}
