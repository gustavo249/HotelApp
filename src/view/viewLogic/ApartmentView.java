package view.viewLogic;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 08/03/2016.
 */
public class ApartmentView extends View {
    @FXML private TextField txtApNumber;
    @FXML private TextField txtRooms;
    @FXML private TextField txtBeds;
    @FXML private TextField txtStatus;
    @FXML private TextField txtPrice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void addNewApartment() {
        controller.addNewApartment(txtApNumber.getText(), txtRooms.getText(), txtBeds.getText(),
                txtPrice.getText());
    }


    @Override
    public void backToEmployeeWorkspace() {
        super.backToEmployeeWorkspace();
    }
}
