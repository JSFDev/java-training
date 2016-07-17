package main.com.platzi.microservices.injection;

import main.com.platzi.microservices.utils.HappyMessageService;
import main.com.platzi.microservices.utils.MessageService;
import main.com.platzi.microservices.utils.SadMessageService;
import main.com.platzi.simple.constants.Messages;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Interfaz de configurecion de dependencias (MessageServices) -> Factoria
 */
@Configuration
@ComponentScan
public class MessagePrinterBean {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            @Override
            public String getMessage() {
                return Messages.UNKNOWN_SERVICE_MESSAGE.getValue();
            }
        };
    }

    @Bean
    MessageService happyMessageService() {
        return new HappyMessageService();
    }

    @Bean
    MessageService sadMessageService() {
        return new SadMessageService();
    }
}
