package com.sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;


public class KundeStart {

    @FXML
    private AnchorPane anchor;

    @FXML
    private TreeView<String> treeView;

    @FXML
    void showTree(ActionEvent event) {

        createTree();


    }

    public void createTree(String... rootItems) {

        TreeItem<String> root = new TreeItem<>("Root");

        TreeItem<String> itemChild = new TreeItem<>("Child");
        itemChild.setExpanded(false);

        root.getChildren().add(itemChild);
        treeView.setRoot(root);

    }



}
