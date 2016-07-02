package com.platzi.simple;

import com.platzi.simple.constants.Messages;

import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        Test.testPersonClass(args);
        Test.testMessageClass(args);
    }

    /**
     * Create a custom message by arguments program entry
     */
    private static void testMessageClass(String[] args) {
        try {
            Message message = new Message(args);
            message.setMessageByArguments();
            System.out.print(message.getOutput());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print(Messages.NOARGSERROR.getValue());
        }
    }

    private static void testPersonClass(String[] args) {
        Person me = new Person(1.85F, (short) 1300, 19000);
        me.setMyCalendarBirthDate((short) 1985, (byte) Calendar.DECEMBER, (byte) 11);
        me.setMyYearsFromBirthDate();
        me.setMySkillList();
        System.out.println(me.toStringYears());
        System.out.println(me.toStringHeight());
        System.out.println(me.toStringSkills());
    }
}
