package com.cttdcds.service;

import com.cttdcds.mapper.CallsMapper;
import com.cttdcds.pojo.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallsServiceImpl implements CallsService {
	private CallsMapper callsMapper;

	@Autowired
	public void setCallsMapper(CallsMapper callsMapper) {
		this.callsMapper = callsMapper;
	}

	@Override
	public List<Call> getCalls() {
		return callsMapper.getCalls();
	}
}
