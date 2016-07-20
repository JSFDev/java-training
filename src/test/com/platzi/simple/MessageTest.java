package test.com.platzi.simple;

import main.com.platzi.simple.Message;
import main.com.platzi.simple.constants.Messages;
import org.junit.Test;

import java.util.Scanner;

public class MessageTest {
    private Thread thread = null;
    private Runnable task = () -> {
        System.out.println(this.thread.getName());
        this.shouldPrintGreetingMessage(LIST_NO_ARGS);
        this.shouldPrintMessageByProgramArguments(LIST_MULTIPLE_ARGS);
        this.shouldPrintMessageByConsoleArguments();
    };
    private static final String[] LIST_NO_ARGS = new String[0];
    private static final String[] LIST_MULTIPLE_ARGS = {"one", "two", "three"};
    private static long sleepThread = Integer.parseInt(Messages.WAIT_THREAD_MILL.getValue());

    public void runTask() {
        thread = new Thread(this.task, "Thread-simple-message");
        thread.start();
    }

    @Test
    private void shouldPrintMessageByConsoleArguments() {
        try {
            Thread.sleep(sleepThread);
            System.out.println(Messages.PRINT_SCANNER.getValue());
            Scanner scanner = new Scanner(System.in);
            String[] args = scanner.nextLine().trim().split(Messages.SPACE_SEPARATOR.getValue());
            scanner.close();
            Message messageScanner = new Message(args);
            messageScanner.setMessageByArguments();
            System.out.println(messageScanner.getOutput());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    private void shouldPrintMessageByProgramArguments(String[] args) {
        try {
            Message message = new Message(args);
            message.setMessageByArguments();
            System.out.println(message.getOutput());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Messages.NOARGSERROR.getValue());
        }
    }

    @Test
    private void shouldPrintGreetingMessage(String[] args) {
        Message message = new Message(args);
        message.setMessageByArguments();
        System.out.println(message.getOutput());
    }
}
