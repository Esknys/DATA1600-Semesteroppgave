package com.sample.file;

import com.sample.car.Car;
import com.sample.car.Engine;
import com.sample.car.Gearbox;
import com.sample.car.Paintjob;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public ArrayList<Car> readCars(File file)
            throws IOException
    {
        ArrayList<Car> clist = new ArrayList<>();

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
        if(split.length != 11) {
            throw new InvalidCarFormatException("Must use two colons to separate the five data fields");
        }

        String fuelName = split[0];
        String fuel = split[1];
        String horsepower = split[2];
        String enginePrice = split[3];
        String gearboxName = split[4];
        String gearboxType = split[5];
        String gearboxPrice = split[6];
        String paintjobName = split[7];
        String color = split[8];
        String type = split[9];
        String paintjobPrice = split[10];

        Integer paintjobPrice1 = Integer.valueOf(paintjobPrice);
        Integer enginePrice1 = Integer.valueOf(enginePrice);
        Integer gearboxPrice1 = Integer.valueOf(gearboxPrice);
        Integer horsepower1 = Integer.valueOf(horsepower);

        Engine engine = new Engine(fuelName, fuel, horsepower1, enginePrice1);
        Gearbox gearbox = new Gearbox(gearboxName, gearboxPrice1, gearboxType);
        Paintjob paintjob = new Paintjob(paintjobName, paintjobPrice1, color, type);

        return new Car(engine, gearbox, paintjob);
    }

}
