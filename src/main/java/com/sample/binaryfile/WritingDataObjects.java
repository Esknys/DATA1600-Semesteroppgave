package com.sample.binaryfile;

import com.sample.car.Engine;

import java.io.*;
import java.util.List;

public class WritingDataObjects {

    public static void write(File file, String formatted) {

        try (OutputStream os = new FileOutputStream(file, true);
             ObjectOutputStream oos = new ObjectOutputStream(os);) {

            oos.writeObject(formatted);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
