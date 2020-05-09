package com.sample.binaryfile;

import com.sample.car.Engine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadEngines {

    public static ObservableList<Engine> readEngines(File file) throws IOException {

        ObservableList<Engine> elist = FXCollections.observableArrayList();

        InputStream is = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(is);

        boolean keepReading = true;

        while (keepReading) {
            String line = ois.readUTF();
            Engine e = parseEngine(line);
            elist.add(e);
        }

        return elist;

    }


    public static Engine parseEngine(String content) {

        String[] strings = content.split("::");
        String name = strings[0];
        String fuel = strings[1];
        String horsepower = strings[2];
        String price = strings[3];

        int hp = Integer.parseInt(horsepower);
        int p = Integer.parseInt(price);

        return new Engine(name, fuel, hp, p);

    }

}
