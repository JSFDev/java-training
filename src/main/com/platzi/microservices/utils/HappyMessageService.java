package com.platzi.microservices.utils;

import com.platzi.simple.constants.Messages;

public class HappyMessageService implements MessageService {
    private static final Messages message = Messages.HAPPY_SERVICE_MESSAGE;

    @Override
    public String getMessage() {
        return message.getValue();
    }
}
