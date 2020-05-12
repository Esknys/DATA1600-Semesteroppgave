package com.sample.textfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {

    public static void save(String string, File file) throws IOException {
        FileWriter writer = new FileWriter(file, true);
        writer.write(string);
        writer.close();

    }
}
