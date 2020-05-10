package com.sample.controllers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import com.sample.App;
import com.sample.binaryfile.*;
import com.sample.car.Engine;
import com.sample.car.Gearbox;
import com.sample.car.Paintjob;
import com.sample.car.Wheel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private Label labelengine;


    @FXML
    private TableView<?> tableviewengine;

    @FXML
    private TableColumn<?, ?> enginecol1;

    @FXML
    private TableColumn<?, ?> enginecol2;

    @FXML
    private TableColumn<?, ?> enginecol3;

    @FXML
    private TableColumn<?, ?> enginecol4;


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
    private Label labelgearbox;

    @FXML
    private TableView<?> tableviewgearbox;

    @FXML
    private TableColumn<?, ?> gearboxcol1;

    @FXML
    private TableColumn<?, ?> gerboxcol2;

    @FXML
    private TableColumn<?, ?> gearboxcol3;

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
    private Label labelpaint;

    @FXML
    private TableView<?> tableviewpaint;

    @FXML
    private TableColumn<?, ?> paintcol1;

    @FXML
    private TableColumn<?, ?> paintcol2;

    @FXML
    private TableColumn<?, ?> paintcol3;

    @FXML
    private TableColumn<?, ?> paintcol4;

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
    private Button wheelinputid;

    @FXML
    private Label labelwheel;

    @FXML
    private TableView<?> tableviewheel;

    @FXML
    private TableColumn<?, ?> wheelcol1;

    @FXML
    private TableColumn<?, ?> wheelcol2;

    @FXML
    private TableColumn<?, ?> wheelcol3;

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
    private Label labelextra;

    @FXML
    private TableView<?> tableviewextra;

    @FXML
    private TableColumn<?, ?> extracol1;

    @FXML
    private TableColumn<?, ?> extracol2;

    @FXML
    private TableColumn<?, ?> extracol3;

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
        String engineinput = enginetextfield.getText();
        String fuelinput = fueltextfield.getText();
        String horsepowerinput = horsepowertextfield.getText();
        String priceinput = pricetextfield.getText();

        int hp = Integer.parseInt(horsepowerinput);
        int price = Integer.parseInt(priceinput);

        Engine engine = new Engine(engineinput, fuelinput, hp, price);

        File file = new File("engines.jobj");

        try (InputStream is = Files.newInputStream(Paths.get("engines.jobj"), StandardOpenOption.READ);) {

            ObjectInputStream ois = new ObjectInputStream(is);

            ArrayList<Engine> engines = (ArrayList<Engine>) ois.readObject();

            engines.add(engine);
            WriteEngines.write(file, engines);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void GearboxInputAction(ActionEvent event) {
        String gearboxinput = gearboxtextfield.getText();
        String typeinput = gearboxtextfield2.getText();
        String priceinput = gearboxtextfield3.getText();

        int price = Integer.parseInt(priceinput);

        Gearbox gearbox = new Gearbox(gearboxinput, price, typeinput);

        File file = new File("gearboxes.jobj");

        try (InputStream is = Files.newInputStream(Paths.get("gearboxes.jobj"), StandardOpenOption.READ);) {

            ObjectInputStream ois = new ObjectInputStream(is);

            ArrayList<Gearbox> gearboxes = (ArrayList<Gearbox>) ois.readObject();

            gearboxes.add(gearbox);
            WriteGearboxes.write(file, gearboxes);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

}

    @FXML
    void PaintInputAction(ActionEvent event) {
        String paintinput = painttextfield.getText();
        String paintcolor = painttextfield2.getText();
        String painttype = painttextfield3.getText();
        String paintprice = painttextfield4.getText();

        int price = Integer.parseInt(paintprice);

        Paintjob paintjob = new Paintjob(paintinput, price, paintcolor, painttype);

        File file = new File("paintjobs.jobj");

        try (InputStream is = Files.newInputStream(Paths.get("paintjobs.jobj"), StandardOpenOption.READ);) {

            ObjectInputStream ois = new ObjectInputStream(is);

            ArrayList<Paintjob> paintjobs = (ArrayList<Paintjob>) ois.readObject();

            paintjobs.add(paintjob);
            WritePaintjobs.write(file, paintjobs);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void ExtraInputAction(ActionEvent event) {
        String extrapartinput = extratextfield.getText();
        String extraparttype = extratextfield2.getText();
        String extrapartprice = extratextfield3.getText();
        labelextra.setText("Navnet på ekstradelen du har lagt til er"  + extrapartinput + ". Navnet på hva slags" +
                "type det er, er " + extraparttype + ". Prisen på delen er " + extrapartprice);
    }

    @FXML
    void WheelInputAction(ActionEvent event) {
        String wheelpartinput = wheeltextfield.getText();
        String wheeltype = wheeltextfield2.getText();
        String wheelprice = wheeltextfield3.getText();

        int wp = Integer.parseInt(wheelprice);

        Wheel wheel = new Wheel()

    }

    // Når denne knappen trykkes, skal alle motorene som finnes lastes opp
    @FXML
    void engineaction(ActionEvent event) {
        if (event.getSource() == engineid) {
            pane1id.toFront();
            labelengine.setText("Her skal det komme de eksisterende motorene");
        }
    }

    @FXML
    void extraaction(ActionEvent event) {
        if (event.getSource() == extraid) {
            pane5id.toFront();
            labelextra.setText("Her skal det komme de eksisterende ekstrautstyret");
        }
    }

    @FXML
    void gearboxaction(ActionEvent event) {
        if (event.getSource() == gearboxid) {
            pane2id.toFront();
            labelgearbox.setText("Her skal det komme de eksisterende girkassene");
        }
    }

    @FXML
    void paintaction(ActionEvent event) {
        if (event.getSource() == paintid) {
            pane3id.toFront();
            labelpaint.setText("Her skal det komme de eksisterende malingsfargene");
        }
    }

    @FXML
    void wheeilsaction(ActionEvent event) {
        if (event.getSource() == wheelsid) {
            pane4id.toFront();
            labelwheel.setText("Her skal det komme de hjulene");
        }
    }



}
