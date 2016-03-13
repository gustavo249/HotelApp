package view.viewLogic;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 08/03/2016.
 */
public class CancelReservationView extends View {

    @FXML
    private TextField txtCanceledReservationNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void backToEmployeeWorkspace() {
        super.backToEmployeeWorkspace();
    }

    @FXML
    public void cancelReservation() {
        controller.cancelReservation(txtCanceledReservationNumber.getText());
    }
}
