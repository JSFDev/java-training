package main.com.platzi.microservices.injection;

import main.com.platzi.microservices.utils.HappyMessageService;
import main.com.platzi.microservices.utils.MessageService;
import main.com.platzi.microservices.utils.SadMessageService;
import main.com.platzi.simple.constants.Messages;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Interfaz de configurecion de dependencias (MessageServices) -> Factoria
 */
@Configuration
@ComponentScan(basePackages = "main.com.platzi.microservices.injection")
public class MessagePrinterBean {

    @Bean(name = "mockMessageService")
    MessageService mockMessageService() {
        return new MessageService() {
            @Override
            public String getMessage() {
                return Messages.UNKNOWN_SERVICE_MESSAGE.getValue();
            }
        };
    }

    @Bean(name = "mockMessageServiceLambda")
    MessageService mockMessageServiceLambda() {
        return Messages.UNKNOWN_SERVICE_MESSAGE::getValue;
    }

    @Bean(name = "happyMessageService")
    @Primary
    MessageService happyMessageService() {
        return new HappyMessageService();
    }

    @Bean(name = "sadMessageService")
    MessageService sadMessageService() {
        return new SadMessageService();
    }
}
