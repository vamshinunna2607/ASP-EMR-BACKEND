package com.asp.emr.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
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

	@GetMapping("/today")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Appointment> getAppointmentsForToday() {
		return appointmentService.findByDate(new Date(System.currentTimeMillis()));
	}

	@PostMapping("/createAppointment")
	@CrossOrigin(origins = "http://localhost:4200")
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		return appointmentService.createAppointment(appointment);
	}

	@GetMapping("check")
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean checkAppointmentValid(@RequestParam long date, @RequestParam Time time,
			@RequestParam String docEmail) {
		return appointmentService.isValidAppointment(new Date(date), time, docEmail);
	}
}
