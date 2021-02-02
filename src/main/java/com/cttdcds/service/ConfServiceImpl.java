package com.cttdcds.service;

import com.cttdcds.file.XmlHandler;
import com.cttdcds.util.XmlUtil;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConfServiceImpl implements ConfService {
	private XmlHandler xmlHandler;

	@Autowired
	public void setXmlHandler(XmlHandler xmlHandler) {
		this.xmlHandler = xmlHandler;
	}

	@Override
	public Map<String, Object> getDialplanMap() {
		Element dialplan = xmlHandler.getSection("dialplan");
		return XmlUtil.xmlToMap(dialplan);
	}

	@Override
	public Map<String, Object> getChatplanMap() {
		Element chatplan = xmlHandler.getSection("chatplan");
		return XmlUtil.xmlToMap(chatplan);
	}

	@Override
	public Map<String, Object> getDirectoryMap() {
		Element directory = xmlHandler.getSection("directory");
		return XmlUtil.xmlToMap(directory);
	}
}
