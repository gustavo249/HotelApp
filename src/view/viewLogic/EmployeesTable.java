package view.viewLogic;

import business.Employee;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DataManager;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 06/03/2016.
 */
public class EmployeesTable implements Initializable {

    private static DataManager dataManager = new DataManager();
    private List<Employee> employees;
    private static View view = new View();

    @FXML
    private javafx.scene.control.TableView<Employee> employeesTable;
    @FXML
    private TableColumn<Employee, String> colName;
    @FXML
    private TableColumn<Employee, String> colJob;
    @FXML
    private TableColumn<Employee, Integer> colSalary;
    @FXML
    private TableColumn<Employee, String> colUsername;
    @FXML
    private TableColumn<Employee, String> colPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colName.setCellValueFactory(
                new PropertyValueFactory<>("Name")
        );
        colJob.setCellValueFactory(
                new PropertyValueFactory<>("Job")
        );
        colSalary.setCellValueFactory(
                new PropertyValueFactory<>("Salary")
        );
        colUsername.setCellValueFactory(
                new PropertyValueFactory<>("Username")
        );
        colPassword.setCellValueFactory(
                new PropertyValueFactory<>("Password")
        );
        employees = dataManager.retrieve(employees, "employees");
        try {
            employeesTable.getItems().setAll(employees);
        } catch (NullPointerException e) {
            System.err.println("No employees to be listed");
        }

    }

    @FXML
    public void backToManagerWorkplace() {
        view.changeScene("../../view/managerWorkspace.fxml");
    }
}
