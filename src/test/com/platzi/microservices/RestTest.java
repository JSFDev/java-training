package test.com.platzi.microservices;

public class RestTest implements Runnable {
    private static final Thread thread = new Thread(new RestTest(), "Thread-microservice-rest");

    @Override
    public void run() {
        System.out.println(RestTest.getThread().getName());
    }

    public static Thread getThread() {
        return RestTest.thread;
    }
}
