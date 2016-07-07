package com.test.platzi.simple;

import com.java.platzi.simple.SqlUser;
import com.java.platzi.simple.UserPojo;
import com.java.platzi.simple.constants.DatabaseEnum;

public class SqlUserTest implements Runnable {
    private static Thread thread = new Thread(new SqlUserTest(), "Thread-mysqluser");
    private static final DatabaseEnum db = DatabaseEnum.THEYPOLL_LOCAL;
    private static final String user = System.getenv("ROOT_USER_MYSQL");
    private static final String pass = System.getenv("ROOT_PASS_MYSQL");
    private static SqlUser rootTheypollLocal = new SqlUser(db, user, pass);

    @Override
    public void run() {
        SqlUserTest.shouldConnectDatabase();
        SqlUserTest.shouldCheckPersistanceUser();
    }

    private static void shouldConnectDatabase() {
        rootTheypollLocal.connectMysqlDatabase();
        rootTheypollLocal.closeMysqlDatabase();
    }

    private static void shouldCheckPersistanceUser() {
        UserPojo pepe = new UserPojo("Pepe", "Lopera", "pepe@gmail", "tururu", 0, 1, "1972-12-15");
        rootTheypollLocal.connectMysqlDatabase();
        rootTheypollLocal.insertUser(pepe);
        rootTheypollLocal.deleteUser(pepe);
        rootTheypollLocal.closeMysqlDatabase();
    }

    public static Thread getThread() {
        return SqlUserTest.thread;
    }
}
