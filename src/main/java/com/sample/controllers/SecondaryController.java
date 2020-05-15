package com.sample.controllers;

import java.io.IOException;

import com.sample.App;
import com.sample.exeptions.InputException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private PasswordField passwordfieldid;

    @FXML
    private Text brukerid;

    @FXML
    private Text passid;

    @FXML
    private Button logginnansattid;

    @FXML
    private Label labelwronginput;

    @FXML
    private void changeToMainView() throws IOException {
        App.changeView("mainview.fxml");
    }

    @FXML
    void logginnansattaction(ActionEvent event) throws IOException {

        String brukernavn = brukerfeltid.getText();
        String passord = passwordfieldid.getText();

        if (brukernavn.equals("superbruker") && passord.equals("superpassord")) {
            App.changeView("addon.fxml");
        } else {
            labelwronginput.setText("Feil brukernavn og/eller passord");
            }
    }



}








