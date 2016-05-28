package view.viewLogic;

import business.Client;
import business.Reservation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DataManager;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 08/03/2016.
 */
public class ReservationsTable implements Initializable {

    private List<Reservation> reservations;
    private static DataManager dataManager = new DataManager();
    private static View view = new View();

    @FXML
    private javafx.scene.control.TableView<Reservation> reservationsTable;
    @FXML
    private TableColumn<Reservation, Integer> colReservationNumber;
    @FXML
    private TableColumn<Reservation, Integer> colApartmentNumber;
    @FXML
    private TableColumn<Client, Integer> colClientCnp;
    @FXML
    private TableColumn<Reservation, String> colDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colReservationNumber.setCellValueFactory(
                new PropertyValueFactory<>("reservationNumber")
        );
        colApartmentNumber.setCellValueFactory(
                new PropertyValueFactory<>("apartmentNo")
        );
        colClientCnp.setCellValueFactory(
                new PropertyValueFactory<>("client")
        );
        colDate.setCellValueFactory(
                new PropertyValueFactory<>("Date")
        );
        reservations = dataManager.retrieve(reservations, "reservations");
        try {
            reservationsTable.getItems().setAll(reservations);

        } catch (NullPointerException e) {
            System.err.println("No reservations to be listed");
        }

    }

    public void backToEmployeeWorkspace() {
        view.backToEmployeeWorkspace();
    }
}
