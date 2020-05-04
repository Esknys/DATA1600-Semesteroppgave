package com.sample.binaryfile;

import com.sample.car.Part;

import java.io.*;
import java.util.List;

public class ReadingDataObjects {

    public static List<Part> read(File file) {
        try (InputStream is = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(is);) {

            @SuppressWarnings("unchecked")
            List<Part> parts = (List<Part>).ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
