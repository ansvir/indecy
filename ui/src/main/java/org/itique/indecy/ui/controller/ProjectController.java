package org.itique.indecy.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;

public class ProjectController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private void handleShowNewProjectView(ActionEvent e) {
        loadFXML(getClass().getResource("create-project-view.fxml"));
    }

    @FXML
    private void handleShowOpenProjectView(ActionEvent e) {
        loadFXML(getClass().getResource("open-project-view.fxml"));
    }

    @FXML
    private void handleShowHelpView(ActionEvent e) {
        loadFXML(getClass().getResource("help-view.fxml"));
    }

    private void loadFXML(URL url) {
        try {
            FXMLLoader loader = new FXMLLoader(url);
            borderPane.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
