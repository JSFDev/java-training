package com.platzi.simple;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

/**
 * Simple object
 */
public class Person {
    public final byte ADULT_YEARS = 18;
    public final byte RETIREMENT_YEARS = 65;

    private Calendar birthDate;
    private byte years;
    private float height;
    private short monthSalary;
    private int yearSalary;

    public Person(Calendar birthDate, float height, short monthSalary, int yearSalary) {
        this.birthDate = birthDate;
        this.years = getYearsFromBirthDate();
        this.height = height;
        this.monthSalary = monthSalary;
        this.yearSalary = yearSalary;
    }

    public static void main(String[] args) {
        Person me = new Person(getMyCalendarDate(), 1.85F, (short) 1300, 19000);
        System.out.print(me.getYears());
    }

    private static Calendar getMyCalendarDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1985);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 11);
        return cal;
    }

    public byte getYears() {
        return this.years;
    }

    private byte getYearsFromBirthDate() {
        LocalDate birthDay = LocalDate.of(this.birthDate.get(Calendar.YEAR), this.birthDate.get(Calendar.MONTH), this.birthDate.get(Calendar.DAY_OF_MONTH));
        return (byte) birthDay.until(LocalDate.now(), ChronoUnit.YEARS);
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

    private byte getValidateYears(byte yearValidation) {
        byte validYears = (byte) (yearValidation - this.years);
        return validYears <= 0 ? -1 : validYears;
    }
}
