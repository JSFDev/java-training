package com.java.platzi.simple;

import com.java.platzi.simple.constants.Messages;
import com.java.platzi.simple.constants.Skills;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

public class Person {

    public final byte ADULT_YEARS = 18;
    public final byte RETIREMENT_YEARS = 65;
    public final String METRIC_SYSTEM = Messages.METERS.getValue();

    private Calendar birthDate;
    private byte year;
    private float height;
    private short monthSalary;
    private int yearSalary;
    private ArrayList<Skills> tecnicalSkillList;

    public Person(float height, short monthSalary, int yearSalary) {
        this.height = height;
        this.monthSalary = monthSalary;
        this.yearSalary = yearSalary;
    }

    public void setMySkillList() {
        ArrayList<Skills> skills = new ArrayList<>();
        skills.add(Skills.FRONT);
        skills.add(Skills.BACK);
        skills.add(Skills.DB);
        this.setTecnicalSkillList(skills);
    }

    public void setMyCalendarBirthDate(short year, byte month, byte day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        this.setBirthDate(cal);
    }

    public byte getYears() {
        return this.year;
    }

    public void setMyYearsFromBirthDate() {
        LocalDate birthDay = LocalDate.of(this.birthDate.get(Calendar.YEAR), this.birthDate.get(Calendar.MONTH), this.birthDate.get(Calendar.DAY_OF_MONTH));
        this.setYear((byte) birthDay.until(LocalDate.now(), ChronoUnit.YEARS));
    }

    public byte getYearsToRetirement() {
        return getValidateYears(RETIREMENT_YEARS);
    }

    public byte getYearsToBeAdult() {
        return getValidateYears(ADULT_YEARS);
    }

    public byte getYearsOfWorkQuote() {
        return RETIREMENT_YEARS - ADULT_YEARS;
    }

    public String toStringHeight() {
        String message = "Personal stature: " + String.valueOf((int) this.height) + " " + METRIC_SYSTEM;

        if (this.height % 1 != 0) {
            message += ", exactly: " + String.valueOf(this.height) + " " + METRIC_SYSTEM;
        }

        return message;
    }

    public String toStringYears() {
        return "Personal years: " + this.getYears();
    }

    public String toStringSkills() {
        String message = "";

        for (Skills skill : this.tecnicalSkillList) {
            message += "\nPersonal skill " + skill.getName() + ": " + skill.getValue();
        }

        return message;
    }


    private byte getValidateYears(byte yearValidation) {
        byte validYears = (byte) (yearValidation - this.year);
        return validYears <= 0 ? -1 : validYears;
    }

    public void setTecnicalSkillList(ArrayList<Skills> tecnicalSkillList) {
        this.tecnicalSkillList = tecnicalSkillList;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public void setYear(byte year) {
        this.year = year;
    }
}
