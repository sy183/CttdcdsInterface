package com.cttdcds.controller;


import com.cttdcds.pojo.Call;
import com.cttdcds.pojo.Channel;
import com.cttdcds.pojo.SipRegistration;
import com.cttdcds.service.CallsService;
import com.cttdcds.service.ChannelsService;
import com.cttdcds.service.ConfService;
import com.cttdcds.service.SipRegistrationsService;
import com.cttdcds.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {
    private SipRegistrationsService sipRegistrationsService;
    private CallsService callsService;
    private ChannelsService channelsService;
    private ConfService confService;

    @Autowired
    public void setSipRegistrationsService(SipRegistrationsService sipRegistrationsService) {
        this.sipRegistrationsService = sipRegistrationsService;
    }

    @Autowired
    public void setCallsService(CallsService callsService) {
        this.callsService = callsService;
    }

    @Autowired
    public void setChannelsService(ChannelsService channelsService) {
        this.channelsService = channelsService;
    }

    @Autowired
    public void setDialplanService(ConfService confService) {
        this.confService = confService;
    }

    @GetMapping("/get/cttdcds/sipRegistrations")
    public String getSipRegistrations() {
        List<SipRegistration> sipRegistrations = sipRegistrationsService.getSipRegistrations();
        if (sipRegistrations == null) {
            return "null";
        }
        return GsonUtil.gson.toJson(sipRegistrations);
    }

    @GetMapping("/get/cttdcds/calls")
    public String getCalls() {
        List<Call> calls = callsService.getCalls();
        if (calls == null) {
            return "null";
        }
        return GsonUtil.gson.toJson(calls);
    }

    @GetMapping("/get/cttdcds/channels")
    public String getChannels() {
        List<Channel> channels = channelsService.getChannels();
        if (channels == null) {
            return "null";
        }
        return GsonUtil.gson.toJson(channels);
    }

    @RequestMapping("/get/cttdcds/dialplan")
    public String getDialplan() {
        Map<String, Object> dialplanMap = confService.getDialplanMap();
        if (dialplanMap == null) {
            return "null";
        }
        return GsonUtil.gson.toJson(dialplanMap);
    }

    @RequestMapping("/get/cttdcds/chatplan")
    public String getChatplan() {
        Map<String, Object> chatplanMap = confService.getChatplanMap();
        if (chatplanMap == null) {
            return "null";
        }
        return GsonUtil.gson.toJson(chatplanMap);
    }

    @RequestMapping("/get/cttdcds/directory")
    public String getDirectory() {
        Map<String, Object> directoryMap = confService.getDirectoryMap();
        if (directoryMap == null) {
            return "null";
        }
        return GsonUtil.gson.toJson(directoryMap);
    }

}
