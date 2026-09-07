package ru.merion.aqa.lesson21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDemo {

    public static final String CONNECTION_STRING = System.getProperty("db.url", "");
    public static final String USERNAME = "x_clients_user";
    public static final String PASSWORD = System.getProperty("db.password", "");


    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);

        String insert = "insert into company(\"name\") values('" + name + "');";
        connection.createStatement().executeUpdate(insert);

        int limit = scanner.nextInt();
        ResultSet resultSet = connection.createStatement().executeQuery("select * from company order by id desc limit " + limit);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("description"));
            System.out.println(resultSet.getString("is_active"));
        }

        connection.close();


        // SQL Injection --> abc'); delete from company; --
    }
}

