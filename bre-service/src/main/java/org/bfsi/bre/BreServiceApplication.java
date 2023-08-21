package org.bfsi.bre;

import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BreServiceApplication {

    Logger logger = LogManager.getLogger(BreServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BreServiceApplication.class, args);
    }

    @PostConstruct
    public void logger(){
        logger.info("INFO--->");
        logger.error("ERROR--->");
    }
}