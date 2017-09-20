package br.net.softwave.client.util;

import awesomeui.animation.FadeInUpTransition;
import br.net.softwave.client.Client;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Screen {

    public static void loginScene(Stage primaryStage) throws IOException {
        Parent loginRoot = FXMLLoader.load(Client.class.getResource(Client.ENDERECO_FXML_LOGIN));
        Scene loginScene = new Scene(loginRoot);

        primaryStage.setTitle("SoftWave | Login");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(loginScene);
        primaryStage.getScene().getRoot().setStyle("-fx-background-color: transparent;");
        primaryStage.getScene().setFill(null);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void mainScene(Stage primaryStage) throws IOException {
        Parent mainRoot = FXMLLoader.load(Client.class.getResource(Client.ENDERECO_FXML_MAIN));
        Scene mainScene = new Scene(mainRoot);
        
        primaryStage.setTitle("SoftWave | Home");
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(true);
        primaryStage.centerOnScreen();
        primaryStage.setMaximized(true);
        primaryStage.show();
        
        new FadeInUpTransition(mainRoot)
                .setDuration(Duration.millis(500))
                .play();
    }
    
}
