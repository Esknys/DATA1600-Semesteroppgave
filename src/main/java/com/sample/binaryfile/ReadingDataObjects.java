package com.sample.binaryfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadingDataObjects {

    public static void read(File file) {

        try (InputStream is = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(is);) {

            @SuppressWarnings("unchecked")
            List parts = (List)ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
