package com.sample.binaryfile;

import com.sample.car.Paintjob;

import java.io.*;
import java.util.List;

public class WritePaintjobs {

    public static void write(File file, List<Paintjob> paintjobs) {

        try (OutputStream os = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(os);) {

            oos.writeObject(paintjobs);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
