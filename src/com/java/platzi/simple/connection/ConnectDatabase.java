package com.java.platzi.simple.connection;

import com.java.platzi.simple.constants.ConnectionEnum;
import com.java.platzi.simple.constants.DatabaseEnum;
import com.java.platzi.simple.constants.Messages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private ConnectionEnum driverConnection;
    private DatabaseEnum dbConnection;
    public static Connection connection = null;

    public ConnectDatabase(ConnectionEnum driverConnection, DatabaseEnum dbConnection) {
        this.driverConnection = driverConnection;
        this.dbConnection = dbConnection;
    }

    private String getUrlConnection() {
        return driverConnection.getProtocol() + dbConnection.getHost() + dbConnection.getPort() + dbConnection.getDatabase();
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

    public void connectDatabase(String user, String pass) {
        try {
            if (!this.isConnectionOpened()) {
                Class.forName(driverConnection.getDriver());
                ConnectDatabase.connection = DriverManager.getConnection(this.getUrlConnection(), user, pass);
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
}
