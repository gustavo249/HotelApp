package view.viewLogic;

import business.Reservation;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 08/03/2016.
 */
public class ReservationsTable extends View {

    private List<Reservation> reservations;

    @FXML
    private javafx.scene.control.TableView<Reservation> reservationsTable;
    @FXML
    private TableColumn<Reservation, Integer> colReservationNumber;
    @FXML
    private TableColumn<Reservation, Integer> colApartmentNumber;
    @FXML
    private TableColumn<Reservation, Integer> colClientCnp;
    @FXML
    private TableColumn<Reservation, String> colDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colReservationNumber.setCellValueFactory(
                new PropertyValueFactory<>("Reservation number")
        );
        colApartmentNumber.setCellValueFactory(
                new PropertyValueFactory<>("Apartment number")
        );
        colClientCnp.setCellValueFactory(
                new PropertyValueFactory<>("Client cnp")
        );
        colDate.setCellValueFactory(
                new PropertyValueFactory<>("Date")
        );
        reservations = dataManager.retrieve(reservations, "reservations");
        System.out.println(reservations.toString()); // here all seems alright all the fields are printed ok..
        reservationsTable.getItems().setAll(reservations);
    }

    @Override
    public void backToEmployeeWorkspace() {
        super.backToEmployeeWorkspace();
    }
}
