package com.cttdcds.mapper;

import com.cttdcds.config.DaoConfig;
import com.cttdcds.pojo.SipRegistration;
import com.cttdcds.util.GsonUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SipRegistrationsMapperTest {
	@Test
	public void test() {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class);
		SipRegistrationsMapper mapper = (SipRegistrationsMapper) context.getBean("sipRegistrationsMapper");
		List<SipRegistration> sipRegistrations = mapper.getSipRegistrations();
//		sipRegistrations.forEach(sipRegistration -> System.out.println(sipRegistration.getContact()));
//		System.out.println(GsonUtil.gson.toJson(sipRegistrations));
	}
}
