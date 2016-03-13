package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Gustavo on 03/03/2016.
 */
public class ConnectionManager {
    private static Connection connection = null;
    private static ConnectionManager instance = null;
    private static final String URL = "jdbc:mysql://localhost/hotel_register";
    private static final String USER = "raoul";
    private static final String PASS = "cefere";

    private ConnectionManager() {
    }

    public static ConnectionManager getInstance() {
        if (instance == null)
            instance = new ConnectionManager();
        return instance;
    }

    public boolean openConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection opened");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            if (openConnection()) {
                return connection;
            } else {
                System.err.println("Failed to open the connection");
                return null;
            }
        }
        return connection;
    }

    public void closeConnection() {
        System.out.println("Connection closed");
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
