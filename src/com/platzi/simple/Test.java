package com.platzi.simple;

import com.platzi.simple.constants.Messages;

import java.util.Calendar;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Test.testPersonClass();
        Test.testMessageClass(args);
        Test.testMessageClassByArgs();
    }

    /**
     * Create a custom message by arguments program entry
     */
    private static void testMessageClassByArgs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Messages.PRINT_SCANNER.getValue());
        String[] args = scanner.nextLine().trim().split(Messages.SPACE_SEPARATOR.getValue());
        scanner.close();
        Message messageScanner = new Message(args);
        messageScanner.setMessageByArguments();
        System.out.println(messageScanner.getOutput());
    }

    private static void testMessageClass(String[] args) {
        try {
            Message message = new Message(args);
            message.setMessageByArguments();
            System.out.println(message.getOutput());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Messages.NOARGSERROR.getValue());
        }
    }

    private static void testPersonClass() {
        Person me = new Person(1.85F, (short) 1300, 19000);
        me.setMyCalendarBirthDate((short) 1985, (byte) Calendar.DECEMBER, (byte) 11);
        me.setMyYearsFromBirthDate();
        me.setMySkillList();
        System.out.println(me.toStringYears());
        System.out.println(me.toStringHeight());
        System.out.println(me.toStringSkills());
    }
}
