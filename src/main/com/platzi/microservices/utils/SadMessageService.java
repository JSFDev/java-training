package main.com.platzi.microservices.utils;

import main.com.platzi.simple.constants.Messages;

public class SadMessageService implements MessageService {
    private static final Messages message = Messages.SAD_SERVICE_MESSAGE;

    @Override
    public String getMessage() {
        return message.getValue();
    }
}
