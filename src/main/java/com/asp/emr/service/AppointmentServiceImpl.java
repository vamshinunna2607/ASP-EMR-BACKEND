package com.asp.emr.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asp.emr.dao.AppointmentDao;
import com.asp.emr.model.Appointment;

@Component
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentDao appointmentDao;

	@Override
	public Appointment findAppointment(int id) {

		return appointmentDao.findAppointment(id);
	}

	@Override
	public List<Appointment> findByDate(Date date) {

		return appointmentDao.findByDate(date);
	}

	@Override
	public Appointment createAppointment(Appointment appointment) {
		return appointmentDao.createAppointment(appointment);
	}

	@Override
	public boolean isValidAppointment(Date date, Time time, String docEmail) {
		return false;
	}

}
