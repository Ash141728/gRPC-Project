package com.Insppiron.proto.Repository;

import com.Insppiron.proto.Model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification,Integer> {
}
