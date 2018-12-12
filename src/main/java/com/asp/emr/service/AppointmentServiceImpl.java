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
	public Appointment createAppointment(Appointment appointment, boolean update) {
		try {
			if (!update) {
				boolean flag = appointmentDao.checkForOverlappingAppointments(appointment.getPatient().getMRnum(),
						appointment.getDate());
				if (flag) {
					return appointmentDao.createAppointment(appointment);
				}
			} else {
				return appointmentDao.createAppointment(appointment);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public boolean isValidAppointment(Date date, Time time, String docEmail) {
		int appointmentCount = appointmentDao.isValidAppointment(date, time, docEmail);
		if (appointmentCount == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Appointment> findByMrno(long mrno) {
		return appointmentDao.findByMrno(mrno);
	}

	@Override
	public List<Appointment> getAppointmentsForCurrentDate() {
		return appointmentDao.getAppointmentsForCurrentDate();
	}

	@Override
	public List<Appointment> findByDate(Date date, long phone) {
		return appointmentDao.findByDateAndPhone(date, phone);
	}

}
