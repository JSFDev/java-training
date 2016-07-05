package com.test.platzi.simple;

import com.java.platzi.simple.SqlUser;
import com.java.platzi.simple.constants.ConnectionEnum;

public class SqlUserTest {
    public static void main (String[] args) {
        SqlUser root = new SqlUser("root", "mysql4316", ConnectionEnum.DB_THEYPOLL.getValue());
        root.connectMysqlDatabase();
        root.closeMysqlDatabase();
    }
}
