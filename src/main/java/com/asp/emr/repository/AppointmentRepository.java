package com.asp.emr.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asp.emr.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	@Query(nativeQuery=true,value="select * from test.appointments where date = ?1")
	public List<Appointment> findByDate(Date date);
	
	@Query(nativeQuery=true,value="select count(*) from test.appointments where date = ?1 and time =?2 and email = ?3")
	public int isValidAppointment(Date date, Time time, String docEmail);

	@Query(nativeQuery = true, value="select * from appointments where mrnum = ?1 and date = ?2 and status = 0")
	public List<Appointment> findAppointmentByDateAndMrNumber(int mrnum, Date date);

	@Query(nativeQuery = true, value="select * from appointments where mrnum in (select mrnum from patient_registration where mobile_no = ?1)")
	public List<Appointment> findbyMrno(long mobile_no);

	@Query(nativeQuery = true, value="select * from appointments where date = curdate()")
	public List<Appointment> getAppointmentsForCurrentDate();

	@Query(nativeQuery=true,value="select * from test.appointments where date = ?1 and email in (select email from medicalstaff_registration where mobile_no = ?2)")
	public List<Appointment> findByDateAndPhone(Date date, long phone);
}
