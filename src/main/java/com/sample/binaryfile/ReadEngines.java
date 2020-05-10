package com.sample.binaryfile;

import com.sample.car.Engine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadEngines {

  /*  public static List<Engine> readEngines(File file) throws Exception {

        List<Engine> enginesList = new ArrayList<>();

      try (InputStream is = new FileInputStream(file);
      ObjectInputStream ois = new ObjectInputStream(is);) {

          @SuppressWarnings("unchecked")
          List<Engine> engines = (List<Engine>)ois.readObject();
          engines.forEach();

      } catch (IOException | ClassNotFoundException e) {}

      return enginesList;
    }

*/

}
