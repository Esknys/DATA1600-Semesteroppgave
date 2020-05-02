package com.sample.file;

import com.sample.car.Car;
import com.sample.car.Gearbox;

public class CarFormatter {


    public static String DELIMITER = "::";

    public static String formatCar(Car c) {


        String fuelName = c.engine.getName();
        String fuel = c.engine.getFuel();
        String horseposer = Integer.toString(c.engine.getHorsepower());
        String enginePrice = Integer.toString(c.engine.getPrice());
        String gearboxName = c.gearbox.getName();
        String gearboxType = c.gearbox.getType();
        String gearboxPrice = Integer.toString(c.gearbox.getPrice());
        String paintjobName = c.paintjob.getName();
        String color = c.paintjob.getColor();
        String type = c.paintjob.getType();
        String paintjobPrice = Integer.toString(c.paintjob.getPrice());


        return "\n" + fuelName + DELIMITER + fuel + DELIMITER + horseposer + DELIMITER + enginePrice + DELIMITER + gearboxName + DELIMITER + gearboxType + DELIMITER + gearboxPrice + DELIMITER + paintjobName + DELIMITER + color + DELIMITER + type + DELIMITER + paintjobPrice;
    }
}
