package com.sample.file;

import com.sample.car.Car;
import com.sample.car.Engine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {

 /*   public ObservableList<Car> readCars(File file)
            throws IOException
    {
        ObservableList<Car> clist = FXCollections.observableArrayList();

        try (Scanner myReader = new Scanner(file)) {

            while(myReader.hasNextLine()) {
                String line = myReader.nextLine();
                Car c = FileReader.parseCar(line);
                clist.add(c);
            }
        }
        return clist;
    }

    private static Car parseCar(String line)
            throws InvalidCarFormatException {
        String[] split = line.split(CarFormatter.DELIMITER);
        if(split.length != 3) {
            throw new InvalidCarFormatException("Must use two colons to separate the five data fields");
        }

        String engine = split[0];
        String gearbox = split[1];
        String paintjob = split[2];


        return new Car(engine, gearbox, paintjob);
    }

    public void attachTableView(TableView tv, ObservableList<Car> cars) {
        tv.setItems(cars);
    }*/


}
