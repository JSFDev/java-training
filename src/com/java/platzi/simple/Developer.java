package com.java.platzi.simple;

import com.java.platzi.simple.constants.Skills;

import java.util.ArrayList;

public class Developer extends Person {

    private short monthSalary;
    private int yearSalary;
    private ArrayList<Skills> tecnicalSkillList;

    public Developer(float height, short monthSalary, int yearSalary, ArrayList<Skills> skills) {
        super(height);
        this.monthSalary = monthSalary;
        this.yearSalary = yearSalary;
        this.setTecnicalSkillList(skills);
    }

    public static ArrayList<Skills> getDefaultSkillList() {
        ArrayList<Skills> skills = new ArrayList<>();
        skills.add(Skills.FRONT);
        skills.add(Skills.BACK);
        skills.add(Skills.DB);
        return skills;
    }

    private byte getValidateYears(byte yearValidation) {
        byte validYears = (byte) (yearValidation - super.getYears());
        return validYears <= 0 ? -1 : validYears;
    }

    public void setTecnicalSkillList(ArrayList<Skills> tecnicalSkillList) {
        this.tecnicalSkillList = tecnicalSkillList == null ? Developer.getDefaultSkillList() : tecnicalSkillList;
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

    public String toStringSkills() {
        String message = "";

        for (Skills skill : this.tecnicalSkillList) {
            message += "\nPersonal skill " + skill.getName() + ": " + skill.getValue();
        }

        return message;
    }
}
