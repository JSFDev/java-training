package com.platzi.microservices;

import com.platzi.microservices.injection.MessagePrinter;
import com.platzi.microservices.injection.MessagePrinterBean;
import com.platzi.microservices.injection.MessagePrinterComponent;
import com.platzi.microservices.injection.MessagePrinterInstance;
import com.platzi.microservices.utils.HappyMessageService;
import com.platzi.microservices.utils.SadMessageService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * this.printer, es una dependencia de esta clase CDITest, es un singleton,
 */
public class CDITest {
    private Thread thread = null;
    private Runnable task = () -> {
        System.out.println(this.thread.getName());
        this.shouldSetMoodMessageByInstance();
        this.shouldSetMoodMessageByBean();
    };
    private static MessagePrinter printer = null;

    public void runTask() {
        thread = new Thread(this.task, "Thread-microservice-cdi");
        thread.start();
    }

    @Test
    public void shouldSetMoodMessageByInstance() {
        printer = new MessagePrinterInstance(new HappyMessageService());
        printer.printMessage();
        printer.setMessage(new SadMessageService());
        printer.printMessage();
    }

    @Test
    public void shouldSetMoodMessageByBean() {
        // factoria de Beans, del Tipo de la dependencia a injectar: MessagePrinter printer
        ApplicationContext printerFactory = new AnnotationConfigApplicationContext(MessagePrinterBean.class);
        // Componente/controlador que injecta la dependencia dada por la factoria de Beans
        printer = printerFactory.getBean(MessagePrinterComponent.class);
        printer.printMessage();
    }
}
