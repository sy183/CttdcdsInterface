package com.cttdcds.mapper;

import com.cttdcds.pojo.Call;
import com.cttdcds.pojo.SipRegistration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SipRegistrationsMapper {
	List<SipRegistration> getSipRegistrations();
}
