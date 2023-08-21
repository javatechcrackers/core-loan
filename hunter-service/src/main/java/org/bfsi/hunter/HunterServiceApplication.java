package org.bfsi.hunter;

import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class HunterServiceApplication {
    Logger logger = LogManager.getLogger(HunterServiceApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(HunterServiceApplication.class, args);
    }

    @PostConstruct
    public void logger(){
        logger.info("INFO--->");
        logger.error("ERROR--->");
    }
}