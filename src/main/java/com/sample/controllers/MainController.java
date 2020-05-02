package com.sample.controllers;

import java.io.IOException;

import com.sample.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainController {

    @FXML
    private Text bilbutikktxtid;

    @FXML
    private Label primaryviewid;

    @FXML
    private Text kundeinnloggingtxtid;

    @FXML
    private TextField txtBrukernavn;

    @FXML
    private Text brukernavntxtid;

    @FXML
    private TextField txtPassord;

    @FXML
    private Text passordtxtid;

    @FXML
    private Button mainButton;

    @FXML
    private Button loggInnKnapp;


    @FXML
    private void changeToSecondaryView() throws IOException {
        App.changeView("secondaryview.fxml");
    }

    @FXML
    private void loggInn(ActionEvent event) throws IOException {

        String brukernavn = txtBrukernavn.getText();
        String passord = txtPassord.getText();

        if (brukernavn.equals("Brukernavn") && passord.equals("Passord")) {

            App.changeView("sluttbruker.fxml");
        }
    }


}


