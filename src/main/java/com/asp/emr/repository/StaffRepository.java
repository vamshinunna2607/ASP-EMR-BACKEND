package com.asp.emr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asp.emr.model.HospitalStaff;

public interface StaffRepository extends JpaRepository<HospitalStaff, String> {

}
