package org.bfsi.orchestration;

import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class OrchestrationServiceApplication {

    Logger logger = LogManager.getLogger(OrchestrationServiceApplication.class);

    @Autowired
    Environment env;

    public static void main(String[] args) {
        SpringApplication.run(OrchestrationServiceApplication.class, args);
    }

    @PostConstruct
    public void logger(){
        logger.info("INFO--->" + env.getProperty("spring.application.name"));
        logger.info("INFO--->");
        logger.error("ERROR--->");

    }
}