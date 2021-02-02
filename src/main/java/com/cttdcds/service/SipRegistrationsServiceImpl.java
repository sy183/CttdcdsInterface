package com.cttdcds.service;

import com.cttdcds.mapper.SipRegistrationsMapper;
import com.cttdcds.pojo.SipRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SipRegistrationsServiceImpl implements SipRegistrationsService {
	private SipRegistrationsMapper sipRegistrationsMapper;

	@Autowired
	public void setSipRegistrationsMapper(SipRegistrationsMapper sipRegistrationsMapper) {
		this.sipRegistrationsMapper = sipRegistrationsMapper;
	}

	@Override
	public List<SipRegistration> getSipRegistrations() {
		return sipRegistrationsMapper.getSipRegistrations();
	}
}
