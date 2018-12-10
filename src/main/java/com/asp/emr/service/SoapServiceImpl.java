package com.asp.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asp.emr.model.Soap;
import com.asp.emr.repository.SoapRepository;

@Component
public class SoapServiceImpl implements SoapService {

	@Autowired
	private SoapRepository soapRepo;

	@Override
	public void addSoapNote(Soap soap) {
		this.soapRepo.save(soap);
	}

	public List<Soap> getSoapNotes(int mrNum) {
		return soapRepo.findByMrNum(mrNum);
	}

	@Override
	public List<Soap> getSoapNotes(long phone) {
		return soapRepo.findSoapByPhone(phone);
	}

}
