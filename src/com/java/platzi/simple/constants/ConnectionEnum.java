package com.java.platzi.simple.constants;

public enum ConnectionEnum {
    MYSQL_DRIVER("jdbc:mysql:"),
    MYSQL_DRIVER_PACKAGE("com.mysql.jdbc.Driver"),
    MYSQL_PORT(":3306/"),
    LOCALHOST("//localhost"),
    DB_THEYPOLL("theypoll-refactor");

    private String name;
    private String value;

    ConnectionEnum(String value) {
        this.value = value;
        this.name = this.name();
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
