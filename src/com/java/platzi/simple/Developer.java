package com.java.platzi.simple;

import com.java.platzi.simple.constants.Messages;
import com.java.platzi.simple.constants.Skills;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Developer extends Person {
    private final String DOCUMENTS_ROUTE = "/home/fernando/htdocs/java-training/src/com/java/platzi/simple";
    private final String DOCUMENT_INFORMATION = "/documents/developersInformation.txt";
    private final File DOCUMENT_FILE = new File(DOCUMENTS_ROUTE + DOCUMENT_INFORMATION);
    final byte ADULT_YEARS = 18;
    final byte RETIREMENT_YEARS = 65;

    private ArrayList<Skills> technicalSkillList;

    public Developer(String name, float height, short monthSalary, ArrayList<Skills> skills) {
        super(name, height, monthSalary);
        this.setTechnicalSkillList(skills);
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

    public void setTechnicalSkillList(ArrayList<Skills> technicalSkillList) {
        this.technicalSkillList = technicalSkillList == null ? Developer.getDefaultSkillList() : technicalSkillList;
    }

    private byte getYearsToRetirement() {
        return getValidateYears(RETIREMENT_YEARS);
    }

    private byte getYearsToBeAdult() {
        return getValidateYears(ADULT_YEARS);
    }

    public String toStringSkills() {
        String message = "";

        for (Skills skill : this.technicalSkillList) {
            message += Messages.PERSONAL_SKILLS.getValue() + skill.getName() + ": " + skill.getValue();
        }

        return message;
    }

    @Override
    protected String toStringFinancialData() {
        String message = super.toStringFinancialData();

        message += this.getYearsToBeAdult() != -1 ? Messages.YEARS_MINOR.getValue() : Messages.EMPTY_STRING.getValue();
        message += Messages.YEARS_RETIREMENT.getValue();
        message += this.getYearsToRetirement() != -1 ? this.getYearsToRetirement() + Messages.YEARS.getValue() : Messages.YEARS_OLDER.getValue();
        return message;
    }

    @Override
    protected String getPersonalData() {
        return Messages.LINE_WRAP_DOCUMENT_SEGMENTS.getValue() +
                super.getPersonalData() +
                this.toStringSkills() +
                this.toStringFinancialData();
    }

    public void printInformationInDocument() {
        try {
            FileWriter document = new FileWriter(DOCUMENT_FILE);
            document.write(this.getPersonalData());
            document.close();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public String readInformationFromDocument() {
        String message = "";
        try {
            String newLine;
            BufferedReader document = new BufferedReader(new FileReader(DOCUMENT_FILE));
            while ((newLine = document.readLine()) != null) {
                message += newLine + Messages.NEW_LINE.getValue();
            }
            document.close();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        return !message.trim().equals(Messages.EMPTY_STRING.getValue()) ? message : Messages.DOCUMENT_EMPTY.getValue();
    }
}
