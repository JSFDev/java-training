package com.platzi.microservices.injection;

import com.platzi.microservices.utils.MessageService;

public class MessagePrinter {
    private MessageService message;

    public MessagePrinter(MessageService message) {
        this.message = message;
    }

    public void setMessage(MessageService message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(this.message.getMessage());
    }
}
