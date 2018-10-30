
package com.asp.emr.service;

import java.util.List;
import java.util.Optional;

import com.asp.emr.model.HospitalStaff;

public interface StaffService {

	public List<HospitalStaff> getStaffData();
	
	HospitalStaff findUserByEmail(String email, String password);
}
