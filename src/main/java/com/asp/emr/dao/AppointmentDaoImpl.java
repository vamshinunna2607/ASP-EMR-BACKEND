package com.asp.emr.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asp.emr.model.Appointment;
import com.asp.emr.repository.AppointmentRepository;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {

	@Autowired
	AppointmentRepository appointmentsRepository;

	public Appointment findAppointment(int id) {
		return appointmentsRepository.getOne(id);
	}

	@Override
	public List<Appointment> findByDate(Date date) {
		List<Appointment> list = appointmentsRepository.findByDate(date);
		for(Appointment app:list) {
			System.out.println(app.getAppID());
		}
		return list;
	}

	@Override
	public Appointment createAppointment(Appointment appointment) {
		return appointmentsRepository.save(appointment);
	}
}
