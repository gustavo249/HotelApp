package model;

import java.sql.*;

/**
 * Created by Gustavo on 03/03/2016.
 */
public class InterogateDatabase extends DataManager {
    private static Connection connection = ConnectionManager.getInstance().getConnection();

    public InterogateDatabase() {
    }

    public boolean checkInDatabase(String username, String password, String person) {
        String sql = new String();
        if (person.startsWith("emp")) {
             sql = "SELECT * FROM employees WHERE username = ?";
        } else if (person.startsWith("man")) {
             sql = "SELECT * FROM manager WHERE username = ?";
        }
        ResultSet resultSet = null;
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString("password").equals(password))
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
