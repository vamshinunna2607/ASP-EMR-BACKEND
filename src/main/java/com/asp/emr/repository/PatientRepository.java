package com.asp.emr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asp.emr.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>  {
	
	@Query(value = "select * from patient_registration where lower(first_name) like lower(?1) and lower(last_name) like lower(?2)", nativeQuery = true)
	List<Patient> findByNameAndDob(String first_name, String last_name);

	@Query(value = "select * from patient_registration where mobile_no = ?1", nativeQuery = true)
	Patient findByPhone(long mobile_no);
	
	@Query(value = "select dob from patient_registration where mobile_no = ?1", nativeQuery = true)
	String getDOB(long userPhone);
}
