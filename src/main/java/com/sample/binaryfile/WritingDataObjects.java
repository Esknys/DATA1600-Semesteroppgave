package com.sample.binaryfile;

import com.sample.car.Engine;

import java.io.*;
import java.util.List;

public class WritingDataObjects {

    public static void write(File file, List parts) {

        try (OutputStream os = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(os);) {

            oos.writeObject(parts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
