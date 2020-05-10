package com.sample.binaryfile;

import com.sample.car.Paintjob;

public class PaintjobFormatter {

    public static String DELIMITER = "::";

    public static String formatPaintjob(Paintjob p) {

        String name = p.getName();
        String price = Integer.toString(p.getPrice());
        String color = p.getColor();
        String type = p.getType();

        return "\n" + name + DELIMITER + price + DELIMITER + color + DELIMITER + type;

    }

}

