package com.cttdcds.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Call {
	private String callUuid;
	private String callCreated;
	private String callCreatedEpoch;
	private String callerUuid;
	private String calleeUuid;
	private String hostname;
}
