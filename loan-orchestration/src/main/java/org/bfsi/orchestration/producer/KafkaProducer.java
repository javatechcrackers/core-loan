package org.bfsi.orchestration.producer;

import org.bfsi.orchestration.bean.NotificationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, NotificationEntity> kafkaTemplateNew;


    public void sendMessage(String msg) {
        logger.info("Going to Produced Kafka Msg: " + msg);
        logger.info("Topic name - " + topicName);
        kafkaTemplate.send(topicName, msg);
    }

    public void sendMessageToNotification(NotificationEntity msg) {

        logger.info("Going to Produced Kafka Msg to notification: " + msg.toString());
        logger.info("Topic name - " + topicName);
        kafkaTemplateNew.send(topicName, msg);
        logger.info("Message sent....");
    }

}
