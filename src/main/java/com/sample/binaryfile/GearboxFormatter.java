package com.sample.binaryfile;

import com.sample.car.Gearbox;

public class GearboxFormatter {

    public static String DELIMITER = "::";

   public static String formatGearbox(Gearbox g) {

       String name = g.getName();
       String price = Integer.toString(g.getPrice());
       String type = g.getType();

       return "\n" + name + DELIMITER + price + DELIMITER + type;

    }
}
