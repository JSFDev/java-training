package com.java.platzi.simple;

import com.java.platzi.simple.constants.Messages;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Person {
    private final String METRIC_SYSTEM = Messages.METERS.getValue();

    private Calendar birthDate;
    private byte year;
    private float height;
    private short monthSalary;

    public Person(float height, short monthSalary) {
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
        String message = "Personal stature: " + String.valueOf((int) this.height) + METRIC_SYSTEM;

        if (this.height % 1 != 0) {
            message += ", exactly: " + String.valueOf(this.height) + METRIC_SYSTEM;
        }

        return message;
    }

    public String toStringFinancialData() {
        return "Monthly salary: " + this.getMonthSalary();
    }

    public String toStringYears() {
        return "Personal years: " + this.getYears();
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public void setYear(byte year) {
        this.year = year;
    }

    public short getMonthSalary() {
        return monthSalary;
    }
}
