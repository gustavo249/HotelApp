package view.viewLogic;

import business.Client;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 23/03/2016.
 */
public class ClientsTable extends View {

    private List<Client> clients;
    @FXML
    private TableView<Client> clientsTable;

    @FXML
    private TableColumn<Client, String> colName;

    @FXML
    private TableColumn<Client, Integer> colCnp;

    @FXML
    private TableColumn<Client, String> colPhone;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCnp.setCellValueFactory(new PropertyValueFactory<>("cnp"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        clients = dataManager.retrieve(clients, "clients");
        try {
            clientsTable.getItems().setAll(clients);
        } catch (NullPointerException e) {
            System.err.println("No clients to be listed");
        }
    }

    @Override
    public void backToEmployeeWorkspace() {
        super.backToEmployeeWorkspace();
    }
}
