package com.java.platzi.simple.constants;

public enum Messages {
    NOARGSERROR("There is no console arguments."),
    TITLENUMARGS("The Number of input arguments: "),
    ARGS(" argument: "),
    FIRST("\nFirst"),
    GREETNAME("Hello buddy."),
    METERS(" meters."),
    YEARS(" years."),
    GREETWORLD("Hello world."),
    PRINT_SCANNER("Print arguments separated by space"),
    PERSONAL_SKILLS("\nPersonal skill "),
    DEVELOPER_TITLE("\nDeveloper: "),
    PERSONAL_SALARY("\nMonthly salary: "),
    PERSONAL_YEARS("\nPersonal years: "),
    PERSONAL_STATURE("\nPersonal stature: "),
    PERSONAL_STATURE_FIX("\", exactly: \""),
    YEARS_ADULT("\nYears to Be Adult: "),
    YEARS_MINOR("\nThis is a minor Boy"),
    YEARS_OLDER("\nthis man is retired"),
    YEARS_RETIREMENT("\nYears to Retirement: "),
    LINE_WRAP_DOCUMENT_SEGMENTS("\n#-----------------------------#\n"),
    SPACE_SEPARATOR("\\s"),
    WAIT_THREAD_MILL("2000");

    private String messageValue;
    private String messageName;

    Messages(String message) {
        this.messageValue = message;
        this.messageName = this.name();
    }

    public String getValue() {
        return this.messageValue;
    }

    public String getName() {
        return this.messageName;
    }

    public static Messages getRandomGreet() {
        return Math.random() < 0.5 ? Messages.GREETNAME : Messages.GREETWORLD;
    }

    public String getAllMessages() {
        String print = "";

        for (Messages message : Messages.values()) {
            print += message.getName() + ": " + message.getValue();
        }

        return print;
    }
}
