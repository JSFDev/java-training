package com.java.platzi.simple;

import com.java.platzi.simple.connection.ConnectDatabase;
import com.java.platzi.simple.constants.ConnectionEnum;

public class SqlUser {
    private ConnectDatabase mysqlDb;
    private String user;
    private String pass;
    private String db;

    public SqlUser(String user1, String pass, String db) {
        this.user = user1;
        this.pass = pass;
        this.db = db;
        mysqlDb = new ConnectDatabase(ConnectDatabase.getMysqlUrlConnection(), db);
    }

    public void connectMysqlDatabase () {
        mysqlDb.connectDatabase(ConnectionEnum.MYSQL_DRIVER_PACKAGE.getValue(), this.user, this.pass);
    }

    public void closeMysqlDatabase () {
        mysqlDb.closeDatabase();
    }

    public void insertUser(String name, String surname, String email, String pass, String bornDate) {
        // todo: this.mysqlDb.getConnection();
    }
}
