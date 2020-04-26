package com.sample.file;

import com.sample.car.Car;

public class CarFormatter {


    public static String DELIMITER = "::";

    public static String formatCar(Car c) {

        String egnine = c.engine.toString();
        String gearbox = c.gearbox.toString();
        String paintjob = c.paintjob.toString();

        return "\n" + egnine + DELIMITER + gearbox + DELIMITER + paintjob;
    }
}
