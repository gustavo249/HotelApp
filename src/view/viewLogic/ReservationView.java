package view.viewLogic;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 07/03/2016.
 */
public class ReservationView extends View {

    @FXML
    TextField txtReservationNumber;

    @FXML
    TextField txtClientName;

    @FXML
    TextField txtClientCnp;

    @FXML
    TextField txtClientPhone;

    @FXML
    TextField txtApNumber;

    @FXML
    TextField txtDate;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void backToEmployeeWorkspace() {
        super.backToEmployeeWorkspace();
    }

    @FXML
    public void createNewReservation() {
        controller.createNewReservation(txtReservationNumber.getText(), txtClientName.getText(),
                txtClientCnp.getText(), txtClientPhone.getText(),
                txtApNumber.getText(), txtDate.getText());
    }
}
