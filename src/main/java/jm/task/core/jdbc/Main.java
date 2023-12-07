package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 20);
        userService.saveUser("Petr", "Petrov", (byte) 22);
        userService.saveUser("Anton", "Sidorov", (byte) 25);
        userService.saveUser("John", "Smith", (byte) 30);

        userService.removeUserById(1);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();

        Util.closeConnection();
    }
}
