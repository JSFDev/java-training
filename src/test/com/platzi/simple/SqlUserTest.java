package test.com.platzi.simple;

import main.com.platzi.simple.SqlUser;
import main.com.platzi.simple.UserPojo;
import main.com.platzi.simple.constants.DatabaseEnum;
import test.com.Test;

public class SqlUserTest implements Runnable {
    private static Thread thread = new Thread(new SqlUserTest(), "Thread-mysqluser");
    private static final DatabaseEnum db = DatabaseEnum.THEYPOLL_LOCAL;
    private static final String user = System.getenv("ROOT_USER_MYSQL");
    private static final String pass = System.getenv("ROOT_PASS_MYSQL");
    private static SqlUser rootTheypollLocal = new SqlUser(db, user, pass);

    public static Thread getThread() {
        return SqlUserTest.thread;
    }

    @Override
    public void run() {
        System.out.println(MessageTest.getThread().getName());
        this.shouldConnectDatabase();
        this.shouldCheckPersistanceUser();
    }

    @Test
    private void shouldConnectDatabase() {
        rootTheypollLocal.connectMysqlDatabase();
        rootTheypollLocal.closeMysqlDatabase();
    }

    @Test
    private void shouldCheckPersistanceUser() {
        UserPojo pepe = new UserPojo("Pepe", "Lopera", "pepe@gmail", "tururu", 0, 1, "1972-12-15");
        rootTheypollLocal.connectMysqlDatabase();
        rootTheypollLocal.insertUser(pepe);
        rootTheypollLocal.deleteUser(pepe);
        rootTheypollLocal.closeMysqlDatabase();
    }
}
