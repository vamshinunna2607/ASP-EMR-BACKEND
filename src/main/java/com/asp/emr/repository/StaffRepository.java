package com.asp.emr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asp.emr.model.HospitalStaff;

public interface StaffRepository extends JpaRepository<HospitalStaff, String> {

	@Query(value = "select * from medicalstaff_registration", nativeQuery = true)
	List<HospitalStaff> findAll();
}
