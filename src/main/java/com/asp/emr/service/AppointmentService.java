package com.asp.emr.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.asp.emr.model.Appointment;

public interface AppointmentService {

	public Appointment findAppointment(int id);

	public List<Appointment> findByDate(Date date);

	public Appointment createAppointment(Appointment appointment);

	public boolean isValidAppointment(Date date, Time time, String docEmail);

}
