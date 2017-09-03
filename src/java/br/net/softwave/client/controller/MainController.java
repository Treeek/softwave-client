package br.net.softwave.client.controller;

import br.net.softwave.client.Client;
import br.net.softwave.client.util.ColorTransition;
import br.net.softwave.client.util.ResizeWidthTransition;
import com.jfoenix.controls.JFXHamburger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MainController implements Initializable {
    
    @FXML private BorderPane main;
    @FXML private AnchorPane menu;
    @FXML private Circle perfil;
    @FXML private ToolBar toolBar;
    @FXML private JFXHamburger hamburger;
    
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
        Duration duracao = new Duration(250);
        Region centro = (Region) main.getCenter().lookup("JFXTabPane");
        TranslateTransition deslizaMenu = new TranslateTransition(duracao, menu);
        ResizeWidthTransition redimensionaCentro;
        ParallelTransition parallelTransition;
        
        if (menu.getTranslateX() == 0) {
            deslizaMenu.setToX(-(menu.getWidth()));
            redimensionaCentro = new ResizeWidthTransition(duracao, centro, menu.getWidth() + centro.getWidth());
            parallelTransition = new ParallelTransition(deslizaMenu, redimensionaCentro);
            parallelTransition.play();
        } else {
            deslizaMenu.setToX(0);
            redimensionaCentro = new ResizeWidthTransition(duracao, centro, centro.getWidth() - menu.getWidth());
            parallelTransition = new ParallelTransition(redimensionaCentro, deslizaMenu);
            parallelTransition.play();
        }
    }
    
    @FXML
    private void abrirTelaForuns() {
        ColorTransition ct = new ColorTransition("#4CAF50", toolBar, Duration.millis(500));
        ct.play();
        hamburger.lookupAll("StackPane").forEach((node) -> {
            node.setStyle("-fx-background-color: black;");
        });
    }
    
    @FXML
    private void abrirTelaAreasConhecimento() {
        ColorTransition ct = new ColorTransition("#ffeb3b", toolBar, Duration.millis(500));
        ct.play();
        hamburger.lookupAll("StackPane").forEach((node) -> {
            node.setStyle("-fx-background-color: black;");
        });
    }
    
    @FXML
    private void abrirTelaChat() {
        ColorTransition ct = new ColorTransition("#2196f3", toolBar, Duration.millis(500));
        ct.play();
        hamburger.lookupAll("StackPane").forEach((node) -> {
            node.setStyle("-fx-background-color: white;");
        });
    }
    
    @FXML
    private void abrirTelaAtividades() {
        ColorTransition ct = new ColorTransition("#f44336", toolBar, Duration.millis(500));
        ct.play();
        hamburger.lookupAll("StackPane").forEach((node) -> {
            node.setStyle("-fx-background-color: white;");
        });
    }
    
}
