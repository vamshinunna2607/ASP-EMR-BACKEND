package com.asp.emr.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asp.emr.model.HospitalStaff;
import com.asp.emr.repository.StaffRepository;

@Repository
public class StaffDaoImpl implements StaffDao {

	@Autowired
	StaffRepository staffRepo;

	@Override
	public List<HospitalStaff> getStaffData() {
		try {
			return this.staffRepo.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public Optional<HospitalStaff> findUserByEmail(String email, String password) {
		try {
			return staffRepo.findById(email);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String addStaff(HospitalStaff hospitalStaff) {
		staffRepo.save(hospitalStaff);
		return "success";
	}

	@Override
	public HospitalStaff findUserByPhone(int phone) {
		try {
			return staffRepo.findUserByPhone(phone);
		} catch (Exception e) {
			return null;
		}
	}

}