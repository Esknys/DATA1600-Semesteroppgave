package com.sample.controllers;

import java.io.IOException;
import java.time.Year;

import com.sample.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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
    private PasswordField Pasfieldid;

    @FXML
    private Text passordtxtid;

    @FXML
    private Button mainButton;

    @FXML
    private Button loggInnKnapp;

    @FXML
    private ImageView carpictureid;

    @FXML
    private Label exceptionid;

    @FXML
    private Pane paneid;

    @FXML
    private void changeToSecondaryView() throws IOException {
        App.changeView("secondaryview.fxml");
    }

    @FXML
    private Text data1600id;

    @FXML
    private Text kildebildeid;

    @FXML
    void pasactionid(ActionEvent event) {

    }

    @FXML
    private void loggInn(ActionEvent event) throws IOException {

        String brukernavn = txtBrukernavn.getText();
        String passord = Pasfieldid.getText();

      /*  if (brukernavn.equals("Brukernavn") && passord.equals("Passord")) {*/
            App.changeView("sluttbruker.fxml");
      /*
    } else {
            exceptionid.setText("Feil passord og/eller brukernavn");
        }

       */
}

    }

    // exceptionid.setText("Feil passord og/eller brukernavn"))



