package business;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo on 12/02/2016.
 */
public class Employee {
    private String name;
    private String username;
    private String password;
    private String job;
    private int salary;

    public Employee(String name, String username, String password, String job, int salary) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.job = job;
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static List<Employee> addNewEmployee(List<Employee> employees, Employee newEmployee) {
        employees.add(newEmployee);
        return employees;
    }

    @Override
    public String toString() {
        return "business.Employee{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }

}
