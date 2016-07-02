package com.platzi.simple;

/**
 * Simple object
 */
public class Person {
    public final byte ADULT_YEARS = 18;
    public final byte RETIREMENT_YEARS = 65;

    private byte years;
    private byte height;
    private short monthSalary;
    private int yearSalary;

    public Person(byte years, byte height, short monthSalary, int yearSalary) {
        this.years = years;
        this.height = height;
        this.monthSalary = monthSalary;
        this.yearSalary = yearSalary;
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
