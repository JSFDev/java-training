package main.com.platzi.microservices.injection;

import main.com.platzi.microservices.utils.MessageService;

public class MessagePrinterInstance {
    /**
     * NOTE: message is not really dependency, this should be a singleton (private final)
     */
    private MessageService message;

    public MessagePrinterInstance(MessageService message) {
        this.setMessage(message);
    }

    public void setMessage(MessageService message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(this.message.getMessage());
    }
}
