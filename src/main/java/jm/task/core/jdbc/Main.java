package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Получаем соединение с базой данных
        UserDao userDao = new UserDaoJDBCImpl();

        // Создание таблицы
        userDao.createUsersTable();
//
//        // Добавление пользователей
        userDao.saveUser("Alice", "Smith", (byte) 18);
        userDao.saveUser("Bob", "Johnson", (byte) 22);
        userDao.saveUser("Charlie", "Williams", (byte) 25);
        userDao.saveUser("Diana", "Jones", (byte) 26);


        // Получение и вывод всех пользователей
        for (User user : userDao.getAllUsers()) {
            System.out.println(user);
        }

//        // Очистка таблицы
//        userDao.cleanUsersTable();
//
//        // Удаление таблицы
//        userDao.dropUsersTable();
    }
}