package test.com.platzi.microservices;

public class UserDataServletTest implements Runnable {
    private static final Thread thread = new Thread(new UserDataServletTest(), "Thread-userdata");

    @Override
    public void run() {

    }

    public static Thread getThread() {
        return UserDataServletTest.thread;
    }
}