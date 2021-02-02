package com.cttdcds.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
	private String uuid;
	private String direction;
	private String created;
	private String createdEpoch;
	private String name;
	private String state;
	private String cidName;
	private String cidNum;
	private String ipAddr;
	private String dest;
	private String application;
	private String applicationData;
	private String dialplan;
	private String context;
	private String readCodec;
	private String readRate;
	private String readBitRate;
	private String writeCodec;
	private String writeRate;
	private String writeBitRate;
	private String secure;
	private String hostname;
	private String presenceId;
	private String presenceData;
	private String accountcode;
	private String callstate;
	private String calleeName;
	private String calleeNum;
	private String calleeDirection;
	private String callUuid;
	private String sentCalleeName;
	private String sentCalleeNum;
	private String initialCidName;
	private String initialCidNum;
	private String initialIpAddr;
	private String initialDest;
	private String initialDialplan;
	private String initialContext;
}
