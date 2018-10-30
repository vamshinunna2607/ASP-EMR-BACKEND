package com.asp.emr.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asp.emr.model.HospitalStaff;
import com.asp.emr.repository.StaffRepository;

@Repository
public class StaffDaoImpl implements StaffDao{
	
	@Autowired
	StaffRepository staffRepo;
	
	@Override
	public List<HospitalStaff> getStaffData(){
		return this.staffRepo.findAll();
	}
	
	public Optional<HospitalStaff> findUserByEmail(String email, String password) {
		
		return staffRepo.findById(email);
}

}