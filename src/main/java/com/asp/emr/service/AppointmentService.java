package com.asp.emr.service;

import java.sql.Date;
import java.util.List;

import com.asp.emr.model.Appointment;

public interface AppointmentService {

	public Appointment findAppointment(int id);
	public List<Appointment> findByDate(Date date);
}
