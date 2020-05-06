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
    private VBox ExistingPartsid;


    @FXML
    private TableView<?> ExistingPartsTableView;

    @FXML
    private TableColumn<?, ?> TableViewEngine;

    @FXML
    private TableColumn<?, ?> TableViewGearbox;

    @FXML
    private TableColumn<?, ?> TableViewPaint;

    @FXML
    private Label labelid;

    @FXML
    private Line line2id;

    @FXML
    private Line line1id;

    @FXML
    private Text introtxtid;

    @FXML
    private Button ExcistingPartsID;

    @FXML
    void showpartsactionid(ActionEvent event) {

        popupid.setText("Hei dette er test");


    }

    @FXML
    private Button Backadminid;

    @FXML
    void BackActionID(ActionEvent event) throws IOException {
        App.changeView("secondaryview.fxml");
    }

    @FXML
    private Label popupid;


}