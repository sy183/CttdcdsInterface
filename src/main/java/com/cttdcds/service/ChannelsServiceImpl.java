package com.cttdcds.service;

import com.cttdcds.mapper.ChannelsMapper;
import com.cttdcds.pojo.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelsServiceImpl implements ChannelsService {
	private ChannelsMapper channelsMapper;

	@Autowired
	public void setChannelsMapper(ChannelsMapper channelsMapper) {
		this.channelsMapper = channelsMapper;
	}

	@Override
	public List<Channel> getChannels() {
		return channelsMapper.getChannels();
	}
}
