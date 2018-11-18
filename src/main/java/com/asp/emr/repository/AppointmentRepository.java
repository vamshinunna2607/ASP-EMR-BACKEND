package com.asp.emr.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asp.emr.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	@Query(nativeQuery=true,value="select * from test.appointments where date = ?1")
	public List<Appointment> findByDate(Date date);
}
