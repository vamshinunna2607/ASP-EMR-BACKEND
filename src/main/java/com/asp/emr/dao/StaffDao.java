package com.asp.emr.dao;

import java.util.List;
import java.util.Optional;

import com.asp.emr.model.HospitalStaff;

public interface StaffDao {

	public List<HospitalStaff> getStaffData();
	
	Optional<HospitalStaff> findUserByEmail(String email, String password);
	
}
