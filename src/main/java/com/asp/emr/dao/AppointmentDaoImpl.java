package com.asp.emr.dao;

import java.sql.Date;
import java.sql.Time;
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
		try {
			return appointmentsRepository.getOne(id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Appointment> findByDate(Date date) {
		try {
			List<Appointment> list = appointmentsRepository.findByDate(date);
			for (Appointment app : list) {
				System.out.println(app.getAppID());
			}
			return list;
		} catch (Exception e) {
			return null;

		}

	}

	@Override
	public Appointment createAppointment(Appointment appointment) {
		try {
			return appointmentsRepository.save(appointment);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int isValidAppointment(Date date, Time time, String docEmail) {
		try {
			return appointmentsRepository.isValidAppointment(date, time, docEmail);

		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public boolean checkForOverlappingAppointments(int mRnum, Date date) {
		try {
			List<Appointment> appointmentList = appointmentsRepository.findAppointmentByDateAndMrNumber(mRnum, date);
			return appointmentList.isEmpty();
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Appointment> findByMrno(long mrno) {
		try {
			return appointmentsRepository.findbyMrno(mrno);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Appointment> getAppointmentsForCurrentDate() {
		try {
			return appointmentsRepository.getAppointmentsForCurrentDate();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Appointment> findByDateAndPhone(Date date, long phone) {
		return appointmentsRepository.findByDateAndPhone(date, phone);
	}
}
