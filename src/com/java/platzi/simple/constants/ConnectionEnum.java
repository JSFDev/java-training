package com.java.platzi.simple.constants;

public enum ConnectionEnum {
    MYSQL_DRIVER("com.mysql.jdbc.Driver", "jdbc:mysql:", "mysql"),
    SQLSERVER_DRIVER("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver:", "mssql"),
    SQLITE_DRIVER("org.sqlite.JDBC", "jdbc:sqlite:", "sqlite");

    private final String driver;
    private final String protocol;
    private final String rdbms;
    private final String name;

    ConnectionEnum(String driver, String protocol, String rdbms) {
        this.driver = driver;
        this.protocol = protocol;
        this.rdbms = rdbms;
        this.name = this.name();
    }

    public String getDriver() {
        return this.driver;
    }

    public String getName() {
        return this.name;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getRdbms() {
        return this.rdbms;
    }
}
