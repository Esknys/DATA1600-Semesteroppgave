package com.sample.binaryfile;

import java.io.*;
import java.util.ArrayList;

public class WritingDataObjects {

    public static void write(File file, ArrayList parts) {

        try (OutputStream os = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(os);) {

            oos.writeObject(parts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
