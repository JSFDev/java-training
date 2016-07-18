package test.com.platzi.microservices;

import main.com.platzi.simple.UserPojo;
import test.com.Test;

public class RestTest implements Runnable {
    private static final Thread thread = new Thread(new RestTest(), "Thread-microservice-rest");
    private UserPojo mockUserPojo = this.getMockUserPojo();

    private UserPojo getMockUserPojo() {
        return null;
    }

    @Override
    public void run() {
        System.out.println(RestTest.getThread().getName());
        this.shouldGetUserPojo();
    }

    public static Thread getThread() {
        return RestTest.thread;
    }

    @Test
    private void shouldGetUserPojo() {

    }
}
