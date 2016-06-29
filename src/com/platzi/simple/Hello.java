package com.platzi.simple;

public class Hello {
    private boolean isReady = false;
    private static final String YO = "buddy";
    private static final String WORLD = "world";

    public static void main(String[] args){
        // this.isReady = true;

        String hello = "";
        try {
            hello += "Number arguments: " + args.length;
            hello += "\nFirst argument: " + args[0];

        } catch (ArrayIndexOutOfBoundsException e) {
            hello = "There is no console arguments.";
        }

        System.out.println(hello);

        // System.out.println(this.sayHello());
    }

    private String sayHello() {
        String text = "Hello ";

        text += (this.isReady) ? YO : WORLD;
        return text;
    }
}
