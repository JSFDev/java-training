package com.platzi.simple;

import com.platzi.simple.constants.Skills;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

public class DeveloperTest {
    private Thread thread = null;
    private Runnable task = () -> {
        System.out.println(this.thread.getName());
        this.shouldInitializeProperties();
    };

    public void runTask() {
        thread = new Thread(this.task, "Thread-developer");
        thread.start();
    }

    @Test
    public void shouldInitializeProperties() {
        ArrayList<Skills> myDevSkills = Developer.getDefaultSkillList();
        Developer emilio = new Developer("Emilio Sanchez", 1.85F, (short) 1300, myDevSkills);
        emilio.setMyCalendarBirthDate((short) 1985, (byte) Calendar.DECEMBER, (byte) 11);
        emilio.printInformationInDocument();
        System.out.println(emilio.readInformationFromDocument());
    }
}
