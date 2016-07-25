package com.platzi.simple;

import com.platzi.simple.constants.Messages;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Person {
    private final String METRIC_SYSTEM = Messages.METERS.getValue();

    private Calendar birthDate;
    private byte year;
    private float height;
    private short monthSalary;
    private String name;

    public Person(String name, float height, short monthSalary) {
        this.name = name;
        this.height = height;
        this.monthSalary = monthSalary;
    }

    public void setMyCalendarBirthDate(short year, byte month, byte day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        this.setBirthDate(cal);
        this.setMyYearsFromBirthDate();
    }

    protected byte getYears() {
        return this.year;
    }

    private void setMyYearsFromBirthDate() {
        LocalDate birthDay = LocalDate.of(this.birthDate.get(Calendar.YEAR), this.birthDate.get(Calendar.MONTH), this.birthDate.get(Calendar.DAY_OF_MONTH));
        this.setYear((byte) birthDay.until(LocalDate.now(), ChronoUnit.YEARS));
    }

    public String toStringHeight() {
        String height = String.valueOf((int) this.height) + METRIC_SYSTEM;
        String message = Messages.PERSONAL_STATURE.getValue() + height;

        if (this.height % 1 != 0) {
            message += Messages.PERSONAL_STATURE_FIX.getValue() + height;
        }

        return message;
    }

    protected String getPersonalData() {
        return this.toStringTitle() +
                this.toStringYears() +
                this.toStringHeight();
    }

    protected String toStringFinancialData() {
        return Messages.PERSONAL_SALARY.getValue() + this.getMonthSalary();
    }

    private String toStringTitle() {
        return Messages.DEVELOPER_TITLE.getValue() + this.getName();
    }

    public String toStringYears() {
        return Messages.PERSONAL_YEARS.getValue() + this.getYears();
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public void setYear(byte year) {
        this.year = year;
    }

    public short getMonthSalary() {
        return this.monthSalary;
    }

    public String getName() {
        return this.name;
    }
}
