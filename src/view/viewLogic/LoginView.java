package view.viewLogic;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 06/03/2016.
 */
public class LoginView extends View {

    protected static String profile;

    @FXML
    private  TextField txtUsername;
    @FXML
    private  PasswordField pwdPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void accessEmployee() {
        profile = txtUsername.getText();
        String username = txtUsername.getText();
        String password = pwdPassword.getText();
        controller.validateEmployee(username, password);
    }

    @FXML
    public void accesManager() {
        String username = txtUsername.getText();
        String password = pwdPassword.getText();
        controller.validateManager(username, password);
    }

    @FXML
    public void managerWorkspaceView() {
        changeScene("../../view/managerWorkspace.fxml");
    }

    @FXML
    public void employeeWorkspaceView() {
        changeScene("../../view/employeeWorkspace.fxml");
    }
}
