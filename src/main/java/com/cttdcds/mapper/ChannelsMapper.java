package com.cttdcds.mapper;

import com.cttdcds.pojo.Channel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelsMapper {
	List<Channel> getChannels();
}
