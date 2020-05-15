package com.sample.controllers;

import com.sample.binaryfile.*;
import javafx.concurrent.Task;

import java.io.File;
import java.io.IOException;
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
            } catch (InterruptedException e) {
            }


            switch (tag) {
                case "Engine":
                    WriteEngines.write(this.file, (ArrayList)this.listOfObjects);
                    break;
                case "Gearbox":
                    WriteGearboxes.write(this.file, (ArrayList)this.listOfObjects);
                    break;
                case "Paintjob":
                    WritePaintjobs.write(this.file, (ArrayList)this.listOfObjects);
                    break;
                case "Wheel":
                    WriteWheels.write(this.file, (ArrayList)this.listOfObjects);
                    break;
                case "Accessory":
                    WriteAccessories.write(this.file, (ArrayList)this.listOfObjects);
                    break;
                default:
                    throw new IOException();
            }

            return "Yes";
        }
    }
