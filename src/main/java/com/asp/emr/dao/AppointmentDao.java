package com.asp.emr.dao;

import java.sql.Date;
import java.util.List;

import com.asp.emr.model.Appointment;

public interface AppointmentDao {

	public Appointment findAppointment(int id);
	public List<Appointment> findByDate(Date date);
}
