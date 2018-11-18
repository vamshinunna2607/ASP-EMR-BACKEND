package com.asp.emr.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asp.emr.model.Appointment;
import com.asp.emr.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;
	
	@GetMapping("/appointment/{appID}")
	public Appointment findAppointment(@PathVariable("appID") int id) {
		return appointmentService.findAppointment(id);
	}
	
	@GetMapping("/appointment/date/{appDate}")
	public List<Appointment> findByDate(@PathVariable("appDate") Date date) {
		return appointmentService.findByDate(date);
	}
}
