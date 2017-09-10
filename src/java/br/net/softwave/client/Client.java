package br.net.softwave.client;

import awesomeui.animation.FadeInTransition;
import br.net.softwave.client.util.Screen;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Client extends Application {
    
    public static final String ENDERECO_SERVIDOR = "http://localhost:8080/server/";
    public static final String ENDERECO_SERVICE = ENDERECO_SERVIDOR + "service/";
    public static final String ENDERECO_USUARIO = ENDERECO_SERVICE + "usuario/";
    public static final String ENDERECO_LOGIN = ENDERECO_SERVICE + "login/";
    
    public static final String ENDERECO_FXML_LOGIN = "view/login/Login.fxml";
    public static final String ENDERECO_FXML_MAIN = "view/main/Main.fxml";
    public static final String ENDERECO_FXML_MAIN_FORUNS = "view/main/foruns/Foruns.fxml";
    public static final String ENDERECO_FXML_MAIN_AREASCONHECIMENTO = "view/main/areasconhecimento/AreasConhecimento.fxml";
    public static final String ENDERECO_FXML_MAIN_CHAT = "view/main/chat/Chat.fxml";
    public static final String ENDERECO_FXML_MAIN_ATIVIDADES = "view/main/atividades/Atividades.fxml";
    public static final String ENDERECO_IMG_ICON = "view/img/icon.png";

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Carrega o ícone do aplicativo
        
        Screen.mainScene(primaryStage);
        
        /*Image icon = new Image(getClass().getResourceAsStream(ENDERECO_IMG_ICON));
        
        // Inicializa a página de login
        Parent loginRoot = FXMLLoader.load(getClass().getResource(ENDERECO_FXML_LOGIN));
        
        Scene loginScene = new Scene(loginRoot);
        
        primaryStage.setTitle("SoftWave | Login");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(loginScene);
        primaryStage.getScene().getRoot().setStyle("-fx-background-color: transparent;");
        primaryStage.getScene().setFill(null);
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
                
        loginRoot.setOpacity(0);
        
        new FadeInTransition(loginRoot)
                .setDuration(Duration.seconds(1))
                .play();*/
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
