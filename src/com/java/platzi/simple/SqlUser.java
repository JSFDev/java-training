package com.java.platzi.simple;

import com.java.platzi.simple.connection.ConnectDatabase;
import com.java.platzi.simple.constants.ConnectionEnum;
import com.java.platzi.simple.constants.DatabaseEnum;

public class SqlUser {
    private ConnectDatabase mysql;
    private String user;
    private String pass;

    public SqlUser(DatabaseEnum database, String user1, String pass) {
        this.user = user1;
        this.pass = pass;
        mysql = new ConnectDatabase(ConnectionEnum.MYSQL_DRIVER, database);
    }

    public void connectMysqlDatabase() {
        mysql.connectDatabase(this.user, this.pass);
    }

    public void closeMysqlDatabase() {
        mysql.closeDatabase();
    }

    public void insertUser(String name, String surname, String email, String pass, String bornDate) {
        this.mysql.getConnection();
    }
}
