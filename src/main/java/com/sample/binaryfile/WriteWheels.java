package com.sample.binaryfile;

import com.sample.car.Wheel;

import java.io.*;
import java.util.List;

public class WriteWheels {

    public static void write(File file, List<Wheel> wheels) {

        try (OutputStream os = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(os);) {

            oos.writeObject(wheels);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
