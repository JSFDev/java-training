package main.com.platzi.microservices.injection;

import main.com.platzi.microservices.utils.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinterComponent extends MessagePrinter {

    @Autowired
    public MessagePrinterComponent(@Qualifier("mockMessageService") MessageService message) {
        super(message);
    }
}
