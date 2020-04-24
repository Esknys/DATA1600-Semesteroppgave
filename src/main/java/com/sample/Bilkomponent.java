package com.sample;

import javafx.beans.property.StringProperty;
import javafx.scene.control.TreeItem;

import java.util.LinkedList;

public class Bilkomponent {

    private String name;

    private LinkedList<String> choices;

    public Bilkomponent(String name, LinkedList<String> choices) {
        this.name = name;
        this.choices = choices;
    }

    public void setName(String value) {
        name = value;
    }

    public String getName() {
        return name;
    }

    public TreeItem createTreeItem() {

        TreeItem<String> root = new TreeItem<String>(name);

        for (String choice : choices) {
            TreeItem<String> itemChild = new TreeItem<>(choice);
            itemChild.setExpanded(false);

            root.getChildren().add(itemChild);
        }
        return root;
    }



}