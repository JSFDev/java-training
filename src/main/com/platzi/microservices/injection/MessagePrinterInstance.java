package main.com.platzi.microservices.injection;

import main.com.platzi.microservices.utils.MessageService;

public class MessagePrinterInstance extends MessagePrinter {
    public MessagePrinterInstance(MessageService message) {
        super(message);
    }

    public void setMessage(MessageService message) {
        super.setMessage(message);
    }
}
