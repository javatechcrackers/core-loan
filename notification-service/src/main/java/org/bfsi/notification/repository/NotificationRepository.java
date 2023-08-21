package org.bfsi.notification.repository;

import org.bfsi.notification.Entity.NotificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<NotificationEntity, String> {
}
