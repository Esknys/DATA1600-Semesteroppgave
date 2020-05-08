package com.sample.binaryfile;

import com.sample.car.Engine;

public class EngineFormatter {

    public static String DELIMITER = "::";

    public static String formatEngine(Engine e) {

        String name = e.getName();
        String fuel = e.getFuel();
        String horsepower = Integer.toString(e.getHorsepower());
        String price = Integer.toString(e.getPrice());

        return "\n" + name + DELIMITER + fuel + DELIMITER + horsepower + DELIMITER + price;

    }

}
