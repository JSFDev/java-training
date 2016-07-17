package test.com.platzi.microservices;

import main.com.platzi.microservices.injection.MessagePrinter;
import main.com.platzi.microservices.utils.HappyMessageService;
import main.com.platzi.microservices.utils.SadMessageService;

public class MessageTest implements Runnable {
    private static final Thread thread = new Thread(new MessageTest(), "Thread-microservice-message");

    @Override
    public void run() {
        MessageTest.shouldSetMoodMessageStandalone();
    }

    public static Thread getThread() {
        return MessageTest.thread;
    }

    private static void shouldSetMoodMessageStandalone() {
        MessagePrinter printer = new MessagePrinter(new HappyMessageService());
        printer.printMessage();
        printer.setMessage(new SadMessageService());
        printer.printMessage();
    }
}
