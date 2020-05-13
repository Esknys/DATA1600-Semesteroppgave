package com.sample.controllers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    ArrayList<Accessory> globalaccessories = new ArrayList<Accessory>();
    ObservableList extrachoiceboxlist = FXCollections.observableArrayList();

    ArrayList<Wheel> globalwheels = new ArrayList<Wheel>();
    ObservableList wheelchoiceboxlist = FXCollections.observableArrayList();

    ArrayList<Paintjob> globalpaint = new ArrayList<Paintjob>();
    ObservableList paintchoiceboxlist = FXCollections.observableArrayList();

    ArrayList<Gearbox> globalgearbox = new ArrayList<Gearbox>();
    ObservableList gearboxchoiceboxlist = FXCollections.observableArrayList();

    ArrayList<Engine> globalengine = new ArrayList<Engine>();
    ObservableList enginechoiceboxlist = FXCollections.observableArrayList();


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
    private TextField textfieldenginefilter;

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
    private Button enginefilterid;

    @FXML
    private Button enginedeleteid;

    @FXML
    private TextField motorinput;

    @FXML
    private Pane pane2id;

    @FXML
    private TextField gearboxtextfield;

    @FXML
    private TextField textfieldgearboxfilter;

    @FXML
    private Button gearboxinputid;

    @FXML
    private Button gearboxfilterid;

    @FXML
    private Button gearboxdeleteid;

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
    private Button paintfilterid;

    @FXML
    private Button paintdeleteid;

    @FXML
    private TextField textfieldpaintfilter;

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
    private Button wheeldeleteid;



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
    private Button wheelfilterid;

    @FXML
    private TextField textfieldwheelfilter;

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
    private Button extrafilterid;

    @FXML
    private TextField textfieldextrafilter;

    @FXML
    private Button extradeletid;

    @FXML
    private Button extrachangeid;

    @FXML
    private Button extrachangeid2;

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

    // Ekstrautstyr
    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    // Hjul
    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    // Maling
    @FXML
    private Label label8;

    @FXML
    private Label label9;

    @FXML
    private Label label10;

    @FXML
    private Label label11;

    // Girkasse
    @FXML
    private Label label12;

    @FXML
    private Label label13;

    @FXML
    private Label label14;

    //Motor

    @FXML
    private Label label15;

    @FXML
    private Label label16;

    @FXML
    private Label label17;

    @FXML
    private Label label18;

    @FXML
    private ChoiceBox<String> choiceboxwheel;

    @FXML
    private ChoiceBox<String> choiceboxextra;

    @FXML
    private ChoiceBox<String> choiceboxpaint;

    @FXML
    private ChoiceBox<String> choiceboxgearbox;

    @FXML
    private ChoiceBox<String> choiceboxengine;




    // Det som dukker opp når man loader FXML filen
    @FXML
    public void initialize() {

        loadDataWheel();
        loadDataExtra();
        loadDataPaint();
        loadDataGearbox();
        loadDataEngine();

        tableviewengine.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableviewgearbox.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableviewpaint.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableviewheel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableviewextra.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        // Extra filopplastning under slik at alle elementene dukker opp ved starten av programmet
        // Under så initaliserer vi filen til globale variabelen.
        // Usikker på om det under er overflødig kode eller ikke

        try (InputStream is = Files.newInputStream(Paths.get("paintjobs.jobj"), StandardOpenOption.READ);) {
            ObjectInputStream ois = new ObjectInputStream(is);
            File filepaint = new File("paintjobs.jobj");
            ArrayList<Paintjob> paintjobs = (ArrayList<Paintjob>) ois.readObject();
            this.globalpaint = paintjobs;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (InputStream is = Files.newInputStream(Paths.get("wheels.jobj"), StandardOpenOption.READ);) {
            ObjectInputStream ois = new ObjectInputStream(is);
            File filewheel = new File("wheels.jobj");
            ArrayList<Wheel> wheels = (ArrayList<Wheel>) ois.readObject();
            this.globalwheels = wheels;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (InputStream is = Files.newInputStream(Paths.get("accessories.jobj"), StandardOpenOption.READ);) {
            ObjectInputStream ois = new ObjectInputStream(is);
            File fileextra = new File("accessories.jobj");
            ArrayList<Accessory> accessories = (ArrayList<Accessory>) ois.readObject();
            this.globalaccessories =  accessories;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    @FXML
    void BackActionButton(ActionEvent event) throws IOException {
        App.changeView("secondaryview.fxml");
    }




    @FXML
    void EngineInputAction(ActionEvent event) {

        tableviewengine.getItems().clear();

        enginecol1.setCellValueFactory(new PropertyValueFactory<>("name"));
        enginecol2.setCellValueFactory(new PropertyValueFactory<>("fuel"));
        enginecol3.setCellValueFactory(new PropertyValueFactory<>("horsepower"));
        enginecol4.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableviewengine.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Om alle tekstfeltene er tomte
        if (enginetextfield.getText().isEmpty() && fueltextfield.getText().isEmpty() && horsepowertextfield.getText().isEmpty() && pricetextfield.getText().isEmpty()) {

            try (InputStream is = Files.newInputStream(Paths.get("engines.jobj"), StandardOpenOption.READ);) {

                ObjectInputStream ois = new ObjectInputStream(is);

                ArrayList<Engine> engines = (ArrayList<Engine>) ois.readObject();

                this.globalengine = engines;

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

                    this.globalengine = engines;

                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            } else {

            }
        }

        for (Engine e : this.globalengine) {
            tableviewengine.getItems().add(e);
        }
    }

    @FXML
    void EngineFilterAction(ActionEvent event) {

        try {
            ArrayList<Engine> beforefilter = new ArrayList<Engine>();
            ArrayList<Engine> afterfilter = new ArrayList<Engine>();

            beforefilter = this.globalengine;

            String filtervar = textfieldenginefilter.getText();

            switch (choiceboxengine.getValue()) {
                case "Navn":
                    for (Engine e : beforefilter) {
                        if (e.getName().equals(filtervar)) {
                            afterfilter.add(e);
                        }
                    }

                    break;
                case "Drivstoff":
                    for (Engine e : beforefilter) {
                        if (e.getFuel().equals(filtervar)) {
                            afterfilter.add(e);
                        }
                    }
                    break;

                case "Hestekrefter":
                    Integer power = Integer.parseInt(filtervar);
                    for(Engine e: beforefilter) {
                        if (e.getHorsepower() == power) {
                            afterfilter.add(e);
                        }
                    }
                    break;

                case "Pris":
                    Integer price = Integer.parseInt(filtervar);
                    for(Engine e : beforefilter) {
                        if (e.getPrice() == price) {
                            afterfilter.add(e);
                        }
                    } break;
            }

            if (!tableviewengine.getItems().isEmpty()){
                tableviewengine.getItems().clear();
            }

            for (Engine e : afterfilter) {
                tableviewengine.getItems().add(e);
            }

        } catch (Exception e) {
            // txtTelefonnummer.setText("Noe gikk feil: " + ioe.getMessage());
        }
    }

    @FXML
    void EngineDeleteAction(ActionEvent event) {

        File file = new File("engines.jobj");

        try (InputStream is = Files.newInputStream(Paths.get("engines.jobj"), StandardOpenOption.READ);) {

            // Henter fram objekt
            Engine e = tableviewengine.getSelectionModel().getSelectedItem();

            // Fjerner objekt fra global variabel
            this.globalengine.remove(e);

            // Åpner stream
            ObjectInputStream ois = new ObjectInputStream(is);
            ArrayList<Engine> engines = (ArrayList<Engine>) ois.readObject();
            engines = this.globalengine;

            WriteEngines.write(file, engines);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // Sletter fra tableview, men ikke fra filen
        tableviewengine.getItems().removeAll(tableviewengine.getSelectionModel().getSelectedItem());
    }

    private void loadDataEngine(){
        enginechoiceboxlist.removeAll(enginechoiceboxlist);
        String a = "Navn";
        String b = "Drivstoff";
        String c = "Hestekrefter";
        String d = "Pris";
        enginechoiceboxlist.addAll(a,b,c,d);
        choiceboxengine.getItems().addAll(enginechoiceboxlist);
    }




    @FXML
    void GearboxInputAction(ActionEvent event) {

        tableviewgearbox.getItems().clear();

        gearboxcol1.setCellValueFactory(new PropertyValueFactory<>("name"));
        gearboxcol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        gearboxcol3.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableviewgearbox.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        if (gearboxtextfield.getText().isEmpty() && gearboxtextfield2.getText().isEmpty() && gearboxtextfield3.getText().isEmpty()) {

            try (InputStream is = Files.newInputStream(Paths.get("gearboxes.jobj"), StandardOpenOption.READ);) {

                ObjectInputStream ois = new ObjectInputStream(is);

                ArrayList<Gearbox> gearboxes = (ArrayList<Gearbox>) ois.readObject();

                this.globalgearbox = gearboxes;


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
                    this.globalgearbox = gearboxes;


                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            } else {

            }
        }

        for (Gearbox g : this.globalgearbox) {
                tableviewgearbox.getItems().add(g);
        }

    }

    @FXML
    void GearboxDeleteAction(ActionEvent event) {

        File file = new File("gearboxes.jobj");

        try (InputStream is = Files.newInputStream(Paths.get("gearboxes.jobj"), StandardOpenOption.READ);) {

            // Henter fram objekt
            Gearbox g = tableviewgearbox.getSelectionModel().getSelectedItem();

            // Fjerner objekt fra global variabel
            this.globalgearbox.remove(g);

            // Åpner stream
            ObjectInputStream ois = new ObjectInputStream(is);
            ArrayList<Gearbox> gearboxes = (ArrayList<Gearbox>) ois.readObject();
            gearboxes = this.globalgearbox;

            WriteGearboxes.write(file, gearboxes);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // Sletter fra tableview, men ikke fra filen
        tableviewgearbox.getItems().removeAll(tableviewgearbox.getSelectionModel().getSelectedItem());
    }

    @FXML
    void GearboxFilterAction(ActionEvent event) {
        try {
            ArrayList<Gearbox> beforefilter = new ArrayList<Gearbox>();
            ArrayList<Gearbox> afterfilter = new ArrayList<Gearbox>();

            beforefilter = this.globalgearbox;

            String filtervar = textfieldgearboxfilter.getText();

            switch (choiceboxgearbox.getValue()) {
                case "Navn":
                    for (Gearbox g : beforefilter) {
                        if (g.getName().equals(filtervar)) {
                            afterfilter.add(g);
                        }
                    }

                    break;
                case "Type":
                    for (Gearbox g : beforefilter) {
                        if (g.getType().equals(filtervar)) {
                            afterfilter.add(g);
                        }
                    }
                    break;

                case "Pris":
                    Integer price = Integer.parseInt(filtervar);
                    for(Gearbox g : beforefilter) {
                        if (g.getPrice() == price) {
                            afterfilter.add(g);
                        }
                    }
                    break;
            }

            if (!tableviewgearbox.getItems().isEmpty()){
                tableviewgearbox.getItems().clear();
            }

            for (Gearbox g : afterfilter) {
                tableviewgearbox.getItems().add(g);
            }

        } catch (Exception e) {
            // txtTelefonnummer.setText("Noe gikk feil: " + ioe.getMessage());
        }
    }

    private void loadDataGearbox(){
        gearboxchoiceboxlist.removeAll(gearboxchoiceboxlist);
        String a = "Navn";
        String b = "Type";
        String c = "Pris";
        gearboxchoiceboxlist.addAll(a,b,c);
        choiceboxgearbox.getItems().addAll(gearboxchoiceboxlist);
    }




    @FXML
    void PaintInputAction(ActionEvent event) {

        tableviewpaint.getItems().clear();

        paintcol1.setCellValueFactory(new PropertyValueFactory<>("name"));
        paintcol2.setCellValueFactory(new PropertyValueFactory<>("color"));
        paintcol3.setCellValueFactory(new PropertyValueFactory<>("type"));
        paintcol4.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableviewpaint.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        if (painttextfield.getText().isEmpty() && painttextfield2.getText().isEmpty() && painttextfield3.getText().isEmpty() && painttextfield4.getText().isEmpty()) {

            try (InputStream is = Files.newInputStream(Paths.get("paintjobs.jobj"), StandardOpenOption.READ);) {

                ObjectInputStream ois = new ObjectInputStream(is);

                ArrayList<Paintjob> paintjobs = (ArrayList<Paintjob>) ois.readObject();

                this.globalpaint = paintjobs;


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

                    this.globalpaint = paintjobs;

                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            } else {

            }
        }
            for (Paintjob p : this.globalpaint) {
                tableviewpaint.getItems().add(p);
            }
    }

    @FXML
    void PaintDeleteAction(ActionEvent event) {

        File file = new File("paintjobs.jobj");

        try (InputStream is = Files.newInputStream(Paths.get("paintjobs.jobj"), StandardOpenOption.READ);) {

            // Henter fram objekt
            Paintjob p = tableviewpaint.getSelectionModel().getSelectedItem();

            // Fjerner objekt fra global variabel
            this.globalpaint.remove(p);

            // Åpner stream
            ObjectInputStream ois = new ObjectInputStream(is);
            ArrayList<Paintjob> paintjobs = (ArrayList<Paintjob>) ois.readObject();
            paintjobs = this.globalpaint;

            WritePaintjobs.write(file, paintjobs);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // Sletter fra tableview, men ikke fra filen
        tableviewpaint.getItems().removeAll(tableviewpaint.getSelectionModel().getSelectedItem());
    }

    @FXML
    void PaintFilterAction(ActionEvent event) {
        try {
            ArrayList<Paintjob> beforefilter = new ArrayList<Paintjob>();
            ArrayList<Paintjob> afterfilter = new ArrayList<Paintjob>();

            beforefilter = this.globalpaint;

            String filtervar = textfieldpaintfilter.getText();

            switch (choiceboxpaint.getValue()) {
                case "Navn":
                    for (Paintjob p : beforefilter) {
                        if (p.getName().equals(filtervar)) {
                            afterfilter.add(p);
                        }
                    }

                    break;
                case "Type":
                    for (Paintjob p : beforefilter) {
                        if (p.getType().equals(filtervar)) {
                            afterfilter.add(p);
                        }
                    }
                    break;

                case "Farge":
                    for (Paintjob p : beforefilter) {
                        if (p.getColor().equals(filtervar)) {
                            afterfilter.add(p);
                        }
                    }
                    break;

                case "Pris":
                    Integer price = Integer.parseInt(filtervar);
                    for(Paintjob p : beforefilter) {
                        if (p.getPrice() == price) {
                            afterfilter.add(p);
                        }
                    }
                    break;
            }

            if (!tableviewpaint.getItems().isEmpty()){
                tableviewpaint.getItems().clear();
            }

            for (Paintjob p : afterfilter) {
                tableviewpaint.getItems().add(p);
            }

        } catch (Exception e) {
            // txtTelefonnummer.setText("Noe gikk feil: " + ioe.getMessage());
        }
    }

    private void loadDataPaint(){
        paintchoiceboxlist.removeAll(paintchoiceboxlist);
        String a = "Navn";
        String b = "Type";
        String c = "Farge";
        String d = "Pris";
        paintchoiceboxlist.addAll(a,b,c,d);
        choiceboxpaint.getItems().addAll(paintchoiceboxlist);
    }




    @FXML
    void WheelInputAction(ActionEvent event) {

        tableviewheel.getItems().clear();

        wheelcol1.setCellValueFactory(new PropertyValueFactory<>("name"));
        wheelcol2.setCellValueFactory(new PropertyValueFactory<>("type"));
        wheelcol3.setCellValueFactory(new PropertyValueFactory<>("size"));
        wheelcol4.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableviewheel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        if (wheeltextfield.getText().isEmpty() && wheeltextfield2.getText().isEmpty() && wheeltextfield3.getText().isEmpty() && wheeltextfield4.getText().isEmpty()) {

            try (InputStream is = Files.newInputStream(Paths.get("wheels.jobj"), StandardOpenOption.READ);) {

                ObjectInputStream ois = new ObjectInputStream(is);

                ArrayList<Wheel> wheels = (ArrayList<Wheel>) ois.readObject();

                this.globalwheels = wheels;

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

            // Legger til ny
            wheels.add(wheel);
            WriteWheels.write(file, wheels);

            this.globalwheels = wheels;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
            } else {}
        }

        for (Wheel w : this.globalwheels) {
                tableviewheel.getItems().add(w);
        }
    }

    @FXML
    void WheelDeleteAction(ActionEvent event) {

        File file = new File("wheels.jobj");

        try (InputStream is = Files.newInputStream(Paths.get("wheels.jobj"), StandardOpenOption.READ);) {

            // Henter fram objekt
            Wheel w = tableviewheel.getSelectionModel().getSelectedItem();

            // Fjerner objekt fra global variabel
            this.globalwheels.remove(w);

            // Åpner stream
            ObjectInputStream ois = new ObjectInputStream(is);
            ArrayList<Wheel> wheels = (ArrayList<Wheel>) ois.readObject();
            wheels = this.globalwheels;

            WriteWheels.write(file, wheels);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // Sletter fra tableview, men ikke fra filen?
        tableviewheel.getItems().removeAll(tableviewheel.getSelectionModel().getSelectedItem());
    }

    @FXML
    void WheelFilterAction(ActionEvent event) {

        try {
            ArrayList<Wheel> beforefilter = new ArrayList<Wheel>();
            ArrayList<Wheel> afterfilter = new ArrayList<Wheel>();

            beforefilter = this.globalwheels;

            String filtervar = textfieldwheelfilter.getText();

            switch (choiceboxwheel.getValue()) {
                case "Navn":
                    for (Wheel w : beforefilter) {
                        if (w.getName().equals(filtervar)) {
                            afterfilter.add(w);
                        }
                    }

                    break;
                case "Type":
                    for (Wheel w : beforefilter) {
                        if (w.getType().equals(filtervar)) {
                            afterfilter.add(w);
                        }
                    }
                    break;

                case "Størrelse":
                    Integer size = Integer.parseInt(filtervar);
                    for(Wheel w : beforefilter) {
                        if (w.getSize() == size) {
                            afterfilter.add(w);
                        }
                    }
                    break;

                case "Pris":
                    Integer price = Integer.parseInt(filtervar);
                    for(Wheel w : beforefilter) {
                        if (w.getPrice() == price) {
                            afterfilter.add(w);
                        }
                    } break;
            }

            if (!tableviewheel.getItems().isEmpty()){
                tableviewheel.getItems().clear();
            }

            for (Wheel w : afterfilter) {
                tableviewheel.getItems().add(w);
            }

        } catch (Exception e) {
            // txtTelefonnummer.setText("Noe gikk feil: " + ioe.getMessage());
        }
    }

    private void loadDataWheel(){
        wheelchoiceboxlist.removeAll(wheelchoiceboxlist);
        String a = "Navn";
        String b = "Type";
        String c = "Størrelse";
        String d = "Pris";
        wheelchoiceboxlist.addAll(a,b,c,d);
        choiceboxwheel.getItems().addAll(wheelchoiceboxlist);
    }





    @FXML
    void ExtraInputAction(ActionEvent event) {
        tableviewextra.getItems().clear();

        extracol1.setCellValueFactory(new PropertyValueFactory<>("name"));
        extracol2.setCellValueFactory(new PropertyValueFactory<>("description"));
        extracol3.setCellValueFactory(new PropertyValueFactory<>("price"));

        if (extratextfield.getText().isEmpty() && extratextfield2.getText().isEmpty() && extratextfield3.getText().isEmpty()) {

            try (InputStream is = Files.newInputStream(Paths.get("accessories.jobj"), StandardOpenOption.READ);) {

                ObjectInputStream ois = new ObjectInputStream(is);

                ArrayList<Accessory> accessories = (ArrayList<Accessory>) ois.readObject();
                this.globalaccessories = accessories;

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {

            String extrapartinput = "";
            String extraparttype = "";

            int price = 0;

            boolean value = true;

            if (extratextfield.getText().isEmpty()) {
            }
            if (extratextfield2.getText().isEmpty()) {
            }
            if (extratextfield3.getText().isEmpty()) {
            }

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

                    this.globalaccessories = accessories;

                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            } else {

            }
        }

        for (Accessory a : this.globalaccessories) {
                tableviewextra.getItems().add(a);
        }

    }

    @FXML
    void ExtraChangeAction(ActionEvent event) {

        // Tenker at du velge rad, trykker på "endre valgte rad",
        // Da dukker verdiene opp i textfield, som du kan endre
        // Automatisk da så sletter den du har valgt, og lager ny ved å legge til den ny med nye verdier.

        // Dette endrer du ved å trykke "oppdater"

        Accessory a = tableviewextra.getSelectionModel().getSelectedItem();

        extratextfield.setText(a.getName());
        extratextfield2.setText(a.getDescription());
        String price = String.valueOf(a.getPrice());
        extratextfield3.setText(price);

    }

    @FXML
    void ExtraChangeAction2(ActionEvent event) {

        /*/ Henter fram det jeg skal endre
        String extrapartinput = extratextfield.getText();
        String extraparttype = extratextfield2.getText();
        Integer extraprice = Integer.parseInt(extratextfield3.getText());

         // Henter fra objektet jeg skal endre på
        Accessory a = tableviewextra.getSelectionModel().getSelectedItem();

        // Endrer på objektet
        // Finner ikke fram objektet. Kunne ha gjort en enklere versjon: Slette så legge til ny.
        // Vi gjør derimot dette: Iterer gjennom for å finne index. Deretter get.

        for (int i = 0; i < this.globalaccessories.size(); i++) {
            if (a.getName() = this.globalaccessories(i).getname()) {

            }
        }

        // Åpner stream
        ObjectInputStream ois = new ObjectInputStream(is);
        ArrayList<Accessory> accessories = (ArrayList<Accessory>) ois.readObject();
        accessories = this.globalaccessories;

        WriteAccessories.write(file, accessories);

/
         */

    }

    @FXML
    void ExtraDeleteAction(ActionEvent event) {

        File file = new File("accessories.jobj");

        try (InputStream is = Files.newInputStream(Paths.get("accessories.jobj"), StandardOpenOption.READ);) {

            // Henter fram objekt
            Accessory a = tableviewextra.getSelectionModel().getSelectedItem();

            // Fjerner objekt fra global variabel
            this.globalaccessories.remove(a);

            // Åpner stream
            ObjectInputStream ois = new ObjectInputStream(is);
            ArrayList<Accessory> accessories = (ArrayList<Accessory>) ois.readObject();
            accessories = this.globalaccessories;

            WriteAccessories.write(file, accessories);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // Sletter fra tableview, men ikke fra filen?
        tableviewextra.getItems().removeAll(tableviewextra.getSelectionModel().getSelectedItem());
    }

    @FXML
    void ExtraFilterAction(ActionEvent event) {
        try {
            ArrayList<Accessory> beforefilter = new ArrayList<Accessory>();
            ArrayList<Accessory> afterfilter = new ArrayList<Accessory>();

            beforefilter = this.globalaccessories;

            String filtervar = textfieldextrafilter.getText();

            switch (choiceboxextra.getValue()) {
                case "Navn":
                        for (Accessory a : beforefilter) {
                            if (a.getName().equals(filtervar)) {
                                afterfilter.add(a);
                            }
                        }

                    break;
                case "Type":
                    for (Accessory a : beforefilter) {
                        if (a.getDescription().equals(filtervar)) {
                                    afterfilter.add(a);
                        }
                    }
                    break;

                case "Pris":
                    Integer price = Integer.parseInt(filtervar);
                    for(Accessory a : beforefilter) {
                        if (a.getPrice() == price) {
                            afterfilter.add(a);
                        }
                    }
                    break;
            }

            if (!tableviewextra.getItems().isEmpty()){
                tableviewextra.getItems().clear();
            }

            for (Accessory a : afterfilter) {
                tableviewextra.getItems().add(a);
            }

        } catch (Exception e) {
           // txtTelefonnummer.setText("Noe gikk feil: " + ioe.getMessage());
        }
    }

    private void loadDataExtra(){
        extrachoiceboxlist.removeAll(extrachoiceboxlist);
        String a = "Navn";
        String b = "Type";
        String c = "Pris";
        extrachoiceboxlist.addAll(a,b,c);
        choiceboxextra.getItems().addAll(extrachoiceboxlist);
    }







    @FXML
    void engineaction(ActionEvent event) {
        if (event.getSource() == engineid) {
            pane1id.toFront();
        }
    }

    @FXML
    void gearboxaction(ActionEvent event) {
        if (event.getSource() == gearboxid) {
            pane2id.toFront();
        }
    }

    @FXML
    void paintaction(ActionEvent event) {
        if (event.getSource() == paintid) {
            pane3id.toFront();
        }
    }

    @FXML
    void wheeilsaction(ActionEvent event) {
        if (event.getSource() == wheelsid) {
            pane4id.toFront();
        }
    }

    @FXML
    void extraaction(ActionEvent event) {
        if (event.getSource() == extraid) {
            pane5id.toFront();
        }
    }



}
