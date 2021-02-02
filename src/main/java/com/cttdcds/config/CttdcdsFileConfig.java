package com.cttdcds.config;

import com.cttdcds.file.XmlHandler;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.File;

@Configuration
@ComponentScan("com.cttdcds.file")
@PropertySource("classpath:file.properties")
public class CttdcdsFileConfig {

	@Value("${cttdcds.file.xml}")
	private String xmlPath;

	@Bean
	public XmlHandler xmlHandler() {
		XmlHandler xmlHandler = null;
		try {
			xmlHandler = new XmlHandler(new File(xmlPath));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return xmlHandler;
	}

}
