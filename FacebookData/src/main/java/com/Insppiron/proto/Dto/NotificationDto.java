package com.Insppiron.proto.Dto;

import com.Insppiron.proto.Model.PayLoadObject;

public class NotificationDto {
    private int notificationId;
    private PayLoadObject payLoadObject;
    private String createdOn;

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public PayLoadObject getPayLoadObject() {
        return payLoadObject;
    }

    public void setPayLoadObject(PayLoadObject payLoadObject) {
        this.payLoadObject = payLoadObject;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "NotificationDto{" +
                "notificationId=" + notificationId +
                ", payLoadObject=" + payLoadObject +
                ", createdOn='" + createdOn + '\'' +
                '}';
    }
}
