package com.test.platzi.simple;

import com.java.platzi.simple.Developer;
import com.java.platzi.simple.constants.Skills;

import java.util.ArrayList;
import java.util.Calendar;

public class DeveloperTest implements Runnable {
    private static final String THREAD_NAME = "Thread-developer";
    private static final Thread thread = new Thread(new DeveloperTest(), THREAD_NAME);

    @Override
    public void run() {
        DeveloperTest.shouldInitializeProperties();
    }

    public static Thread getThread() {
        return DeveloperTest.thread;
    }

    private static void shouldInitializeProperties() {
        ArrayList<Skills> myDevSkills = Developer.getDefaultSkillList();
        Developer me = new Developer(1.85F, (short) 1300, myDevSkills);
        me.setMyCalendarBirthDate((short) 1985, (byte) Calendar.DECEMBER, (byte) 11);
        System.out.println(me.toStringYears());
        System.out.println(me.toStringHeight());
        System.out.println(me.toStringSkills());
        System.out.println(me.toStringFinancialData());
    }
}
