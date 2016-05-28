package view.viewLogic;

import control.ActivityTracker;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 07/03/2016.
 */
public class employeeLogOut extends View {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void backToMainScene() {
        EmployeeView.window.close();
        ActivityTracker.recordAllActivities();
        super.backToMainScene();
    }

    @FXML
    public void backToEmployeeWorkspace() {
        EmployeeView.window.close();
        changeScene("../../view/employeeWorkspace.fxml");
    }
}
