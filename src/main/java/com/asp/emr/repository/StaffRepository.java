package com.asp.emr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asp.emr.model.HospitalStaff;

public interface StaffRepository extends JpaRepository<HospitalStaff, String> {

	@Query(value = "select * from medicalstaff_registration", nativeQuery = true)
	List<HospitalStaff> findAll();

	@Query(value = "select * from medicalstaff_registration where mobile_no = ?1", nativeQuery = true)
	HospitalStaff findUserByPhone(int mobile_no);

	@Query(value = "select email from medicalstaff_registration where mobile_no = ?1", nativeQuery = true)
	String getEmail(long userPhone);
	
	@Query(value = "select dob from medicalstaff_registration where mobile_no = ?1", nativeQuery = true)
	String getDOB(long userPhone);
}
