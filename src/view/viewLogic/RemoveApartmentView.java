package view.viewLogic;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 18/03/2016.
 */
public class RemoveApartmentView extends View {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML TextField txtApNumber;
    @FXML
    public void removeApartment() {
        controller.removeApartment(txtApNumber.getText());
    }

    @Override
    public void backToEmployeeWorkspace() {
        super.backToEmployeeWorkspace();
    }

}
