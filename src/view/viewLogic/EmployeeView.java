package view.viewLogic;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 06/03/2016.
 */
public class EmployeeView extends View {

    protected static Stage window;

    @FXML private Label lbAcc;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lbAcc.setText("Signed in as: " + LoginView.profile);
    }

    @FXML
    public void employeeLogOut() {
        window = new Stage();
        changeScene(window, "../../view/employeeLogOut.fxml");
    }

    @FXML
    public void newReservationView() {
        changeScene("../../view/newReservationView.fxml");
    }

    @FXML
    public void addApartmentView() {
        changeScene("../../view/newApartmentView.fxml");
    }

    @FXML
    public void cancelReservationView() {
        changeScene("../../view/cancelReservationView.fxml");
    }

    @FXML
    public void seeAllReservations() {
        changeScene("../../view/seeAllReservations.fxml");
    }
}
