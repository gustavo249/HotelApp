package view.viewLogic;

import business.Apartment;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 20/03/2016.
 */
public class ApartmentsTable extends View {

    private List<Apartment> apartments;

    @FXML
    private TableView<Apartment> apartmentsTable;
    @FXML
    private TableColumn<Apartment, Integer> colApNo;
    @FXML
    private TableColumn<Apartment, Integer> colRooms;
    @FXML
    private TableColumn<Apartment, Integer> colBeds;
    @FXML
    private TableColumn<Apartment, String> colStatus;
    @FXML
    private TableColumn<Apartment, Integer> colPrice;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colApNo.setCellValueFactory(new PropertyValueFactory<>("apartmentNo"));
        colRooms.setCellValueFactory(new PropertyValueFactory<>("Rooms"));
        colBeds.setCellValueFactory(new PropertyValueFactory<>("Beds"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        apartments = dataManager.retrieve(apartments, "apartments");
        try {
            apartmentsTable.getItems().addAll(apartments);
        } catch (NullPointerException e) {
            System.err.println("No apartments to be listed");
        }

    }

    @Override
    public void backToEmployeeWorkspace() {
        super.backToEmployeeWorkspace();
    }
}
