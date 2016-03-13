package view.viewLogic;

import control.Controller;
import control.Hotel;
import control.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DataManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 04/03/2016.
 */

public class View implements Initializable {

    protected Controller controller = new Controller();
    protected static DataManager dataManager = new DataManager();

    @FXML
    private Label lbTitle;

    public View() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lbTitle.setText("Bine ai venit la " + Hotel.getHotelName());
    }

    @FXML
    public void loginView() {
        changeScene("../../view/login.fxml", 470, 285);
    }

    public void changeScene(String scenePath, int width, int height) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(scenePath));
            Main.myStage.setScene(new Scene(root, width, height));
            Main.myStage.centerOnScreen();
            Main.myStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeScene(String scenePath) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(scenePath));
            Main.myStage.setScene(new Scene(root));
            Main.myStage.centerOnScreen();
            Main.myStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeScene(Stage stage, String scenePath) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(scenePath));
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void backToMainScene() {
        System.out.println("Log out succesfully");
        changeScene("../../view/mainView.fxml", 650, 400);
    }

    @FXML
    public void backToEmployeeWorkspace() {
        changeScene("../../view/employeeWorkspace.fxml");
    }

    @FXML
    public void closeProgram() {
        System.exit(-1);
    }

}
