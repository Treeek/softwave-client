package br.net.softwave.client.controller;

import br.net.softwave.client.Client;
import br.net.softwave.client.util.ResizeWidthTransition;
import br.net.softwave.client.util.CustomTab;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MainController implements Initializable {

    @FXML
    private BorderPane main;
    @FXML
    private AnchorPane menu;
    @FXML
    private Circle perfil;
    @FXML
    private ToolBar toolBar;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXTabPane tabMain;
    @FXML
    private JFXButton forunsButton;
    @FXML
    private JFXButton areasConhecimentoButton;
    @FXML
    private JFXButton chatButton;
    @FXML
    private JFXButton atividadesButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Set<Node> buttons = menu.lookupAll("JFXButton");
        buttons.forEach((button) -> {
            ((JFXButton) button).setContextMenu(new OpenOptionsContextMenu(button));
        });

        CustomTab tab = new CustomTab("Home");
        tabMain.getTabs().add(tab);
        tabMain.getSelectionModel().select(tab);

        try {
            Image perfilImagem = new Image(Client.class.getResourceAsStream("view/img/profile.jpg"), 40, 40, false, true); // devera carregar uma imagem do servidor e nao local
            perfil.setFill(new ImagePattern(perfilImagem));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private class OpenOptionsContextMenu extends ContextMenu {

        public OpenOptionsContextMenu(Node node) {
            MenuItem openItem = new MenuItem("Abrir");
            MenuItem openInANewTabItem = new MenuItem("Abrir em uma nova aba");
            openItem.setOnAction((event) -> {
                String id = node.getId();

                if (tabMain.getTabs().isEmpty()) {
                    CustomTab newTab;

                    switch (id) {
                        case "forunsButton":
                            newTab = new CustomTab("Foruns");
                            tabMain.getTabs().add(newTab);
                            tabMain.getSelectionModel().select(newTab);
                            showForuns(newTab);
                            break;
                        case "areasConhecimentoButton":
                            newTab = new CustomTab("Áreas do conhecimento");
                            tabMain.getTabs().add(newTab);
                            tabMain.getSelectionModel().select(newTab);
                            showAreasconhecimento(newTab);
                            break;
                        case "chatButton":
                            newTab = new CustomTab("Chat");
                            tabMain.getTabs().add(newTab);
                            tabMain.getSelectionModel().select(newTab);
                            showChat(newTab);
                            break;
                        case "atividadesButton":
                            newTab = new CustomTab("Atividades");
                            tabMain.getTabs().add(newTab);
                            tabMain.getSelectionModel().select(newTab);
                            showAtividades(newTab);
                            break;
                    }
                } else {
                    Tab actualTab = tabMain.getSelectionModel().getSelectedItem();

                    switch (id) {
                        case "forunsButton":
                            actualTab.setText("Foruns");
                            showForuns(actualTab);
                            break;
                        case "areasConhecimentoButton":
                            actualTab.setText("Áreas do conhecimento");
                            showAreasconhecimento(actualTab);
                            break;
                        case "chatButton":
                            actualTab.setText("Chat");
                            showChat(actualTab);
                            break;
                        case "atividadesButton":
                            actualTab.setText("Atividades");
                            showAtividades(actualTab);
                            break;
                    }
                }
            });

            openInANewTabItem.setOnAction((event) -> {
                CustomTab newTab;

                switch (node.getId()) {
                    case "forunsButton":
                        newTab = new CustomTab("Foruns");
                        tabMain.getTabs().add(newTab);
                        tabMain.getSelectionModel().select(newTab);
                        showForuns(newTab);
                        break;
                    case "areasConhecimentoButton":
                        newTab = new CustomTab("Áreas do conhecimento");
                        tabMain.getTabs().add(newTab);
                        tabMain.getSelectionModel().select(newTab);
                        showAreasconhecimento(newTab);
                        break;
                    case "chatButton":
                        newTab = new CustomTab("Chat");
                        tabMain.getTabs().add(newTab);
                        tabMain.getSelectionModel().select(newTab);
                        showChat(newTab);
                        break;
                    case "atividadesButton":
                        newTab = new CustomTab("Atividades");
                        tabMain.getTabs().add(newTab);
                        tabMain.getSelectionModel().select(newTab);
                        showAtividades(newTab);
                        break;
                }
            });
            
            getItems().addAll(openItem, openInANewTabItem);
        }

    }

    @FXML
    private void onclickHambuger() {
        Duration duracao = new Duration(250);
        TranslateTransition deslizaMenu = new TranslateTransition(duracao, menu);
        ResizeWidthTransition redimensionaCentro;
        ParallelTransition parallelTransition;

        if (menu.getTranslateX() == 0) {
            deslizaMenu.setToX(-(menu.getWidth()));
            redimensionaCentro = new ResizeWidthTransition(duracao, tabMain, menu.getWidth() + tabMain.getWidth());
            parallelTransition = new ParallelTransition(deslizaMenu, redimensionaCentro);
            parallelTransition.play();
        } else {
            deslizaMenu.setToX(0);
            redimensionaCentro = new ResizeWidthTransition(duracao, tabMain, tabMain.getWidth() - menu.getWidth());
            parallelTransition = new ParallelTransition(redimensionaCentro, deslizaMenu);
            parallelTransition.play();
        }
    }

    private void showForuns(Tab tab) {
        try {
            Pane root = FXMLLoader.load(Client.class.getResource(Client.ENDERECO_FXML_MAIN_FORUNS));

            root.prefWidthProperty().bind(tabMain.widthProperty());
            root.prefHeightProperty().bind(tabMain.heightProperty());

            tab.setContent(root);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showAreasconhecimento(Tab tab) {
        try {
            Pane root = FXMLLoader.load(Client.class.getResource(Client.ENDERECO_FXML_MAIN_AREASCONHECIMENTO));

            root.prefWidthProperty().bind(tabMain.widthProperty());
            root.prefHeightProperty().bind(tabMain.heightProperty());

            tab.setContent(root);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showChat(Tab tab) {
        try {
            Pane root = FXMLLoader.load(Client.class.getResource(Client.ENDERECO_FXML_MAIN_CHAT));

            root.prefWidthProperty().bind(tabMain.widthProperty());
            root.prefHeightProperty().bind(tabMain.heightProperty());

            tab.setContent(root);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showAtividades(Tab tab) {
        try {
            Pane root = FXMLLoader.load(Client.class.getResource(Client.ENDERECO_FXML_MAIN_ATIVIDADES));

            root.prefWidthProperty().bind(tabMain.widthProperty());
            root.prefHeightProperty().bind(tabMain.heightProperty());

            tab.setContent(root);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleForuns() {
        showForuns(tabMain.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void handleAreasConhecimento() {
        showAreasconhecimento(tabMain.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void handleChat() {
        showChat(tabMain.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void handleAtividades() {
        showAtividades(tabMain.getSelectionModel().getSelectedItem());
    }

}
