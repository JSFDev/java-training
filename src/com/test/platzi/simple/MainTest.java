package com.test.platzi.simple;

public class MainTest {
    public static void main(String[] args) {
        DeveloperTest.getThread().start();
        MessageTest.getThread().start();
        SqlUserTest.getThread().start();
    }
}
