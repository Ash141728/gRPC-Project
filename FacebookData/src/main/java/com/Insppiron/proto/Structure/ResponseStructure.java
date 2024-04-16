package com.Insppiron.proto.Structure;

import com.Insppiron.proto.Model.Notification;

public class ResponseStructure {
    private String message;
    private Notification data;
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Notification getData() {
        return data;
    }

    public void setData(Notification data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
