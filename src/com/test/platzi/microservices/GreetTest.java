package com.test.platzi.microservices;

public class GreetTest implements Runnable {
    private static final Thread thread = new Thread(new GreetTest(), "Thread-greet");

    @Override
    public void run() {

    }

    public static Thread getThread() {
        return GreetTest.thread;
    }
}