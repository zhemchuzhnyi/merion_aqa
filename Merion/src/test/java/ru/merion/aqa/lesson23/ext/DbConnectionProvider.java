package ru.merion.aqa.lesson23.ext;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionProvider implements BeforeAllCallback, AfterAllCallback {
    public static final String CONNECTION_STRING = System.getProperty("db.url", "");
    public static final String USERNAME = "x_clients_user";
    public static final String PASSWORD = System.getProperty("db.password", "");
    private Connection connection;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        this.connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        context.getStore(ExtensionContext.Namespace.GLOBAL).put("db_connection", connection);
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        if (connection != null){
            connection.close();
        }
    }
}
