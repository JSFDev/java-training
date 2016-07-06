package com.test.platzi.simple;

import com.java.platzi.simple.SqlUser;
import com.java.platzi.simple.constants.DatabaseEnum;

public class SqlUserTest implements Runnable {
    private static final String THREAD_NAME = "Thread-sqluser";
    private static final Thread thread = new Thread(new SqlUserTest(), THREAD_NAME);
    private static SqlUser rootTheypollLocal = new SqlUser(DatabaseEnum.THEYPOLL_LOCAL, "root", "mysql4316");

    @Override
    public void run() {
        SqlUserTest.shouldConnectDatabase();
        SqlUserTest.shouldInsertRandomUser();
    }

    private static void shouldConnectDatabase() {
        rootTheypollLocal.connectMysqlDatabase();
        rootTheypollLocal.closeMysqlDatabase();
    }

    private static void shouldInsertRandomUser() {
        rootTheypollLocal.connectMysqlDatabase();
        rootTheypollLocal.insertUser("", "", "", "", "");
        rootTheypollLocal.closeMysqlDatabase();
    }

    public static Thread getThread() {
        return SqlUserTest.thread;
    }
}
