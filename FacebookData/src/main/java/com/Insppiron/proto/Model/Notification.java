package com.Insppiron.proto.Model;

import com.fasterxml.jackson.databind.DatabindException;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "GovtNotification")
public class Notification {
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
}
