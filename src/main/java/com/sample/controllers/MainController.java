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
        private Button kundelogginnid;

        @FXML
        private Text bilbutikktxtid;

        @FXML
        private Label primaryviewid;

        @FXML
        private Text kundeinnloggingtxtid;

        @FXML
        private TextField brukernavnfieldid;

        @FXML
        private Text brukernavntxtid;

        @FXML
        private TextField passordfieldid;

        @FXML
        private Text passordtxtid;

        @FXML
        private Button mainButton;

        @FXML
        private void changeToSecondaryView() throws IOException {
            App.changeView("secondaryview.fxml");
        }

        @FXML
        void klogginnaction(ActionEvent event) {

        }

        @FXML
        void kundebrukeraction(ActionEvent event) {

        }

        @FXML
        void kundepassordaction(ActionEvent event) {

        }




    }




