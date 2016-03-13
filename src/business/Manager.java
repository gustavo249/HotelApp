package business;

/**
 * Created by Gustavo on 05/03/2016.
 */
public class Manager {
    private String username;
    private String password;
    private String name;
    private int salary;

    public Manager(String username, String password, String name, int salary) {
        this.username = username;
        this.password = password;
        this.name = name;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
