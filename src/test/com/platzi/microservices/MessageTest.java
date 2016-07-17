package test.com.platzi.microservices;

import main.com.platzi.microservices.injection.MessagePrinterBean;
import main.com.platzi.microservices.injection.MessagePrinterComponent;
import main.com.platzi.microservices.injection.MessagePrinterInstance;
import main.com.platzi.microservices.utils.HappyMessageService;
import main.com.platzi.microservices.utils.SadMessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageTest implements Runnable {
    private static final Thread thread = new Thread(new MessageTest(), "Thread-microservice-message");

    @Override
    public void run() {
        System.out.println(MessageTest.getThread().getName());
        MessageTest.shouldSetMoodMessageByInstance();
        MessageTest.shouldSetMoodMessageByBean();
    }

    public static Thread getThread() {
        return MessageTest.thread;
    }

    private static void shouldSetMoodMessageByInstance() {
        MessagePrinterInstance printer = new MessagePrinterInstance(new HappyMessageService());
        printer.printMessage();
        printer.setMessage(new SadMessageService());
        printer.printMessage();
    }

    private static void shouldSetMoodMessageByBean() {
        ApplicationContext printerContext = new AnnotationConfigApplicationContext(MessagePrinterBean.class);
        MessagePrinterComponent printer = printerContext.getBean(MessagePrinterComponent.class);
        printer.printMessage();
    }
}
