package com.media.server.helpers;

public class MessageWrapper {
    private String message;
    private Object object;

    public MessageWrapper(String message) {
        this.message = message;
    }

    public MessageWrapper(String message, Object object) {
        this.message = message;
        this.object = object;
    }

    public MessageWrapper(Object object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
