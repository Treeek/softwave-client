package br.net.softwave.client.controller;

import br.net.softwave.client.Client;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MainController implements Initializable {
    
    @FXML private BorderPane main;
    @FXML private AnchorPane menu;
    @FXML private Circle perfil;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Image perfilImagem = new Image(Client.class.getResourceAsStream("view/img/profile.jpg"), 40, 40, false, true); // devera carregar uma imagem do servidor e nao local
            perfil.setFill(new ImagePattern(perfilImagem));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @FXML
    private void onclickHambuger() {
        TranslateTransition deslizaMenu = new TranslateTransition(Duration.millis(125), menu);
        
        if (menu.getTranslateX() == 0) {
            deslizaMenu.setToX(-(menu.getWidth()));
            deslizaMenu.play();
        } else {
            deslizaMenu.setToX(0);
            deslizaMenu.play();
        }
    }
    
}
