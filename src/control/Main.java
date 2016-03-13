package control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ConnectionManager;

public class Main extends Application {

    public static Controller controller = new Controller();
    public static Stage myStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/mainView.fxml"));
        primaryStage.setTitle("Hotel management");
        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.show();
        myStage = primaryStage;
    }


    public static void main(String[] args) {
        controller.start();
        launch(args);
        ConnectionManager.getInstance().closeConnection();
    }
}