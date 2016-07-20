package test.com.platzi.simple;

import main.com.platzi.simple.MessagePojo;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressionTest {
    private Thread thread = null;
    private Runnable task = () -> {
        System.out.println(this.thread.getName());
        this.shouldOrderMessagesByCompareSize();
    };

    public void runTask() {
        thread = new Thread(this.task, "Thread-LambdaExpresions");
        thread.start();
    }

    @Test
    private void shouldOrderMessagesByCompareSize() {
        Comparator<MessagePojo> compareSize = (MessagePojo m1, MessagePojo m2) -> m1.getSize() - m2.getSize();
        List<MessagePojo> listMessages = Arrays.asList(
                new MessagePojo("Mensaje corto."),
                new MessagePojo("Mensaje realmente largo."),
                new MessagePojo("Mensajillo."),
                new MessagePojo("Mensaje extremadamente largo.")
        );
        listMessages.sort(compareSize);
        listMessages.forEach(message -> System.out.println(message.getMessage()));
    }
}
