package com.sample.controllers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import com.sample.App;
import com.sample.binaryfile.*;
import com.sample.car.*;
import com.sample.exeptions.InputException;
import com.sample.validation.Validation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Addon {

    @FXML
    private AnchorPane Anch1id;

    @FXML
    private AnchorPane anch2id;

    @FXML
    private Pane pane1id;

    @FXML
    private Button engineinputid;

    @FXML
    private TextField enginetextfield;

    @FXML
    private TextField fueltextfield;

    @FXML
    private TextField horsepowertextfield;

    @FXML
    private TextField pricetextfield;


    @FXML
    private TableView<Engine> tableviewengine;

    @FXML
    private TableColumn<Engine, String> enginecol1;

    @FXML
    private TableColumn<Engine, String> enginecol2;

    @FXML
    private TableColumn<Engine, Integer> enginecol3;

    @FXML
    private TableColumn<Engine, Integer> enginecol4;


    @FXML
    private TextFlow txtflowid;

    @FXML
    private Text enginetitleid;


    @FXML
    private TextField motorinput;


    @FXML
    private Pane pane2id;

    @FXML
    private TextField gearboxtextfield;

    @FXML
    private Button gearboxinputid;

    @FXML
    private TableView<Gearbox> tableviewgearbox;

    @FXML
    private TableColumn<Gearbox, String> gearboxcol1;

    @FXML
    private TableColumn<Gearbox, String> gearboxcol2;

    @FXML
    private TableColumn<Gearbox, Integer> gearboxcol3;

    @FXML
    private TextFlow txtflowid2;

    @FXML
    private Text gearboxtitleid;

    @FXML
    private TextField gearboxtextfield2;

    @FXML
    private TextField gearboxtextfield3;

    @FXML
    private Pane pane3id;

    @FXML
    private Button paintinputid;

    @FXML
    private TextField painttextfield;

    @FXML
    private TextField painttextfield2;

    @FXML
    private TextField painttextfield3;

    @FXML
    private TextField painttextfield4;


    @FXML
    private TableView<Paintjob> tableviewpaint;

    @FXML
    private TableColumn<Paintjob, String> paintcol1;

    @FXML
    private TableColumn<Paintjob, String> paintcol2;

    @FXML
    private TableColumn<Paintjob, String> paintcol3;

    @FXML
    private TableColumn<Paintjob, Integer> paintcol4;

    @FXML
    private TextFlow txtflow3;

    @FXML
    private Text painttitleid;


    @FXML
    private Pane pane4id;

    @FXML
    private TextField wheeltextfield;

    @FXML
    private TextField wheeltextfield2;

    @FXML
    private TextField wheeltextfield3;

    @FXML
    private TextField wheeltextfield4;

    @FXML
    private Button wheelinputid;


    @FXML
    private TableView<Wheel> tableviewheel;

    @FXML
    private TableColumn<Wheel, String> wheelcol1;

    @FXML
    private TableColumn<Wheel, String> wheelcol2;

    @FXML
    private TableColumn<Wheel, Integer> wheelcol3;

    @FXML
    private TableColumn<Wheel, Integer> wheelcol4;

    @FXML
    private TextFlow txtflow4;

    @FXML
    private Text wheeltitleid;


    @FXML
    private Pane pane5id;

    @FXML
    private Button extrainputid;

    @FXML
    private TextField extratextfield;

    @FXML
    private TextField extratextfield2;

    @FXML
    private TextField extratextfield3;

    @FXML
    private TableView<Accessory> tableviewextra;

    @FXML
    private TableColumn<Accessory, String> extracol1;

    @FXML
    private TableColumn<Accessory, String> extracol2;

    @FXML
    private TableColumn<Accessory, Integer> extracol3;

    @FXML
    private TextFlow txtflow5;

    @FXML
    private Text extratitleid;

    @FXML
    private Button engineid;

    @FXML
    private Button gearboxid;

    @FXML
    private Button paintid;

    @FXML
    private Button wheelsid;

    @FXML
    private Button extraid;

    @FXML
    private AnchorPane anch3;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img5;

    @FXML
    private Button backbuttonid;

    @FXML
    void BackActionButton(ActionEvent event) throws IOException {
        App.changeView("secondaryview.fxml");
    }

    @FXML
    void EngineInputAction(ActionEvent event) {

        enginecol1.setCellValueFactory(new PropertyValueFactory<>("name"));
        enginecol2.setCellValueFactory(new PropertyValueFactory<>("fuel"));
        enginecol3.setCellValueFactory(new PropertyValueFactory<>("horsepower"));
        enginecol4.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableviewengine.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        if (enginetextfield.getText().isEmpty() && fueltextfield.getText().isEmpty() && horsepowertextfield.getText().isEmpty() && pricetextfield.getText().isEmpty()) {

            try (InputStream is = Files.newInputStream(Paths.get("engines.jobj"), StandardOpenOption.READ);) {

                ObjectInputStream ois = new ObjectInputStream(is);

                ArrayList<Engine> engines = (ArrayList<Engine>) ois.readObject();

                // Vet ikke om den under fungerer
                for (Engine e : engines) {
                    tableviewengine.getItems().add(e);
                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

        } else {

            String engineinput = "";
            String fuelinput = "";

            int hp = 0;
            int price = 0;

            boolean valid = true;

            if (enginetextfield.getText().isEmpty()) {

            }
            if (fueltextfield.getText().isEmpty()) {

            }
            if (horsepowertextfield.getText().isEmpty()) {

            }
            if (pricetextfield.getText().isEmpty()) {

            }

            if (enginetextfield.getText().matches("[A-ZÆØÅ][a-zæøå]*")) {
                engineinput = enginetextfield.getText();
            } else { valid = false; }
            if (fueltextfield.getText().matches("[A-ZÆØÅ][a-zæøå]*")) {
                fuelinput = fueltextfield.getText();
            } else {
                valid = false;
            }
            if (horsepowertextfield.getText().matches("[0-9]*")) {
                hp = Integer.parseInt(horsepowertextfield.getText());
            } else {
                valid = false;
            }
            if (pricetextfield.getText().matches("[0-9]*")) {
                price = Integer.parseInt(pricetextfield.getText());
            } else {
                valid = false;
            }

            if (valid) {

                Engine engine = new Engine(engineinput, fuelinput, hp, price);

                File file = new File("engines.jobj");

                try (InputStream is = Files.newInputStream(Paths.get("engines.jobj"), StandardOpenOption.READ);) {

                    ObjectInputStream ois = new ObjectInputStream(is);

                    ArrayList<Engine> engines = (ArrayList<Engine>) ois.readObject();

                    engines.add(engine);
                    WriteEngines.write(file, engines);

                    // Vet ikke om den under fungerer
                    for (Engine e : engines) {
                        tableviewengine.getItems().add(e);
                    }

                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            } else {

            }
        }
    }


    @FXML
    void GearboxInputAction(ActionEvent event) {

        gearboxcol1.setCellValueFactory(new PropertyValueFactory<>("name"));
        gearboxcol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        gearboxcol3.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableviewgearbox.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        if (gearboxtextfield.getText().isEmpty() && gearboxtextfield2.getText().isEmpty() && gearboxtextfield3.getText().isEmpty()) {

            try (InputStream is = Files.newInputStream(Paths.get("gearboxes.jobj"), StandardOpenOption.READ);) {

                ObjectInputStream ois = new ObjectInputStream(is);

                ArrayList<Gearbox> gearboxes = (ArrayList<Gearbox>) ois.readObject();

                for (Gearbox g : gearboxes) {
                    tableviewgearbox.getItems().add(g);
                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {

            String gearboxinput = "";
            String typeinput = "";

            int price = 0;

            boolean valid = true;

            if (gearboxtextfield.getText().isEmpty()) {}

            if (gearboxtextfield2.getText().isEmpty()) {}

            if (gearboxtextfield3.getText().isEmpty()) {}

            if (gearboxtextfield.getText().matches("[A-ZÆØÅ][a-zæøå]*")) {
                gearboxinput = gearboxtextfield.getText();
            } else {
                valid = false;
            }
            if (gearboxtextfield2.getText().matches("[A-ZÆØÅ][a-zæøå]*")) {
                typeinput = gearboxtextfield2.getText();
            } else {
                valid = false;
            }
            if (gearboxtextfield3.getText().matches("[0-9]*")) {
                price = Integer.parseInt(gearboxtextfield3.getText());
            } else {
                valid = false;
            }

            if (valid) {

                Gearbox gearbox = new Gearbox(gearboxinput, price, typeinput);

                File file = new File("gearboxes.jobj");

                try (InputStream is = Files.newInputStream(Paths.get("gearboxes.jobj"), StandardOpenOption.READ);) {

                    ObjectInputStream ois = new ObjectInputStream(is);

                    ArrayList<Gearbox> gearboxes = (ArrayList<Gearbox>) ois.readObject();

                    gearboxes.add(gearbox);
                    WriteGearboxes.write(file, gearboxes);

                    for (Gearbox g : gearboxes) {
                        tableviewgearbox.getItems().add(g);
                    }

                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            } else {

            }
        }
    }

    @FXML
    void PaintInputAction(ActionEvent event) {

        paintcol1.setCellValueFactory(new PropertyValueFactory<>("name"));
        paintcol2.setCellValueFactory(new PropertyValueFactory<>("color"));
        paintcol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        paintcol4.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableviewpaint.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        if (painttextfield.getText().isEmpty() && painttextfield2.getText().isEmpty() && painttextfield3.getText().isEmpty() && painttextfield4.getText().isEmpty()) {

            try (InputStream is = Files.newInputStream(Paths.get("paintjobs.jobj"), StandardOpenOption.READ);) {

                ObjectInputStream ois = new ObjectInputStream(is);

                ArrayList<Paintjob> paintjobs = (ArrayList<Paintjob>) ois.readObject();

                for (Paintjob p : paintjobs) {
                    tableviewpaint.getItems().add(p);
                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {

            String paintinput = "";
            String paintcolor = "";
            String painttype = "";

            int price = 0;

            boolean valid = true;

            if (painttextfield.getText().isEmpty()) {}

            if (painttextfield2.getText().isEmpty()) {}

            if (painttextfield3.getText().isEmpty()) {}

            if (painttextfield4.getText().isEmpty()) {}

            if (painttextfield.getText().matches("[A-ZÆØÅ][a-zæøå]*")) {
                paintinput = painttextfield.getText();
            } else {
                valid = false;
            }
            if (painttextfield2.getText().matches("[A-ZÆØÅ][a-zæøå]*")) {
                paintcolor = painttextfield2.getText();
            } else {
                valid = false;
            }
            if (painttextfield3.getText().matches("[A-ZÆØÅ][a-zæøå]*")) {
                painttype = painttextfield3.getText();
            } else {
                valid = false;
            }
            if (painttextfield4.getText().matches("[0-9]*")) {
                price = Integer.parseInt(painttextfield4.getText());
            } else {
                valid = false;
            }

            if (valid) {

                Paintjob paintjob = new Paintjob(paintinput, price, paintcolor, painttype);

                File file = new File("paintjobs.jobj");

                try (InputStream is = Files.newInputStream(Paths.get("paintjobs.jobj"), StandardOpenOption.READ);) {

                    ObjectInputStream ois = new ObjectInputStream(is);

                    ArrayList<Paintjob> paintjobs = (ArrayList<Paintjob>) ois.readObject();

                    paintjobs.add(paintjob);
                    WritePaintjobs.write(file, paintjobs);

                    for (Paintjob p : paintjobs) {
                        tableviewpaint.getItems().add(p);
                    }

                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            } else {

            }
        }
    }

    @FXML
    void WheelInputAction(ActionEvent event) {

        wheelcol1.setCellValueFactory(new PropertyValueFactory<>("name"));
        wheelcol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        wheelcol3.setCellValueFactory(new PropertyValueFactory<>("size"));
        wheelcol4.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableviewheel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        if (wheeltextfield.getText().isEmpty() && wheeltextfield2.getText().isEmpty() && wheeltextfield3.getText().isEmpty() && wheeltextfield4.getText().isEmpty()) {

            try (InputStream is = Files.newInputStream(Paths.get("wheels.jobj"), StandardOpenOption.READ);) {

                ObjectInputStream ois = new ObjectInputStream(is);

                ArrayList<Wheel> wheels = (ArrayList<Wheel>) ois.readObject();

                for (Wheel w : wheels) {
                    tableviewheel.getItems().add(w);
                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {

            String wheelpartinput = "";
            String wheeltype = "";

            int ws = 0;
            int wp = 0;

            boolean value = true;

            if (wheeltextfield.getText().isEmpty()) {}
            if (wheeltextfield2.getText().isEmpty()) {}
            if (wheeltextfield3.getText().isEmpty()) {}
            if (wheeltextfield4.getText().isEmpty()) {}

            if (wheeltextfield.getText().matches("[A-ZÆØÅ][a-zæøå]*")) {
                wheelpartinput = wheeltextfield.getText();
            } else {value = false;}
            if (wheeltextfield2.getText().matches("[A-ZÆØÅ][a-zæøå]*")) {
                wheeltype = wheeltextfield2.getText();
            } else {value = false;}
            if (wheeltextfield3.getText().matches("[0-9]*")) {
                ws = Integer.parseInt(wheeltextfield3.getText());
            } else {value = false;}
            if (wheeltextfield4.getText().matches("[0-9]*")) {
                wp = Integer.parseInt(wheeltextfield4.getText());
            } else {value = false;}

            if (value) {

        Wheel wheel = new Wheel(wheelpartinput, wheeltype, ws, wp);

        File file = new File("wheels.jobj");


        try (InputStream is = Files.newInputStream(Paths.get("wheels.jobj"), StandardOpenOption.READ);) {

            ObjectInputStream ois = new ObjectInputStream(is);

            ArrayList<Wheel> wheels = (ArrayList<Wheel>) ois.readObject();

            wheels.add(wheel);
            WriteWheels.write(file, wheels);

            for (Wheel w : wheels) {
                tableviewheel.getItems().add(w);
            }

            tableviewheel.getItems().add(wheel);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

            } else {}
        }

    }


    @FXML
    void ExtraInputAction(ActionEvent event) {

        extracol1.setCellValueFactory(new PropertyValueFactory<>("name"));
        extracol2.setCellValueFactory(new PropertyValueFactory<>("description"));
        extracol3.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableviewextra.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        if (extratextfield.getText().isEmpty() && extratextfield2.getText().isEmpty() && extratextfield3.getText().isEmpty()) {

            try (InputStream is = Files.newInputStream(Paths.get("accessories.jobj"), StandardOpenOption.READ);) {

                ObjectInputStream ois = new ObjectInputStream(is);

                ArrayList<Accessory> accessories = (ArrayList<Accessory>) ois.readObject();

                for (Accessory a : accessories) {
                    tableviewextra.getItems().add(a);
                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {

            String extrapartinput = "";
            String extraparttype = "";

            int price = 0;

            boolean value = true;

            if (extratextfield.getText().isEmpty()) {}
            if (extratextfield2.getText().isEmpty()) {}
            if (extratextfield3.getText().isEmpty()) {}

            if (extratextfield.getText().matches("[A-ZÆØÅ][a-zæøå]*")) {
                extrapartinput = extratextfield.getText();
            } else {
                value = false;
            }
            if (extratextfield2.getText().matches("[A-ZÆØÅ][a-zæøå]*")) {
                extraparttype = extratextfield2.getText();
            } else {
                value = false;
            }
            if (extratextfield3.getText().matches("[0-9]*")) {
                price = Integer.parseInt(extratextfield3.getText());
            } else {
                value = false;
            }

            if (value) {

                Accessory extra = new Accessory(extrapartinput, extraparttype, price);

                File file = new File("accessories.jobj");

                try (InputStream is = Files.newInputStream(Paths.get("accessories.jobj"), StandardOpenOption.READ);) {

                    ObjectInputStream ois = new ObjectInputStream(is);

                    ArrayList<Accessory> accessories = (ArrayList<Accessory>) ois.readObject();

                    accessories.add(extra);
                    WriteAccessories.write(file, accessories);

                    for (Accessory a : accessories) {
                        tableviewextra.getItems().add(a);
                    }

                    tableviewextra.getItems().add(extra);

                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            } else { }
        }
    }


    @FXML
    void engineaction(ActionEvent event) {
        if (event.getSource() == engineid) {
            pane1id.toFront();
        }
        tableviewengine.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    void extraaction(ActionEvent event) {
        if (event.getSource() == extraid) {
            pane5id.toFront();
            tableviewextra.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        }
    }

    @FXML
    void gearboxaction(ActionEvent event) {
        if (event.getSource() == gearboxid) {
            pane2id.toFront();
            tableviewgearbox.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        }
    }

    @FXML
    void paintaction(ActionEvent event) {
        if (event.getSource() == paintid) {
            pane3id.toFront();
        }
        tableviewpaint.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    void wheeilsaction(ActionEvent event) {
        if (event.getSource() == wheelsid) {
            pane4id.toFront();
            tableviewheel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        }
    }



}
