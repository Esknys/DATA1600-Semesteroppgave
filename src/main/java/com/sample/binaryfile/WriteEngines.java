package com.sample.binaryfile;

import com.sample.car.Engine;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteEngines {

    public static void write(File file, List<Engine> engines) {

        try (OutputStream os = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(os);) {

            oos.writeObject(engines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
