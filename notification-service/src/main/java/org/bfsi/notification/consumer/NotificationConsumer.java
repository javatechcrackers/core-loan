package org.bfsi.notification.consumer;

import com.google.gson.Gson;
import org.bfsi.notification.Entity.NotificationEntity;
import org.bfsi.notification.serviceImpl.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationConsumer {

    Logger logger = LoggerFactory.getLogger(NotificationConsumer.class);

    @Autowired
    NotificationService notificationService;

    @KafkaListener(
            topics = "${spring.kafka.topic.name1}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumer(String msg) {
        logger.info("Message Consumed Success: " + msg);
        org.bfsi.notification.Entity.NotificationEntity entity =
                new Gson().fromJson(msg, org.bfsi.notification.Entity.NotificationEntity.class);
        Optional<String> name = Optional.ofNullable(entity.getFirstName());
        if(name.isPresent()) {
            logger.info("Message Consumed Success after: " + entity.getFirstName());
            notificationService.createNotification(entity);
        }
        logger.info("Message processed Successfully..." );
    }
}
