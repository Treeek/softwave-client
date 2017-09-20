package br.net.softwave.client.util;

import com.jfoenix.skins.JFXTabPaneSkin;
import com.sun.javafx.scene.control.behavior.TabPaneBehavior;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

public class CustomTab extends Tab {

    public CustomTab(String text) {
        super(text);
        setClosable(true);
        setContent(new AnchorPane());
        ContextMenu contextMenu = new ContextMenu();
        MenuItem closeItem = new MenuItem("Fechar");
        closeItem.setOnAction((event) -> {
            TabPaneBehavior behavior = ((JFXTabPaneSkin) getTabPane().getSkin()).getBehavior();

            if (behavior.canCloseTab(this)) {
                behavior.closeTab(this);
            }
        });
        contextMenu.getItems().add(closeItem);
        setContextMenu(contextMenu);
    }

}
