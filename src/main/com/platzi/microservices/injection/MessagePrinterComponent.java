package main.com.platzi.microservices.injection;

import main.com.platzi.microservices.utils.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Componente de logica de negocio, tiene una dependencia singleton (message) que se maneja con Beans.
 */
@Component
public class MessagePrinterComponent {
    private final MessageService message;

    @Autowired
    public MessagePrinterComponent(MessageService message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(this.message.getMessage());
    }
}
