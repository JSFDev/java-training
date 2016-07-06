package com.java.platzi.simple.constants;

public enum DatabaseEnum {
    THEYPOLL_LOCAL("//localhost", ":3306/", "theypoll-refactor");

    private final String host;
    private final String port;
    private final String database;
    private final String name;

    DatabaseEnum(String host, String port, String database) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.name = this.name();
    }

    public String getName() {
        return this.name;
    }

    public String getHost() {
        return this.host;
    }

    public String getPort() {
        return this.port;
    }

    public String getDatabase() {
        return this.database;
    }
}
