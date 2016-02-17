import java.io.*;

/**
 * Created by Gustavo on 12/02/2016.
 */
public class Employee {
    private String name;
    private String job;
    private int salary;

    public Employee(String name, String job, int salary) {
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public Employee() {}

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

    public static Employee[] addNewEmployee(Employee[] employees, String name, String job, int salary) {
        Employee[] newEmployees = new Employee[employees.length + 1];
        int i = 0;
        for (i = 0; i < employees.length; i++) {
            newEmployees[i] = new Employee(employees[i].getName(), employees[i].getJob(), employees[i].getSalary());
        }
        newEmployees[i] = new Employee(name, job, salary);
        return newEmployees;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static Employee[] readEmployees() {
        Employee[] employees = new Employee[0];
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("employees.txt"));
            String line;
            String[] infoEmployee;

            while ((line = br.readLine()) != null) {
                infoEmployee = line.split(" ");
                employees = addNewEmployee(employees, infoEmployee[0], infoEmployee[1], Integer.parseInt(infoEmployee[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
}
