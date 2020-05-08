package com.sample.controllers;

import com.sample.App;
import com.sample.car.Engine;
import com.sample.car.Gearbox;
import com.sample.car.Paintjob;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class SuperStart {

    @FXML
    private AnchorPane anchorid;

    @FXML
    private Label labelid;

    @FXML
    private Line line2id;

    @FXML
    private Line line1id;

    @FXML
    private Text introtxtid;


    @FXML
    private Button Backadminid;


    @FXML
    private Button addonbutton;

    @FXML
    private Button deletebutton;

    @FXML
    void BackActionID(ActionEvent event) throws IOException {
        App.changeView("secondaryview.fxml");
    }

    @FXML
    void addonaction(ActionEvent event) throws IOException {
            App.changeView("addon.fxml");
    }

    @FXML
    void deleteaction(ActionEvent event) {

    }



}