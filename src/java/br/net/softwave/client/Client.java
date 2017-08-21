package br.net.softwave.client;

import awesomeui.animation.FadeInTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Client extends Application {
    
    public static final String ENDERECO_SERVIDOR = "http://localhost:8080/";
    public static final String ENDERECO_API = ENDERECO_SERVIDOR + "api/";
    public static final String ENDERECO_API_USUARIO = ENDERECO_API + "usuario/";
    public static final String ENDERECO_API_TEST = ENDERECO_API + "right/";

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega o ícone do aplicativo
        Image icon = new Image(getClass().getResourceAsStream("view/img/icon.png"));
        
        // Inicializa a página de login
        Parent loginRoot = FXMLLoader.load(getClass().getResource("view/login/Login.fxml"));
        
        Scene loginScene = new Scene(loginRoot);
        
        primaryStage.setTitle("SoftWave | Login");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(loginScene);
        primaryStage.getScene().getRoot().setStyle("-fx-background-color: transparent;");
        primaryStage.getScene().setFill(null);
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.show();
                
        loginRoot.setOpacity(0);
        
        new FadeInTransition(loginRoot)
                .setDuration(Duration.millis(500))
                .play();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
