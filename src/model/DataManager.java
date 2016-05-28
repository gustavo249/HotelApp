package model;

import business.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo on 03/03/2016.
 */
public class DataManager {
    private static Connection connection = ConnectionManager.getInstance().getConnection();
    private static final int NAME = 1;
    private static final int JOB = 2;
    private static final int SALARY = 3;
    private static final int USERNAME = 4;
    private static final int PASSWORD = 5;


    //NEW MANAGER

    public boolean insertNewManager(Manager manager) {
        final String sql = "INSERT into manager (username, password, name, salary) " +
                "VALUES (?, ?, ?, ?)";
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, manager.getUsername());
            statement.setString(2, manager.getPassword());
            statement.setString(3, manager.getName());
            statement.setInt(4, manager.getSalary());
            int affected = statement.executeUpdate();
            if (affected > 0) {
                System.out.println("Manager added succesfully");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //managing database for EMPLOYEES
    public boolean insert(Employee bean) {
        final String sql = "INSERT into employees (name, job, salary, username, password) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(NAME, bean.getName());
            statement.setString(JOB, bean.getJob());
            statement.setInt(SALARY, bean.getSalary());
            statement.setString(USERNAME, bean.getUsername());
            statement.setString(PASSWORD, bean.getPassword());
            int affected = statement.executeUpdate();
            if (affected > 0) {
                System.out.println("Employee added succesfully");
                return true;
            } else
                System.out.println("Insert failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //managing database for RESERVATIONS
    public boolean insert(Reservation bean) {
        final String sql = "INSERT into reservations (reservation_number, ap_no, client_cnp, date) " +
                "VALUES (?, ?, ?, ?)";
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, bean.getReservationNumber());
            statement.setInt(2, bean.getApartmentNo());
            statement.setLong(3, bean.getClient().getCnp());
            statement.setString(4, bean.getDate());
            int affected = statement.executeUpdate();
            if (affected > 0) {
                System.out.println("Reservation added succesfully");
                return true;
            } else
                System.out.println("Insert failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //managing database for CLIENTS
    public boolean insert(Client bean) {
        final String sql = "INSERT into clients (cnp, name, phone) VALUES (?, ?, ?)";

        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, bean.getCnp());
            statement.setString(2, bean.getName());
            statement.setString(3, bean.getPhone());
            int affected = statement.executeUpdate();
            if (affected > 0) {
                System.out.println("Client added succesfully");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //managing database for APARTMENTS
    public boolean insert(Apartment bean) {
        final String sql = "INSERT into apartments (ap_no, rooms, beds, disponibility, price) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, bean.getApartmentNo());
            statement.setInt(2, bean.getRooms());
            statement.setInt(3, bean.getBeds());
            statement.setString(4, bean.getStatus());
            statement.setInt(5, bean.getPrice());
            int affected = statement.executeUpdate();
            if (affected > 0) {
                System.out.println("Apartment added succesfully");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(int primaryKey, String table, String value) {
        String sql = "UPDATE " + table + " SET disponibility = " + "\'" + value + "\'" + " WHERE ap_no = " + primaryKey;
        try (
                Statement statement = connection.createStatement();
        ) {
            int affected = statement.executeUpdate(sql);
            if (affected == 1)
                System.out.println("Apartment status updated");
            else
                System.err.println("Apartment status failed to update");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //search for a particular bussiness class in the database
    public Object find(Object primaryKey, String table) {
        String sql = new String();
        if (table.startsWith("emp"))
            sql = "SELECT * FROM " + table + " WHERE username = ?";
        else if (table.startsWith("apart"))
            sql = "SELECT * FROM " + table + " WHERE ap_no = ?";
        else if (table.startsWith("clients"))
            sql = "SELECT * FROM " + table + " WHERE cnp = ?";
        else if (table.startsWith("res"))
            sql = "SELECT * FROM " + table + " WHERE reservation_number = ?";
        ResultSet resultSet = null;
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setObject(1, primaryKey);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if (table.startsWith("emp")) {
                    Employee employee = new Employee(resultSet.getString("name"), resultSet.getString("username"),
                            resultSet.getString("password"), resultSet.getString("job"),
                            Integer.parseInt(resultSet.getString("Salary")));
                    return employee;
                } else if (table.startsWith("apart")) {
                    Apartment apartment = new Apartment(resultSet.getInt("ap_no"), resultSet.getInt("rooms"),
                            resultSet.getInt("beds"), resultSet.getString("disponibility"),
                            resultSet.getInt("price"));
                    return apartment;
                } else if (table.startsWith("cli")) {
                    Client client = new Client(resultSet.getString("name"), resultSet.getInt("cnp"),
                            resultSet.getString("phone"));
                    return client;
                } else if (table.startsWith("res")) {
                    Client client = (Client) find(resultSet.getInt("client_cnp"), "clients");
                    Reservation reservation = new Reservation((Integer) primaryKey,
                            resultSet.getInt("ap_no"), client, resultSet.getString("date"));
                    return reservation;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //retrieve the database contents
    public <T> List<T> retrieve(List<T> beans, String table) {
        String sql = new String();
        beans = new ArrayList<>();
        sql = "SELECT * from " + table;
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            if (resultSet.next()) {
                resultSet.beforeFirst();
                while (resultSet.next()) {
                    if (table.startsWith("emp")) {
                        Employee employee = new Employee(resultSet.getString("name"), resultSet.getString("username"),
                                resultSet.getString("password"), resultSet.getString("job"),
                                Integer.parseInt(resultSet.getString("Salary")));
                        beans.add((T) employee);
                    } else if (table.startsWith("apart")) {
                        Apartment apartment = new Apartment(resultSet.getInt("ap_no"), resultSet.getInt("rooms"),
                                resultSet.getInt("beds"), resultSet.getString("disponibility"),
                                resultSet.getInt("price"));
                        beans.add((T) apartment);
                    } else if (table.startsWith("cli")) {
                        Client client = new Client(resultSet.getString("name"), resultSet.getInt("cnp"),
                                resultSet.getString("phone"));
                        beans.add((T) client);
                    } else if (table.startsWith("res")) {
                        Client client = (Client) find(resultSet.getString("client_cnp"), "clients");
                        Reservation reservation = new Reservation(resultSet.getInt("reservation_number"),
                                resultSet.getInt("ap_no"), client, resultSet.getString("date"));
                        beans.add((T) reservation);
                    }
                }
                //finally i return the list
                return beans;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean remove(Object primaryKey, String table) {
        String sql = new String();
        if (table.startsWith("res"))
            sql = "DELETE from " + table + " WHERE reservation_number = ?";
        else if (table.startsWith("cli"))
            sql = "DELETE from " + table + " WHERE cnp = ?";
        else if (table.startsWith("emp"))
            sql = "DELETE from " + table + " WHERE username = ?";
        else if (table.startsWith("apar"))
            sql = "DELETE from " + table + " WHERE ap_no = ?";
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setObject(1, primaryKey);
            int affected = statement.executeUpdate();
            if (affected == 1) {
                System.out.println(table.substring(0, table.length() - 1) + " deleted succesfully");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
