package com.platzi.simple;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExpressionTest {
    private Thread thread = null;
    private List<MessagePojo> listMessages = Arrays.asList(
            new MessagePojo("Mensaje corto."),
            new MessagePojo("Mensaje realmente largo."),
            new MessagePojo("Mensajillo al usuario."),
            new MessagePojo("Mensaje extremadamente largo para que el usuario lo lea.")
    );
    private Runnable task = () -> {
        System.out.println(this.thread.getName());
        this.shouldOrderMessagesByCompareSize();
        this.shouldOrderMessagesByTextContains();
    };

    public void runTask() {
        thread = new Thread(this.task, "Thread-LambdaExpresions");
        thread.start();
    }

    @Test
    public void shouldOrderMessagesByCompareSize() {
        Comparator<MessagePojo> compareSize = (MessagePojo m1, MessagePojo m2) -> m1.getSize() - m2.getSize();
        this.listMessages.sort(compareSize);
        this.listMessages.forEach(message -> System.out.println(message.getMessage()));
    }

    @Test
    public void shouldOrderMessagesByTextContains() {
        String filterText = "usuario";
        List<MessagePojo> filterList = this.listMessages.stream()
                .filter(message -> message.getMessage().contains(filterText))
                .collect(Collectors.toList());
        filterList.forEach(message -> System.out.println(message.getMessage()));
    }
}
