package com.Insppiron.proto.Service;

import com.Insppiron.proto.Dto.NotificationDto;
import com.Insppiron.proto.Model.Notification;

public interface NotificationService {
    public void save(NotificationDto notificationDto);

    public Notification getById();

    public void update();

    public void delete();
}
