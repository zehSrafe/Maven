package be.intec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static ConnectionManager instance = new ConnectionManager();
    public static ConnectionManager getInstance() {
        return instance;
    }

    private Connection connection;
    private ConnectionManager() {
    }

    public void init() throws SQLException {
        connection = DriverManager.getConnection("", "", "");
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void close() throws SQLException {
        connection.close();
    }
}
