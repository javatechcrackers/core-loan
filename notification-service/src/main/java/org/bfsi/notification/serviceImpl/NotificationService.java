package org.bfsi.notification.serviceImpl;

import org.bfsi.notification.Entity.NotificationEntity;
import org.bfsi.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public NotificationEntity createNotification(NotificationEntity notificationEntity){
        return notificationRepository.save(notificationEntity);
    }

}
