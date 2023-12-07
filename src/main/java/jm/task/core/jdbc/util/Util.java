package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static volatile Util instance;

    private Util() {

    }

    public static Util getInstance() {
        if (instance == null) {
            synchronized (Util.class) {
                if (instance == null) {
                    instance = new Util();
                }
            }
        }
        return instance;
    }

    public static final String USERNAME = "root";
    public static final String PASSWORD = "rootroot";
    public static final String URL = "jdbc:mysql://localhost:3306/mydb";

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            Util.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
