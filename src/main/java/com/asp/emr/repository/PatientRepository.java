package com.asp.emr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asp.emr.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>  {

}
