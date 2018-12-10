package com.asp.emr.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.asp.emr.model.Appointment;

public interface AppointmentDao {

	public Appointment findAppointment(int id);
	public List<Appointment> findByDate(Date date);
	public Appointment createAppointment(Appointment appointment);
	public int isValidAppointment(Date date, Time time, String docEmail);
	public boolean checkForOverlappingAppointments(int mRnum, Date date);
	public List<Appointment> findByMrno(long mrno);
	public List<Appointment> getAppointmentsForCurrentDate();
	public List<Appointment> findByDateAndPhone(Date date, long phone);
}
