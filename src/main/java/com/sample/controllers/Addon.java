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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    @FXML
    private Label label8;

    @FXML
    private Label label9;

    @FXML
    private Label label10;

    @FXML
    private Label label11;

    @FXML
    private Label label12;

    @FXML
    private Label label13;

    @FXML
    private Label label14;

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


    private OpenWithThread task;

    @FXML
    private Button enginechangeid1;

    @FXML
    private Button enginechangeid2;

    @FXML
    private Button gearboxchangeid1;

    @FXML
    private Button gearboxchangeid2;

    @FXML
    private Button paintchangeid1;

    @FXML
    private Button paintchangeid2;

    @FXML
    private Button wheelchangeid1;

    @FXML
    private Button wheelchangeid2;

    @FXML
    private Button extrachangeid1;

    @FXML
    private Button extrachangeid2;


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

        try (InputStream is = Files.newInputStream(Paths.get("engines.jobj"), StandardOpenOption.READ);) {
            ObjectInputStream ois = new ObjectInputStream(is);
            File fileengine = new File("engines.jobj");
            ArrayList<Engine> engines = (ArrayList<Engine>) ois.readObject();
            this.globalengine = engines;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (InputStream is = Files.newInputStream(Paths.get("gearboxes.jobj"), StandardOpenOption.READ);) {
            ObjectInputStream ois = new ObjectInputStream(is);
            File filegearbox = new File("paintjobs.jobj");
            ArrayList<Gearbox> gearboxes = (ArrayList<Gearbox>) ois.readObject();
            this.globalgearbox = gearboxes;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

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
            this.globalaccessories = accessories;
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

        label15.setText(" ");
        label16.setText(" ");
        label17.setText(" ");
        label18.setText(" ");

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
                label15.setText("Feltet er tomt");
            }
            if (fueltextfield.getText().isEmpty()) {
                label16.setText("Feltet er tomt");
            }
            if (horsepowertextfield.getText().isEmpty()) {
                label17.setText("Feltet er tomt");
            }
            if (pricetextfield.getText().isEmpty()) {
                label18.setText("Feltet er tomt");
            }

            if (enginetextfield.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                engineinput = enginetextfield.getText();
            } else {
                valid = false;
                label15.setText("Feil format. Bruk bokstaver uten mellomrom.");
            }
            if (fueltextfield.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                fuelinput = fueltextfield.getText();
            } else {
                valid = false;
                label16.setText("Feil format. Bruk bokstaver uten mellomrom.");
            }
            if (horsepowertextfield.getText().matches("[0-9]*")) {
                hp = Integer.parseInt(horsepowertextfield.getText());
            } else {
                valid = false;
                label17.setText("Feil format. Bruk siffer.");
            }
            if (pricetextfield.getText().matches("[0-9]*")) {
                price = Integer.parseInt(pricetextfield.getText());
            } else {
                valid = false;
                label18.setText("Feil format. Bruk siffer");
            }

            if (valid) {

                Engine engine = new Engine(engineinput, fuelinput, hp, price);

                File file = new File("engines.jobj");

                try (InputStream is = Files.newInputStream(Paths.get("engines.jobj"), StandardOpenOption.READ);) {

                    ObjectInputStream ois = new ObjectInputStream(is);

                    ArrayList<Engine> engines = (ArrayList<Engine>) ois.readObject();
                    engines.add(engine);

                    task = new OpenWithThread("Engine", file, engines);
                    task.setOnSucceeded(this::ThreadOpenDone);
                    task.setOnFailed(this::ThreadOpenFailed);
                    Thread th = new Thread(task);
                    th.setDaemon(true);
                    DisableAll();
                    th.start();

                    this.globalengine = engines;


                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            } else {

            }
        }

        enginetextfield.clear();
        fueltextfield.clear();
        horsepowertextfield.clear();
        pricetextfield.clear();

        tableviewengine.getItems().clear();
        for (Engine e : this.globalengine) {
            tableviewengine.getItems().add(e);
        }
    }


    @FXML
     void EngineChangeAction (ActionEvent event){
                Engine e = tableviewengine.getSelectionModel().getSelectedItem();
                enginetextfield.setText(e.getName());

                String horsepower = String.valueOf(e.getHorsepower());
                horsepowertextfield.setText(horsepower);

                fueltextfield.setText(e.getFuel());

                String price = String.valueOf(e.getPrice());
                pricetextfield.setText(price);
            }

     @FXML
     void EngineChangeActionUpdate (ActionEvent event){
        if (enginetextfield.getText().isEmpty()) {
            label8.setText("Feltet er tomt");
        }
        if (horsepowertextfield.getText().isEmpty()) {
            label9.setText("Feltet er tomt");
        }
        if (fueltextfield.getText().isEmpty()) {
            label10.setText("Feltet er tomt");
        }
        if (pricetextfield.getText().isEmpty()) {
            label11.setText("Feltet er tomt");
        }
        boolean valid = true;
        String enginenameinput = "";

        Integer horsepowerinput = 0;

        String fuelinput = "";

        Integer priceinput = 0;

        if (enginetextfield.getText().matches("[A-ZÆØÅa-zæøå]*")) {
            enginenameinput = enginetextfield.getText();
        } else {
            label15.setText("Feil input. Bruk bokstaver uten mellomrom.");
            valid = false;
        }
        if (horsepowertextfield.getText().matches("[0-9]*")) {
            horsepowerinput = Integer.parseInt(horsepowertextfield.getText());
        } else {
            label16.setText("Feil input. Bruke siffer uten mellomrom.");
            valid = false;
        }
        if (fueltextfield.getText().matches("[A-ZÆØÅa-zæøå]*")) {
            fuelinput = fueltextfield.getText();
        } else {
            label17.setText("Feil input. Bruk siffer uten mellomrom.");
            valid = false;
        }
        if (pricetextfield.getText().matches("[0-9]*")) {
            priceinput = Integer.parseInt(pricetextfield.getText());
        } else {
            label18.setText("Feil input. Bruk siffer uten mellomrom.");
            valid = false;
        }

         if (valid) {
             Engine eng = tableviewengine.getSelectionModel().getSelectedItem();
             for (Engine engine : this.globalengine) {
                 if (eng.getUUIDString() == engine.getUUIDString()) {
                     engine.setName(enginenameinput);
                     engine.setHorsepower(horsepowerinput);
                     engine.setFuel(fuelinput);
                     engine.setPrice(priceinput);
                 }
             }
                    File file = new File("engines.jobj");
                    try (InputStream is = Files.newInputStream(Paths.get("engines.jobj"), StandardOpenOption.READ);) {
                        ObjectInputStream ois = new ObjectInputStream(is);
                        ArrayList<Engine> engines = new ArrayList<Engine>();
                        engines = this.globalengine;
                        task = new OpenWithThread("Engine", file, engines);
                        task.setOnSucceeded(this::ThreadOpenDone);
                        task.setOnFailed(this::ThreadOpenFailed);
                        Thread th = new Thread(task);
                        th.setDaemon(true);
                        DisableAll();
                        th.start();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                }
                enginetextfield.clear();
                horsepowertextfield.clear();
                fueltextfield.clear();
                pricetextfield.clear();
                tableviewengine.getItems().clear();
                for (Engine e : this.globalengine) {
                    tableviewengine.getItems().add(e);
                }

            }


      @FXML
      void EngineFilterAction (ActionEvent event){

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
                            for (Engine e : beforefilter) {
                                if (e.getHorsepower() == power) {
                                    afterfilter.add(e);
                                }
                            }
                            break;

                        case "Pris":
                            Integer price = Integer.parseInt(filtervar);
                            for (Engine e : beforefilter) {
                                if (e.getPrice() == price) {
                                    afterfilter.add(e);
                                }
                            }
                            break;
                    }

                    if (!tableviewengine.getItems().isEmpty()) {
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
       void EngineDeleteAction (ActionEvent event){

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

            private void loadDataEngine () {
                enginechoiceboxlist.removeAll(enginechoiceboxlist);
                String a = "Navn";
                String b = "Drivstoff";
                String c = "Hestekrefter";
                String d = "Pris";
                enginechoiceboxlist.addAll(a, b, c, d);
                choiceboxengine.getItems().addAll(enginechoiceboxlist);
            }


            @FXML
            void GearboxInputAction (ActionEvent event){

                tableviewgearbox.getItems().clear();

                label12.setText(" ");
                label13.setText(" ");
                label14.setText(" ");

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

                    if (gearboxtextfield.getText().isEmpty()) {
                        label12.setText("Feltet er tomt");
                    }

                    if (gearboxtextfield2.getText().isEmpty()) {
                        label13.setText("Feltet er tomt");
                    }

                    if (gearboxtextfield3.getText().isEmpty()) {
                        label14.setText("Feltet er tomt");
                    }

                    if (gearboxtextfield.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                        gearboxinput = gearboxtextfield.getText();
                    } else {
                        valid = false;
                        label12.setText("Feil format. Bruk bokstaver uten mellomrom.");
                    }
                    if (gearboxtextfield2.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                        typeinput = gearboxtextfield2.getText();
                    } else {
                        valid = false;
                        label13.setText("Feil format. Bruk bokstaver uten mellomrom.");
                    }
                    if (gearboxtextfield3.getText().matches("[0-9]*")) {
                        price = Integer.parseInt(gearboxtextfield3.getText());
                    } else {
                        valid = false;
                        label14.setText("Feil format. Bruk siffer uten mellomrom.");
                    }

                    if (valid) {

                        Gearbox gearbox = new Gearbox(gearboxinput, price, typeinput);

                        File file = new File("gearboxes.jobj");

                        try (InputStream is = Files.newInputStream(Paths.get("gearboxes.jobj"), StandardOpenOption.READ);) {

                            ObjectInputStream ois = new ObjectInputStream(is);

                            ArrayList<Gearbox> gearboxes = (ArrayList<Gearbox>) ois.readObject();
                            gearboxes.add(gearbox);

                            task = new OpenWithThread("Gearbox", file, gearboxes);
                            task.setOnSucceeded(this::ThreadOpenDone);
                            task.setOnFailed(this::ThreadOpenFailed);
                            Thread th = new Thread(task);
                            th.setDaemon(true);
                            DisableAll();
                            th.start();

                            this.globalgearbox = gearboxes;


                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println(e.getMessage());
                        }

                    } else {

                    }
                }
                gearboxtextfield.clear();
                gearboxtextfield2.clear();
                gearboxtextfield3.clear();
                for (Gearbox g : this.globalgearbox) {
                    tableviewgearbox.getItems().add(g);
                }

            }

            @FXML
            void GearboxChangeAction (ActionEvent event){
                Gearbox g = tableviewgearbox.getSelectionModel().getSelectedItem();
                gearboxtextfield.setText(g.getName());
                gearboxtextfield2.setText(g.getType());
                String price = String.valueOf(g.getPrice());
                gearboxtextfield3.setText(price);
            }

            @FXML
            void GearboxChangeActionUpdate (ActionEvent event){
                boolean valid = true;
                if (gearboxtextfield.getText().isEmpty()) {
                    label12.setText("Feltet er tomt");
                    valid = false;
                }
                if (gearboxtextfield2.getText().isEmpty()) {
                    label13.setText("Feltet er tomt");
                    valid = false;
                }
                if (gearboxtextfield3.getText().isEmpty()) {
                    label14.setText("Feltet er tomt");
                    valid = false;
                }

                String gearboxname = "";
                String gearboxtype = "";
                Integer gearboxprice = 0;
                if (gearboxtextfield.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                    gearboxname = gearboxtextfield.getText();
                } else {
                    label12.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    valid = false;
                }
                if (gearboxtextfield2.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                    gearboxtype = gearboxtextfield2.getText();
                } else {
                    label13.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    valid = false;
                }
                if (gearboxtextfield3.getText().matches("[0-9]*")) {
                    gearboxprice = Integer.parseInt(gearboxtextfield3.getText());
                } else {
                    label14.setText("Feil input. Bruk siffer uten mellomrom.");
                    valid = false;
                }
                if (valid) {
                    Gearbox g = tableviewgearbox.getSelectionModel().getSelectedItem();
                    for (Gearbox gearbox : this.globalgearbox) {
                        if (gearbox.getUUIDString() == g.getUUIDString()) {
                            gearbox.setName(gearboxname);
                            gearbox.setType(gearboxtype);
                            gearbox.setPrice(gearboxprice);
                        }
                    }


                    File file = new File("gearboxes.jobj");
                    try (InputStream is = Files.newInputStream(Paths.get("gearboxes.jobj"), StandardOpenOption.READ);) {
                        ObjectInputStream ois = new ObjectInputStream(is);
                        ArrayList<Gearbox> gearboxes = new ArrayList<Gearbox>();
                        gearboxes = this.globalgearbox;
                        task = new OpenWithThread("Gearbox", file, gearboxes);
                        task.setOnSucceeded(this::ThreadOpenDone);
                        task.setOnFailed(this::ThreadOpenFailed);
                        Thread th = new Thread(task);
                        th.setDaemon(true);
                        DisableAll();
                        th.start();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                }

                gearboxtextfield.clear();
                gearboxtextfield2.clear();
                gearboxtextfield3.clear();

                tableviewgearbox.getItems().clear();
                for (Gearbox g : this.globalgearbox) {
                    tableviewgearbox.getItems().add(g);
                }

            }

            @FXML
            void GearboxDeleteAction (ActionEvent event){

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
            void GearboxFilterAction (ActionEvent event){
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
                            for (Gearbox g : beforefilter) {
                                if (g.getPrice() == price) {
                                    afterfilter.add(g);
                                }
                            }
                            break;
                    }

                    if (!tableviewgearbox.getItems().isEmpty()) {
                        tableviewgearbox.getItems().clear();
                    }

                    for (Gearbox g : afterfilter) {
                        tableviewgearbox.getItems().add(g);
                    }

                } catch (Exception e) {
                    // txtTelefonnummer.setText("Noe gikk feil: " + ioe.getMessage());
                }
            }

            private void loadDataGearbox () {
                gearboxchoiceboxlist.removeAll(gearboxchoiceboxlist);
                String a = "Navn";
                String b = "Type";
                String c = "Pris";
                gearboxchoiceboxlist.addAll(a, b, c);
                choiceboxgearbox.getItems().addAll(gearboxchoiceboxlist);
            }


            @FXML
            void PaintInputAction (ActionEvent event){

                tableviewpaint.getItems().clear();

                label8.setText(" ");
                label9.setText(" ");
                label10.setText(" ");
                label11.setText(" ");

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

                    if (painttextfield.getText().isEmpty()) {
                        label8.setText("Feltet er tomt.");
                    }

                    if (painttextfield2.getText().isEmpty()) {
                        label9.setText("Feltet er tomt");
                    }

                    if (painttextfield3.getText().isEmpty()) {
                        label10.setText("Feltet er tomt");
                    }

                    if (painttextfield4.getText().isEmpty()) {
                        label11.setText("Feltet er tomt");
                    }

                    if (painttextfield.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                        paintinput = painttextfield.getText();
                    } else {
                        valid = false;
                        label8.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    }
                    if (painttextfield2.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                        paintcolor = painttextfield2.getText();
                    } else {
                        valid = false;
                        label9.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    }
                    if (painttextfield3.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                        painttype = painttextfield3.getText();
                    } else {
                        valid = false;
                        label10.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    }
                    if (painttextfield4.getText().matches("[0-9]*")) {
                        price = Integer.parseInt(painttextfield4.getText());
                    } else {
                        valid = false;
                        label11.setText("Feil input. Bruk nummer uten mellomrom.");
                    }

                    if (valid) {

                        Paintjob paintjob = new Paintjob(paintinput, price, paintcolor, painttype);

                        File file = new File("paintjobs.jobj");

                        try (InputStream is = Files.newInputStream(Paths.get("paintjobs.jobj"), StandardOpenOption.READ);) {

                            ObjectInputStream ois = new ObjectInputStream(is);

                            ArrayList<Paintjob> paintjobs = (ArrayList<Paintjob>) ois.readObject();
                            paintjobs.add(paintjob);

                            task = new OpenWithThread("Wheel", file, paintjobs);
                            task.setOnSucceeded(this::ThreadOpenDone);
                            task.setOnFailed(this::ThreadOpenFailed);
                            Thread th = new Thread(task);
                            th.setDaemon(true);
                            DisableAll();
                            th.start();

                            this.globalpaint = paintjobs;

                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println(e.getMessage());
                        }

                    } else {

                    }
                }
                painttextfield.clear();
                painttextfield2.clear();
                painttextfield3.clear();
                painttextfield4.clear();
                for (Paintjob p : this.globalpaint) {
                    tableviewpaint.getItems().add(p);
                }
            }

            @FXML
            void PaintChangeAction (ActionEvent event){
                Paintjob p = tableviewpaint.getSelectionModel().getSelectedItem();
                painttextfield.setText(p.getName());
                painttextfield2.setText(p.getColor());
                painttextfield3.setText(p.getType());
                String price = String.valueOf(p.getPrice());
                painttextfield4.setText(price);
            }

            @FXML
            void PaintChangeActionUpdate (ActionEvent event){
                boolean valid = true;
                if (painttextfield.getText().isEmpty()) {
                    label8.setText("Feltet er tomt");
                    valid = false;
                }
                if (painttextfield2.getText().isEmpty()) {
                    label9.setText("Feltet er tomt");
                    valid = false;
                }
                if (painttextfield3.getText().isEmpty()) {
                    label10.setText("Feltet er tomt");
                    valid = false;
                }
                if (painttextfield4.getText().isEmpty()) {
                    label11.setText("Feltet er tomt");
                    valid = false;
                }

                String paintnameinput = "";
                String paintcolorinput = "";
                String painttypeinput = "";
                Integer paintprice = 0;
                if (painttextfield.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                    paintnameinput = painttextfield.getText();
                } else {
                    label8.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    valid = false;
                }
                if (painttextfield2.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                    paintcolorinput = painttextfield2.getText();
                } else {
                    label5.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    valid = false;
                }
                if (painttextfield3.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                    painttypeinput = painttextfield3.getText();
                } else {
                    label6.setText("Feil input. Bruk siffer uten mellomrom.");
                    valid = false;
                }
                if (painttextfield4.getText().matches("[0-9]*")) {
                    paintprice = Integer.parseInt(painttextfield4.getText());
                } else {
                    label7.setText("Feil input. Bruk siffer uten mellomrom.");
                    valid = false;
                }

                if (valid) {
                    Paintjob p = tableviewpaint.getSelectionModel().getSelectedItem();
                    for (Paintjob paint : this.globalpaint) {
                        if (p.getUUIDString() == paint.getUUIDString()) {
                            paint.setName(paintnameinput);
                            paint.setColor(paintcolorinput);
                            paint.setType(painttypeinput);
                            paint.setPrice(paintprice);
                        }
                    }
                    File file = new File("paintjobs.jobj");
                    try (InputStream is = Files.newInputStream(Paths.get("paintjobs.jobj"), StandardOpenOption.READ);) {
                        ObjectInputStream ois = new ObjectInputStream(is);
                        ArrayList<Paintjob> paintjobs = new ArrayList<Paintjob>();
                        paintjobs = this.globalpaint;
                        task = new OpenWithThread("Paintjob", file, paintjobs);
                        task.setOnSucceeded(this::ThreadOpenDone);
                        task.setOnFailed(this::ThreadOpenFailed);
                        Thread th = new Thread(task);
                        th.setDaemon(true);
                        DisableAll();
                        th.start();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                }
                painttextfield.clear();
                painttextfield2.clear();
                painttextfield3.clear();
                painttextfield4.clear();
                tableviewpaint.getItems().clear();
                for (Paintjob p : this.globalpaint) {
                    tableviewpaint.getItems().add(p);
                }

            }

            @FXML
            void PaintDeleteAction (ActionEvent event){

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
            void PaintFilterAction (ActionEvent event){
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
                            for (Paintjob p : beforefilter) {
                                if (p.getPrice() == price) {
                                    afterfilter.add(p);
                                }
                            }
                            break;
                    }

                    if (!tableviewpaint.getItems().isEmpty()) {
                        tableviewpaint.getItems().clear();
                    }

                    for (Paintjob p : afterfilter) {
                        tableviewpaint.getItems().add(p);
                    }

                } catch (Exception e) {
                    // txtTelefonnummer.setText("Noe gikk feil: " + ioe.getMessage());
                }
            }

            private void loadDataPaint () {
                paintchoiceboxlist.removeAll(paintchoiceboxlist);
                String a = "Navn";
                String b = "Type";
                String c = "Farge";
                String d = "Pris";
                paintchoiceboxlist.addAll(a, b, c, d);
                choiceboxpaint.getItems().addAll(paintchoiceboxlist);
            }


            @FXML
            void WheelInputAction (ActionEvent event){

                tableviewheel.getItems().clear();

                label4.setText(" ");
                label5.setText(" ");
                label6.setText(" ");
                label7.setText(" ");


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

                    if (wheeltextfield.getText().isEmpty()) {
                        label4.setText("Feltet er tomt.");
                    }
                    if (wheeltextfield2.getText().isEmpty()) {
                        label5.setText("Feltet er tomt.");
                    }
                    if (wheeltextfield3.getText().isEmpty()) {
                        label6.setText("Feltet er tomt.");
                    }
                    if (wheeltextfield4.getText().isEmpty()) {
                        label7.setText("Feltet er tomt.");
                    }

                    if (wheeltextfield.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                        wheelpartinput = wheeltextfield.getText();
                    } else {
                        value = false;
                        label4.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    }
                    if (wheeltextfield2.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                        wheeltype = wheeltextfield2.getText();
                    } else {
                        value = false;
                        label5.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    }
                    if (wheeltextfield3.getText().matches("[0-9]*")) {
                        ws = Integer.parseInt(wheeltextfield3.getText());
                    } else {
                        value = false;
                        label6.setText("Feil input. Bruk tall uten mellomrom.");
                    }
                    if (wheeltextfield4.getText().matches("[0-9]*")) {
                        wp = Integer.parseInt(wheeltextfield4.getText());
                    } else {
                        value = false;
                        label7.setText("Feil input. Bruk tall uten mellomrom.");
                    }

                    if (value) {

                        Wheel wheel = new Wheel(wheelpartinput, wheeltype, ws, wp);

                        File file = new File("wheels.jobj");


                        try (InputStream is = Files.newInputStream(Paths.get("wheels.jobj"), StandardOpenOption.READ);) {

                            ObjectInputStream ois = new ObjectInputStream(is);

                            ArrayList<Wheel> wheels = (ArrayList<Wheel>) ois.readObject();
                            wheels.add(wheel);

                            task = new OpenWithThread("Wheel", file, wheels);
                            task.setOnSucceeded(this::ThreadOpenDone);
                            task.setOnFailed(this::ThreadOpenFailed);
                            Thread th = new Thread(task);
                            th.setDaemon(true);
                            DisableAll();
                            th.start();

                            this.globalwheels = wheels;


                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                    }
                }

                wheeltextfield.clear();
                wheeltextfield2.clear();
                wheeltextfield3.clear();
                wheeltextfield4.clear();

                for (Wheel w : this.globalwheels) {
                    tableviewheel.getItems().add(w);
                }
            }

            @FXML
            void WheelChangeAction (ActionEvent event){
                Wheel w = tableviewheel.getSelectionModel().getSelectedItem();
                wheeltextfield.setText(w.getName());
                wheeltextfield2.setText(w.getType());
                String size = String.valueOf(w.getSize());
                wheeltextfield3.setText(size);
                String price = String.valueOf(w.getPrice());
                wheeltextfield4.setText(price);
            }

            @FXML
            void WheelChangeActionUpdate (ActionEvent event){

                boolean valid = true;
                if (wheeltextfield.getText().isEmpty()) {
                    label4.setText("Feltet er tomt");
                    valid = false;
                }
                if (wheeltextfield2.getText().isEmpty()) {
                    label5.setText("Feltet er tomt");
                    valid = false;
                }
                if (wheeltextfield3.getText().isEmpty()) {
                    label6.setText("Feltet er tomt");
                    valid = false;
                }
                if (wheeltextfield4.getText().isEmpty()) {
                    label7.setText("Feltet er tomt");
                    valid = false;
                }

                String wheelnameinput = "";
                String wheelparttype = "";
                Integer wheelsize = 0;
                Integer wheelprice = 0;
                if (wheeltextfield.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                    wheelnameinput = wheeltextfield.getText();
                } else {
                    label4.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    valid = false;
                }
                if (wheeltextfield2.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                    wheelparttype = wheeltextfield2.getText();
                } else {
                    label5.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    valid = false;
                }
                if (wheeltextfield3.getText().matches("[0-9]*")) {
                    wheelsize = Integer.parseInt(wheeltextfield3.getText());
                } else {
                    label6.setText("Feil input. Bruk siffer uten mellomrom.");
                    valid = false;
                }
                if (wheeltextfield4.getText().matches("[0-9]*")) {
                    wheelprice = Integer.valueOf(wheeltextfield4.getText());
                } else {
                    label7.setText("Feil input. Bruk siffer uten mellomrom.");
                    valid = false;
                }

                if (valid) {
                    Wheel w = tableviewheel.getSelectionModel().getSelectedItem();
                    for (Wheel wheel : this.globalwheels) {
                        if (w.getUUIDString() == wheel.getUUIDString()) {
                            wheel.setName(wheelnameinput);
                            wheel.setType(wheelparttype);
                            wheel.setSize(wheelsize);
                            wheel.setPrice(wheelprice);
                        }
                    }

                    File file = new File("wheels.jobj");
                    try (InputStream is = Files.newInputStream(Paths.get("wheels.jobj"), StandardOpenOption.READ);) {
                        ObjectInputStream ois = new ObjectInputStream(is);
                        ArrayList<Wheel> wheels = new ArrayList<Wheel>();
                        wheels = this.globalwheels;
                        task = new OpenWithThread("Wheel", file, wheels);
                        task.setOnSucceeded(this::ThreadOpenDone);
                        task.setOnFailed(this::ThreadOpenFailed);
                        Thread th = new Thread(task);
                        th.setDaemon(true);
                        DisableAll();
                        th.start();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                }
                wheeltextfield.clear();
                wheeltextfield2.clear();
                wheeltextfield3.clear();
                wheeltextfield4.clear();
                tableviewheel.getItems().clear();
                for (Wheel w : this.globalwheels) {
                    tableviewheel.getItems().add(w);
                }
            }

            @FXML
            void WheelDeleteAction (ActionEvent event){

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
            void WheelFilterAction (ActionEvent event){

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
                            for (Wheel w : beforefilter) {
                                if (w.getSize() == size) {
                                    afterfilter.add(w);
                                }
                            }
                            break;

                        case "Pris":
                            Integer price = Integer.parseInt(filtervar);
                            for (Wheel w : beforefilter) {
                                if (w.getPrice() == price) {
                                    afterfilter.add(w);
                                }
                            }
                            break;
                    }

                    if (!tableviewheel.getItems().isEmpty()) {
                        tableviewheel.getItems().clear();
                    }

                    for (Wheel w : afterfilter) {
                        tableviewheel.getItems().add(w);
                    }

                } catch (Exception e) {
                    // txtTelefonnummer.setText("Noe gikk feil: " + ioe.getMessage());
                }
            }

            private void loadDataWheel () {
                wheelchoiceboxlist.removeAll(wheelchoiceboxlist);
                String a = "Navn";
                String b = "Type";
                String c = "Størrelse";
                String d = "Pris";
                wheelchoiceboxlist.addAll(a, b, c, d);
                choiceboxwheel.getItems().addAll(wheelchoiceboxlist);
            }


            @FXML
            void ExtraInputAction (ActionEvent event){
                tableviewextra.getItems().clear();

                label1.setText(" ");
                label2.setText(" ");
                label3.setText(" ");

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
                        label1.setText("Feltet er tomt.");
                    }
                    if (extratextfield2.getText().isEmpty()) {
                        label2.setText("Feltet er tomt.");
                    }
                    if (extratextfield3.getText().isEmpty()) {
                        label3.setText("Feltet er tomt.");
                    }

                    if (extratextfield.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                        extrapartinput = extratextfield.getText();
                    } else {
                        value = false;
                        label1.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    }
                    if (extratextfield2.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                        extraparttype = extratextfield2.getText();
                    } else {
                        value = false;
                        label2.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    }
                    if (extratextfield3.getText().matches("[0-9]*")) {
                        price = Integer.parseInt(extratextfield3.getText());
                    } else {
                        value = false;
                        label3.setText("Feil input. Bruk siffer uten mellomrom.");
                    }

                    if (value) {

                        Accessory extra = new Accessory(extrapartinput, extraparttype, price);

                        File file = new File("accessories.jobj");

                        try (InputStream is = Files.newInputStream(Paths.get("accessories.jobj"), StandardOpenOption.READ);) {

                            ObjectInputStream ois = new ObjectInputStream(is);

                            ArrayList<Accessory> accessories = (ArrayList<Accessory>) ois.readObject();
                            accessories.add(extra);

                            task = new OpenWithThread("Accessory", file, accessories);
                            task.setOnSucceeded(this::ThreadOpenDone);
                            task.setOnFailed(this::ThreadOpenFailed);
                            Thread th = new Thread(task);
                            th.setDaemon(true);
                            DisableAll();
                            th.start();

                            this.globalaccessories = accessories;


                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {

                    }
                }
                extratextfield.clear();
                extratextfield2.clear();
                extratextfield3.clear();
                for (Accessory a : this.globalaccessories) {
                    tableviewextra.getItems().add(a);
                }

            }

            @FXML
            void ExtraChangeAction (ActionEvent event){
                Accessory a = tableviewextra.getSelectionModel().getSelectedItem();
                extratextfield.setText(a.getName());
                extratextfield2.setText(a.getDescription());
                String price = String.valueOf(a.getPrice());
                extratextfield3.setText(price);
            }

            @FXML
            void ExtraChangeActionUpdate (ActionEvent event){
                if (extratextfield.getText().isEmpty()) {
                    label1.setText("Feltet er tomt");
                }
                if (extratextfield2.getText().isEmpty()) {
                    label2.setText("Feltet er tomt");
                }
                if (extratextfield3.getText().isEmpty()) {
                    label3.setText("Feltet er tomt");
                }
                boolean valid = true;
                String extrapartinput = "";
                String extraparttype = "";
                Integer extraprice = 0;
                if (extratextfield.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                    extrapartinput = extratextfield.getText();
                } else {
                    label1.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    valid = false;
                }
                if (extratextfield2.getText().matches("[A-ZÆØÅa-zæøå]*")) {
                    extraparttype = extratextfield2.getText();
                } else {
                    label2.setText("Feil input. Bruk bokstaver uten mellomrom.");
                    valid = false;
                }
                if (extratextfield3.getText().matches("[0-9]*")) {
                    extraprice = Integer.parseInt(extratextfield3.getText());
                } else {
                    label3.setText("Feil input. Bruk siffer uten mellomrom.");
                    valid = false;
                }
                if (valid) {
                    Accessory a = tableviewextra.getSelectionModel().getSelectedItem();
                    for (Accessory accessory : this.globalaccessories) {
                        if (a.getUUIDString() == accessory.getUUIDString()) {
                            accessory.setName(extrapartinput);
                            accessory.setDescription(extraparttype);
                            accessory.setPrice(extraprice);
                        }
                    }
                    File file = new File("accessories.jobj");
                    try (InputStream is = Files.newInputStream(Paths.get("accessories.jobj"), StandardOpenOption.READ);) {
                        ObjectInputStream ois = new ObjectInputStream(is);
                        ArrayList<Accessory> accessories = new ArrayList<Accessory>();
                        accessories = this.globalaccessories;
                        task = new OpenWithThread("Accessory", file, accessories);
                        task.setOnSucceeded(this::ThreadOpenDone);
                        task.setOnFailed(this::ThreadOpenFailed);
                        Thread th = new Thread(task);
                        th.setDaemon(true);
                        DisableAll();
                        th.start();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                }
                extratextfield.clear();
                extratextfield2.clear();
                extratextfield3.clear();
                tableviewextra.getItems().clear();
                for (Accessory a : this.globalaccessories) {
                    tableviewextra.getItems().add(a);
                }

            }

            @FXML
            void ExtraDeleteAction (ActionEvent event){

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
            void ExtraFilterAction (ActionEvent event){
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
                            for (Accessory a : beforefilter) {
                                if (a.getPrice() == price) {
                                    afterfilter.add(a);
                                }
                            }
                            break;
                    }

                    if (!tableviewextra.getItems().isEmpty()) {
                        tableviewextra.getItems().clear();
                    }

                    for (Accessory a : afterfilter) {
                        tableviewextra.getItems().add(a);
                    }

                } catch (Exception e) {
                    // txtTelefonnummer.setText("Noe gikk feil: " + ioe.getMessage());
                }
            }

            private void loadDataExtra () {
                extrachoiceboxlist.removeAll(extrachoiceboxlist);
                String a = "Navn";
                String b = "Type";
                String c = "Pris";
                extrachoiceboxlist.addAll(a, b, c);
                choiceboxextra.getItems().addAll(extrachoiceboxlist);
            }


            @FXML
            void engineaction (ActionEvent event){
                if (event.getSource() == engineid) {
                    pane1id.toFront();
                }
            }

            @FXML
            void gearboxaction (ActionEvent event){
                if (event.getSource() == gearboxid) {
                    pane2id.toFront();
                }
            }

            @FXML
            void paintaction (ActionEvent event){
                if (event.getSource() == paintid) {
                    pane3id.toFront();
                }
            }

            @FXML
            void wheeilsaction (ActionEvent event){
                if (event.getSource() == wheelsid) {
                    pane4id.toFront();
                }
            }

            @FXML
            void extraaction (ActionEvent event){
                if (event.getSource() == extraid) {
                    pane5id.toFront();
                }
            }


            private void ThreadOpenDone (Event e){
                OpenAll();
            }

            private void ThreadOpenFailed (Event e){
                OpenAll();
            }

            private void OpenAll () {
                engineinputid.setDisable(false);
                enginechangeid1.setDisable(false);
                enginechangeid2.setDisable(false);
                gearboxinputid.setDisable(false);
                gearboxchangeid1.setDisable(false);
                gearboxchangeid2.setDisable(false);
                paintinputid.setDisable(false);
                paintchangeid1.setDisable(false);
                paintchangeid2.setDisable(false);
                wheelinputid.setDisable(false);
                wheelchangeid1.setDisable(false);
                wheelchangeid2.setDisable(false);
                extrainputid.setDisable(false);
                extrachangeid1.setDisable(false);
                extrachangeid2.setDisable(false);
            }

            private void DisableAll () {
                engineinputid.setDisable(true);
                enginechangeid1.setDisable(true);
                enginechangeid2.setDisable(true);
                gearboxinputid.setDisable(true);
                gearboxchangeid1.setDisable(true);
                gearboxchangeid2.setDisable(true);
                paintinputid.setDisable(true);
                paintchangeid1.setDisable(true);
                paintchangeid2.setDisable(true);
                wheelinputid.setDisable(true);
                wheelchangeid1.setDisable(true);
                wheelchangeid2.setDisable(true);
                extrainputid.setDisable(true);
                extrachangeid1.setDisable(true);
                extrachangeid2.setDisable(true);
            }


        }








