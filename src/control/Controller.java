package control;

import business.Apartment;
import business.Client;
import business.Employee;
import business.Reservation;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DataManager;
import model.InterogateDatabase;
import view.viewLogic.LoginView;
import view.viewLogic.View;

import java.util.List;

/**
 * Created by Gustavo on 14/02/2016.
 */
public class Controller {
    private List<Employee> employees;
    private List<Apartment> apartments;
    private List<Reservation> reservations;
    private List<Client> clients;

    private static DataManager dataManager = new DataManager();
    private static InterogateDatabase question = new InterogateDatabase();
    private static View view = new View();
    private Hotel hotel;
    private Stage stage;

    public Controller() {
        employees = dataManager.retrieve(employees, "employees");
        apartments = dataManager.retrieve(apartments, "apartments");
        reservations = dataManager.retrieve(reservations, "reservations");
        clients = dataManager.retrieve(clients, "clients");
        hotel = new Hotel();
    }

    public void start() {
        hotel.setHotelName("hotel Palermo");
        //Manager manager = new Manager("rcrisan", "pitech", "Crisan Raoul", 10000);
        // dataManager.insertNewManager(manager);
        stage = Main.myStage;

    }


    public boolean validateManager(String username, String password) {
        if (question.checkInDatabase(username, password, "manager")) {
            //open manager workspace scene
            LoginView loginView = new LoginView();
            loginView.managerWorkspaceView();
            return true;
        } else {
            System.err.println("Invalid username or password");
        }
        return false;
    }

    public boolean validateEmployee(String username, String password) {
        InterogateDatabase question = new InterogateDatabase();
        if (question.checkInDatabase(username, password, "employee")) {
            //open employee workspace scene
            LoginView loginView = new LoginView();
            loginView.employeeWorkspaceView();
            return true;
        } else {
            System.err.println("Invalid username or password");
        }
        return false;
    }

    //Employee's personal information
    @FXML
    private TextField employeeName;
    @FXML
    private TextField employeeJob;
    @FXML
    private TextField employeeSalary;
    @FXML
    private TextField employeeUsername;
    @FXML
    private PasswordField employeePassword;

    @FXML
    public void addEmployee() {


        if (dataManager.find(employeeUsername.getText(), "employees") != null) {
            System.err.println("The employee is already in the system usernames must be unique");
        } else {
            try {
                Integer salary = Integer.parseInt(employeeSalary.getText());
                Employee employee = new Employee(employeeName.getText(), employeeUsername.getText(),
                        employeePassword.getText(), employeeJob.getText(), salary);
                dataManager.insert(employee);
                employees = dataManager.retrieve(employees, "employees");
                backToManagerWorkplace();
            } catch (Exception e) {
                System.err.println("Invalid input");
            }

        }
    }

    //contact of the fired employee
    @FXML
    private TextField firedEmployeeUsername;

    @FXML
    public void fireEmployee() {
        Employee employee = (Employee) dataManager.find(firedEmployeeUsername.getText(), "employees");
        if (employee != null) {
            dataManager.remove(firedEmployeeUsername.getText(), "employees");
            backToManagerWorkplace();
        } else {
            System.err.println("Coud not find the employee in the system the username doesn't exist'");
        }
    }

    @FXML
    public void backToManagerWorkplace() {
        view.changeScene("../../view/managerWorkspace.fxml");
    }


    public void createNewReservation(String txtReservationNumber, String clientName, String txtClientCnp,
                                     String clientPhone, String txtApNumber, String date) {
        try {
            Integer reservationNumber = Integer.parseInt(txtReservationNumber);
            Integer clientCnp = Integer.parseInt(txtClientCnp);
            Integer apNumber = Integer.parseInt(txtApNumber);

            if (clientName == null || clientPhone == null || date == null) {
                System.err.println("Please complete all fields");
                return;
            }
            Client client = new Client(clientName, clientCnp, clientPhone);
            Reservation reservation = new Reservation(reservationNumber, apNumber, client, date);

            Apartment apartment = (Apartment) dataManager.find(apNumber, "apartments");
            if (apartment == null) {
                System.err.println("This apartment does not exist");
                return;
            }
            if (apartment.getStatus().startsWith("res")) {
                System.err.println("This apartment is already reserved");
                return;
            }
            if (dataManager.find(reservationNumber, "reservations") != null) {
                System.err.println("The reservation matches with another reservation");
                return;
            } else if (dataManager.find(clientCnp, "clients") != null) {
                System.err.println("This client's cnp matches with another cnp in the system'");
                return;

            } else {
                dataManager.insert(client);
                dataManager.insert(reservation);
                dataManager.update(apNumber, "apartments", "reserved");
                view.backToEmployeeWorkspace();
            }


        } catch (Exception e) {
            System.err.println("Invalid input or empty fields detected");
            return;
        }
    }

    public void addNewApartment(String txtApNumber, String txtRooms, String txtBeds, String txtPrice) {
        try {
            Integer apNumber = Integer.parseInt(txtApNumber);
            Integer rooms = Integer.parseInt(txtRooms);
            Integer beds = Integer.parseInt(txtBeds);
            Integer price = Integer.parseInt(txtPrice);
            if (dataManager.find(apNumber, "apartments") == null) {
                Apartment apartment = new Apartment(apNumber, rooms, beds, "available", price);
                dataManager.insert(apartment);
                view.backToEmployeeWorkspace();
            } else {
                System.err.println("The apartment already exist in the system");
            }
        } catch (Exception e) {
            System.err.println("Invalid input");
        }
    }

    public void cancelReservation(String txtReservationNumber) {
        try {
            Integer reservationNumber = Integer.parseInt(txtReservationNumber);

            Reservation reservation = (Reservation) dataManager.find(reservationNumber, "reservations");
            if (dataManager.remove(reservationNumber, "reservations")) {
                dataManager.remove(reservation.getClient().getCnp(), "clients");
                view.backToEmployeeWorkspace();
                dataManager.update(reservation.getApartmentNo(), "apartments", "available");
                System.out.println(reservation.toString());
            } else {
                System.err.println("Reservation does not exist");
            }
        } catch (Exception e) {
            System.err.println("Invalid input");
        }
    }

    public void removeApartment(String apNumber) {
        try {
            int apNo = Integer.parseInt(apNumber);
            Apartment apartment = (Apartment) dataManager.find(apNo, "apartments");
            if (apartment == null) {
                System.err.println("Apartment not found");
                return;
            }
            if (apartment.getStatus().startsWith("res"))
                System.out.println("You cannot remove a reserved apartment");
            else {
                dataManager.remove(apNo, "apartments");
                view.backToEmployeeWorkspace();
            }
        } catch (Exception e) {
            System.err.println("Invalid input");
        }
    }
}
