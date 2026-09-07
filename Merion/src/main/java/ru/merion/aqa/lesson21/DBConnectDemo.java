package ru.merion.aqa.lesson21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectDemo {
    public static final String CONNECTION_STRING = System.getProperty("db.url", "");
    public static final String USERNAME = "x_clients_user";
    public static final String PASSWORD = System.getProperty("db.password", "");

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);

        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM company");
//
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString("id"));
//            System.out.println(resultSet.getString("name"));
//            System.out.println(resultSet.getString("description"));
//            System.out.println(resultSet.getString("is_active"));
//        }

        resultSet = connection.createStatement().executeQuery("SELECT count(*) FROM company");
        resultSet.next();
        System.out.println(resultSet.getInt(1));


        String insert = "insert into company(\"name\") values('Рога и копыта');";

        connection.createStatement().executeUpdate(insert);

        resultSet = connection.createStatement().executeQuery("select * from company order by id desc limit 10");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("description"));
            System.out.println(resultSet.getString("is_active"));
        }


        connection.close();
    }

}
