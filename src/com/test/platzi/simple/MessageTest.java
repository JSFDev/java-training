package com.test.platzi.simple;

import com.java.platzi.simple.Message;
import com.java.platzi.simple.constants.Messages;

import java.util.Scanner;

public class MessageTest implements Runnable {
    private static final String THREAD_NAME = "Thread-message";
    private static final Thread thread = new Thread(new MessageTest(), THREAD_NAME);

    private static final String[] LIST_NO_ARGS = new String[0];
    private static final String[] LIST_MULTIPLE_ARGS = {"one", "two", "three"};
    private static long sleepThread = Integer.parseInt(Messages.WAIT_THREAD_MILL.getValue());

    @Override
    public void run() {
        MessageTest.shouldPrintGreetingMessage(LIST_NO_ARGS);
        MessageTest.shouldPrintMessageByProgramArguments(LIST_MULTIPLE_ARGS);
        MessageTest.shouldPrintMessageByConsoleArguments();
    }

    public static Thread getThread() {
        return MessageTest.thread;
    }

    private static void shouldPrintMessageByConsoleArguments() {
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

    private static void shouldPrintMessageByProgramArguments(String[] args) {
        try {
            Message message = new Message(args);
            message.setMessageByArguments();
            System.out.println(message.getOutput());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Messages.NOARGSERROR.getValue());
        }
    }

    private static void shouldPrintGreetingMessage(String[] args) {
        Message message = new Message(args);
        message.setMessageByArguments();
        System.out.println(message.getOutput());
    }
}