package com.asp.emr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asp.emr.model.Soap;
import com.asp.emr.service.SoapService;

@RestController
@RequestMapping("soap")
public class SoapController {

	@Autowired
	private SoapService soapService;

	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public void addSoapNote(@RequestBody Soap soapNote) {
		soapService.addSoapNote(soapNote);
	}
	
	@GetMapping("{mrNum}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Soap> getSoapNote(@PathVariable int mrNum) {
		return soapService.getSoapNotes(mrNum)
;	}
}
