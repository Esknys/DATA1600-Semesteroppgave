package com.sample.binaryfile;

import com.sample.car.Gearbox;

import java.io.*;
import java.util.List;

public class WriteGearboxes {

    public static void write(File file, List<Gearbox> gearboxes) {

        try (OutputStream os = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(os);) {

            oos.writeObject(gearboxes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
