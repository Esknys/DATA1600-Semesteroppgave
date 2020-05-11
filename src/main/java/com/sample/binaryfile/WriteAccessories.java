package com.sample.binaryfile;

import com.sample.car.Accessory;

import java.io.*;
import java.util.List;

public class WriteAccessories {

    public static void write(File file, List<Accessory> accessories) {

        try (OutputStream os = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(os);) {

            oos.writeObject(accessories);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
