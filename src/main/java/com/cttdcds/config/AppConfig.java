package com.cttdcds.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({DaoConfig.class, MvcConfig.class, CttdcdsFileConfig.class})
@ComponentScan("com.cttdcds")
@EnableTransactionManagement
public class AppConfig {
}
