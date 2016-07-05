package com.java.platzi.simple.connection;

import com.java.platzi.simple.Message;
import com.java.platzi.simple.constants.ConnectionEnum;
import com.java.platzi.simple.constants.Messages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private String urlDriverConnection;
    public static Connection connection = null;

    public ConnectDatabase(String urlConnection, String database) {
        this.setUrlDriverConnection(urlConnection, database);
    }

    public static String getMysqlUrlConnection() {
        return ConnectionEnum.MYSQL_DRIVER.getValue() +
                ConnectionEnum.LOCALHOST.getValue() +
                ConnectionEnum.MYSQL_PORT.getValue();
    }

    public void setUrlDriverConnection(String urlConnection, String database) {
        this.urlDriverConnection = urlConnection + database;
    }

    public static Connection getConnection() {
        return ConnectDatabase.connection;
    }

    private boolean isConnectionOpened() {
        boolean isValid = false;
        try {
            isValid = ConnectDatabase.connection != null && ConnectDatabase.connection.isValid(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }

    public void connectDatabase(String driverPackage, String user, String pass) {
        try {
            if (!this.isConnectionOpened()) {
                Class.forName(driverPackage);
                ConnectDatabase.connection = DriverManager.getConnection(this.getUrlDriverConnection(), user, pass);
                this.printConnectionStatus(true);
            }
        } catch (SQLException sqlErr) {
            sqlErr.printStackTrace();
            System.out.println(sqlErr.getMessage());
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public void closeDatabase() {
        try {
            ConnectDatabase.connection.close();
            this.printConnectionStatus(false);
        } catch (SQLException sqlErr) {
            sqlErr.printStackTrace();
            System.out.println(sqlErr.getMessage());
        }
    }

    private void printConnectionStatus(boolean isOpened) {
        Messages message = isOpened ? Messages.CONN_OPENED : Messages.CONN_CLOSED;
        System.out.println(message.getValue());
    }

    public String getUrlDriverConnection() {
        return urlDriverConnection;
    }
}
