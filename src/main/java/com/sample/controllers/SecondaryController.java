package com.sample.controllers;

import java.io.IOException;

import com.sample.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class SecondaryController {

    @FXML
    public Button secondaryButton;

    @FXML
    private AnchorPane anchorpaneid;

    @FXML
    private Label ansattinnloggingid;

    @FXML
    private TextField brukerfeltid;

    @FXML
    private TextField passordfeltid;

    @FXML
    private Text brukerid;

    @FXML
    private Text passid;

    @FXML
    private Button logginnansattid;

    @FXML
    private void changeToMainView() throws IOException {
        App.changeView("mainview.fxml");
    }

    @FXML
    void logginnansattaction(ActionEvent event) throws IOException {

        String brukernavn = brukerfeltid.getText();
        String passord = passordfeltid.getText();

        if (brukernavn.equals("Superbruker") && passord.equals("Superpassord")) {
            App.changeView("superStart.fxml");
        }
    }


}


