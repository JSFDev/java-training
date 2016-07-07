package com.java.platzi.simple;

import com.java.platzi.simple.connection.ConnectDatabase;
import com.java.platzi.simple.connection.CrudDatabase;
import com.java.platzi.simple.constants.ConnectionEnum;
import com.java.platzi.simple.constants.DatabaseEnum;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class SqlUser {
    private CrudDatabase crud = new CrudDatabase();
    private ConnectDatabase mysql = null;
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

    private void InsertUserByStatementSql(Statement statement, UserPojo newUser) throws SQLException, ParseException {
        String insertUserFormat = "INSERT INTO `users` (`name`, `surname`, `email`, `password`, `city`, `country`, `borndate`) VALUES ('%s','%s','%s','%s',%d,%d,'%tF')";
        String query = String.format(insertUserFormat,
                crud.getParsedVarchar(newUser.getName()),
                crud.getParsedVarchar(newUser.getSurname()),
                crud.getParsedVarchar(newUser.getEmail()),
                crud.getParsedVarchar(newUser.getPassword()),
                crud.getParsedInt(newUser.getCity()),
                crud.getParsedInt(newUser.getCountry()),
                crud.getParsedDate(newUser.getBorndate()));

        if (statement.executeUpdate(query) == 0) {
            throw new SQLException("Could not insert new User: " + newUser.getName());
        }
    }

    public void insertUser(UserPojo newUser) {
        Statement statement = null;
        try {
            statement = ConnectDatabase.getConnection().createStatement();
            this.InsertUserByStatementSql(statement, newUser);

        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
