package com.sample.textfile;

import com.sample.car.Car;

public class CarFormatter {


    public static String DELIMITER = "::";

    public static String formatCar(Car c) {


        String fuelName = c.getEngine().getName();
        String fuel = c.getEngine().getFuel();
        String horseposer = Integer.toString(c.getEngine().getHorsepower());
        String enginePrice = Integer.toString(c.getEngine().getPrice());
        String gearboxName = c.getGearbox().getName();
        String gearboxType = c.getGearbox().getType();
        String gearboxPrice = Integer.toString(c.getGearbox().getPrice());
        String paintjobName = c.getPaintjob().getName();
        String color = c.getPaintjob().getColor();
        String type = c.getPaintjob().getType();
        String paintjobPrice = Integer.toString(c.getPaintjob().getPrice());
        String wheelName = c.getWheel().getName();
        String wheelType = c.getWheel().getType();
        String wheelSize = Integer.toString(c.getWheel().getSize());
        String wheelPrice = Integer.toString(c.getWheel().getPrice());


        return "\n" + fuelName + DELIMITER + fuel + DELIMITER + horseposer + DELIMITER + enginePrice +
                DELIMITER + gearboxName + DELIMITER + gearboxType + DELIMITER + gearboxPrice +
                DELIMITER + paintjobName + DELIMITER + color + DELIMITER + type + DELIMITER + paintjobPrice +
                DELIMITER + wheelName + DELIMITER + wheelType + DELIMITER + wheelSize + DELIMITER + wheelPrice;
    }
}
