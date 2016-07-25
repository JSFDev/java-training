package com.platzi.simple;

import com.platzi.simple.constants.DatabaseEnum;
import org.junit.Test;

public class SqlUserTest {
    private Thread thread = null;
    private Runnable task = () -> {
        System.out.println(this.thread.getName());
        this.shouldConnectDatabase();
        this.shouldCheckPersistanceUser();
    };
    private static final DatabaseEnum db = DatabaseEnum.THEYPOLL_LOCAL;
    private static final String user = System.getenv("ROOT_USER_MYSQL");
    private static final String pass = System.getenv("ROOT_PASS_MYSQL");
    private static SqlUser rootTheypollLocal = new SqlUser(db, user, pass);

    public void runTask() {
        thread = new Thread(this.task, "Thread-mysqluser");
        thread.start();
    }

    @Test
    public void shouldConnectDatabase() {
        rootTheypollLocal.connectMysqlDatabase();
        rootTheypollLocal.closeMysqlDatabase();
    }

    @Test
    public void shouldCheckPersistanceUser() {
        UserPojo pepe = new UserPojo(1, 0, "Pepe", "Lopera", "pepe@gmail", "taurus", "1972-12-15");
        rootTheypollLocal.connectMysqlDatabase();
        rootTheypollLocal.insertUser(pepe);
        rootTheypollLocal.deleteUser(pepe);
        rootTheypollLocal.closeMysqlDatabase();
    }
}
