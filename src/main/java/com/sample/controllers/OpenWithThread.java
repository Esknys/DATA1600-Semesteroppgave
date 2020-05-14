package com.sample.controllers;

import com.sample.binaryfile.WriteAccessories;
import com.sample.binaryfile.WriteEngines;
import com.sample.binaryfile.WriteGearboxes;
import com.sample.car.Accessory;
import javafx.concurrent.Task;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


public class OpenWithThread extends Task {

    String tag;
    ArrayList<?> listOfObjects;
    File file;


    public OpenWithThread(String tag, File file, ArrayList<?> listOfObjects) {
        this.listOfObjects = listOfObjects;
        this.tag = tag;
        this.file = file;
    }

    @Override
    protected String call() throws InterruptedException, IOException {

        try {

            Thread.sleep(3000);

            switch (tag) {
                case "Engine":
                    WriteEngines.write(this.file, (ArrayList)this.listOfObjects);
                    break;
                case "Gearbox":
                    WriteGearboxes.write(this.file, (ArrayList)this.listOfObjects);
                    break;
                case "Paintjob":
                    WriteGearboxes.write(this.file, (ArrayList)this.listOfObjects);
                    break;
                case "Wheel":
                    WriteGearboxes.write(this.file, (ArrayList)this.listOfObjects);
                    break;
                case "Accessory":
                    WriteAccessories.write(this.file, (ArrayList)this.listOfObjects);
                    break;
                default:
                    throw new IOException();
            }

        } catch (InterruptedException e) {

        }



        return "Yes";
    }
}





