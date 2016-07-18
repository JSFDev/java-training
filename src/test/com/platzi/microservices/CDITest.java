package test.com.platzi.microservices;

import main.com.platzi.microservices.injection.MessagePrinter;
import main.com.platzi.microservices.injection.MessagePrinterBean;
import main.com.platzi.microservices.injection.MessagePrinterComponent;
import main.com.platzi.microservices.injection.MessagePrinterInstance;
import main.com.platzi.microservices.utils.HappyMessageService;
import main.com.platzi.microservices.utils.SadMessageService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * this.printer, es una dependencia de esta clase CDITest, es un singleton,
 */
public class CDITest implements Runnable {
    private static final Thread thread = new Thread(new CDITest(), "Thread-microservice-cdi");
    private static MessagePrinter printer = null;

    @Override
    public void run() {
        System.out.println(CDITest.getThread().getName());
        this.shouldSetMoodMessageByInstance();
        this.shouldSetMoodMessageByBean();
    }

    public static Thread getThread() {
        return CDITest.thread;
    }

    @Test
    private void shouldSetMoodMessageByInstance() {
        printer = new MessagePrinterInstance(new HappyMessageService());
        printer.printMessage();
        printer.setMessage(new SadMessageService());
        printer.printMessage();
    }

    @Test
    private void shouldSetMoodMessageByBean() {
        ApplicationContext printerContext = new AnnotationConfigApplicationContext(MessagePrinterBean.class);
        printer = printerContext.getBean(MessagePrinterComponent.class);
        printer.printMessage();
    }
}
