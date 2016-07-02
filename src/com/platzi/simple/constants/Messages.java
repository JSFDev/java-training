package com.platzi.simple.constants;

public enum Messages {
    NOARGSERROR("There is no console arguments."),
    TITLENUMARGS("The Number of input arguments: "),
    ARGS(" argument: "),
    FIRST("\nFirst"),
    GREETNAME("Hello buddy."),
    METERS("meters"),
    GREETWORLD("Hello world.");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String getValue() {
        return this.message;
    }

    public static Messages getRandomGreet() {
        return Math.random() < 0.5 ? GREETNAME : GREETWORLD;
    }

    public void printAllMessages() {
        for (Messages message : Messages.values()) {
            System.out.println(message + ": " + message.getValue());
        }
    }
}
