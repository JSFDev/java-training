package com.test.platzi.simple;

import com.java.platzi.simple.Developer;
import com.java.platzi.simple.Message;
import com.java.platzi.simple.constants.Messages;
import com.java.platzi.simple.constants.Skills;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Test {
    private static final String[] LIST_NO_ARGS = new String[0];
    private static final String[] LIST_MULTIPLE_ARGS = {"one", "two", "three"};

    public static void main(String[] args) {
        Test.shouldHavePersonProperties();
        Test.shouldPrintGreetingMessage(LIST_NO_ARGS);
        Test.shouldPrintMessageByProgramArguments(LIST_MULTIPLE_ARGS);
        Test.shouldPrintMessageByConsoleArguments();
    }

    private static void shouldPrintMessageByConsoleArguments() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Messages.PRINT_SCANNER.getValue());
        String[] args = scanner.nextLine().trim().split(Messages.SPACE_SEPARATOR.getValue());
        scanner.close();
        Message messageScanner = new Message(args);
        messageScanner.setMessageByArguments();
        System.out.println(messageScanner.getOutput());
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

    private static void shouldHavePersonProperties() {
        ArrayList<Skills> myDevSkills = Developer.getDefaultSkillList();
        Developer me = new Developer(1.85F, (short) 1300, myDevSkills);
        me.setMyCalendarBirthDate((short) 1985, (byte) Calendar.DECEMBER, (byte) 11);
        System.out.println(me.toStringYears());
        System.out.println(me.toStringHeight());
        System.out.println(me.toStringSkills());
        System.out.println(me.toStringFinancialData());
    }
}
