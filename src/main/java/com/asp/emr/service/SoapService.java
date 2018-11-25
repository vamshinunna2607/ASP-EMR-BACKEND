package com.asp.emr.service;

import java.util.List;

import com.asp.emr.model.Soap;

public interface SoapService {

	void addSoapNote(Soap soap);
	
	List<Soap> getSoapNotes(int mrNum);
}
