package view.viewLogic;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 06/03/2016.
 */
public class ManagerView extends View {

    private static Stage window;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void backToMainScene() {
        window.close();
        super.backToMainScene();
    }

    @FXML
    public void addEmployeeView() {
        changeScene("../../view/addEmployeeView.fxml", 435, 300);
    }


    @FXML
    public void fireEmployeeView() {
        changeScene("../../view/fireEmployeeView.fxml", 360, 160);
    }

    @FXML
    public void managerLogOut() {
        Parent root = null;
        window = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("../../view/managerLogOut.fxml"));
            window.setScene(new Scene(root, 244, 79));
            window.centerOnScreen();
            window.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void seeEmployeesView() {
        changeScene("../../view/seeAllEmployeesView.fxml");
    }

    @FXML
    public void closeWindow() {
        window.close();
    }
}
