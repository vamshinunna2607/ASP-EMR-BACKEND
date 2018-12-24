package com.asp.emr.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asp.emr.model.Appointment;
import com.asp.emr.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@GetMapping("/appointment/{appID}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Appointment findAppointment(@PathVariable("appID") int id) {
		return appointmentService.findAppointment(id);
	}

	@GetMapping("/appointment/date/{appDate}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Appointment> findByDate(@PathVariable("appDate") long date) {
		Date searchDate = new Date(date);
		return appointmentService.findByDate(searchDate);
	}

	@GetMapping("/appointment/mrno/{mrno}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Appointment> findByMrNo(@PathVariable("mrno") long mrno) {
		return appointmentService.findByMrno(mrno);
	}

	@GetMapping("/currentDate")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Appointment> getAppointmentsForCurrentDate() {
		return appointmentService.getAppointmentsForCurrentDate();
	}

	@GetMapping("/today")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Appointment> getAppointmentsForToday() {
		return appointmentService.findByDate(new Date(System.currentTimeMillis()));
	}

	@GetMapping("/today/{phone}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Appointment> getAppointmentsForTodayForADoctor(@PathVariable("phone") long phone) {
		return appointmentService.findByDate(new Date(System.currentTimeMillis()), phone);
	}
	
	//Search an appointment for a Doctor on a specific day
	@GetMapping("/checkAppointments/{date}/{phone}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Appointment> getAppointmentsForADoctorSpecificDate(@PathVariable Date date, @PathVariable("phone") long phone) {
		return appointmentService.findByDate(date, phone);
	}
	

	@PostMapping("/createAppointment/{flag}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Appointment createAppointment(@RequestBody Appointment appointment, @PathVariable("flag") boolean flag) {
		Appointment app = appointmentService.createAppointment(appointment, flag);
		if (null == app) {
			Appointment appoi = new Appointment();
			appoi.setAppID(0);
			return appoi;
		}
		return app;
	}

	@GetMapping("/check")
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean checkAppointmentValid(@RequestParam long date, @RequestParam Time time,
			@RequestParam String docEmail) {
		return appointmentService.isValidAppointment(new Date(date), time, docEmail);
	}
}
