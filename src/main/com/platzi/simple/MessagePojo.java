package com.platzi.simple;

public class MessagePojo {
    private String message;
    private int size;

    public MessagePojo(String message) {
        this.message = message;
        this.size = message.length();
    }

    public MessagePojo() {
    }

    public String getMessage() {
        return this.message;
    }

    public int getSize() {
        return this.size;
    }
}
