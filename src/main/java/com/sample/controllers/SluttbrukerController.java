package com.sample.controllers;

import com.sample.App;
import com.sample.binaryfile.WriteEngines;
import com.sample.binaryfile.WriteGearboxes;
import com.sample.binaryfile.WritePaintjobs;
import com.sample.car.*;
import com.sample.textfile.CarFormatter;
import com.sample.textfile.FileReader;
import com.sample.textfile.FileSaver;
import com.sample.textfile.InvalidCarFormatException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class SluttbrukerController {

    //konstruerer deler pga mangel av innlastning fra fil
    private Engine electric = new Engine("Electroman", "Electric", 500, 200000);
    private Engine diesel = new Engine("Diesel 200x","Diesel", 200, 150000);

    private Gearbox manual = new Gearbox("Oldschool",30000, "Manual transmission");
    private Gearbox automatic = new Gearbox("Super auto shifter", 40000, "Automatic transmission");

    private Paintjob paint1 = new Paintjob("White cream", 10000, "White", "Metallic");
    private Paintjob paint2 = new Paintjob("Night black", 15000, "Black", "Metallic");

    private Wheel wheel1 = new Wheel("Sport", "Lettmetall", 20, 20000);
    private Wheel wheel2 = new Wheel("Offroad", "Metall", 22, 23000);

    private Accessory accessory1 = new Accessory("GPS 2.0", "Beste gps som finnes på markedet!", 10000);
    private Accessory accessory2 = new Accessory("Skinnseter", "Oppgraderte seter i ekte skinn", 20000);

    private ArrayList<Engine> engineArrayList = new ArrayList<>();
    private ArrayList<Gearbox> gearboxArrayList = new ArrayList<>();
    private ArrayList<Paintjob> paintjobArrayList = new ArrayList<>();
    private ArrayList<Wheel> wheelArrayList = new ArrayList<>();
    private ArrayList<Accessory> accessoryArrayList = new ArrayList<>();

    Car testCar1 = new Car(diesel, manual, paint1, wheel1);
    Car testCar2 = new Car(electric, automatic, paint2, wheel2);



    private ArrayList<Car> carArrayList = new ArrayList<>();

    //ENUM
    private enum PartType {
        OVERVEIW,
        ENGINE,
        GEARBOX,
        PAINTJOB,
        WHEEL,
        ACCESSORY
    }

    PartType currentPartType = PartType.OVERVEIW;

    //Groups the parts so you can only select one at the time
    ToggleGroup partToggleGroup = new ToggleGroup();
    ToggleGroup carToggleGroup = new ToggleGroup();

    Car currentConfiguringCar = new Car(electric, manual, paint1, wheel2);

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Label LblTitle;

    @FXML
    private ButtonBar UIButtonbar;

    @FXML
    private ButtonBar btnBarCarConfigs;

    @FXML
    private Button BtnOverviewScene;

    @FXML
    private Button BtnEngineScene;

    @FXML
    private Button BtnGearboxScene;

    @FXML
    private Button BtnPaintjobScene;

    @FXML
    private Button BtnWheelScene;

    @FXML
    private Button BtnAccessoryScene;

    @FXML
    private Label lblSelectPart;

    @FXML
    private Label lblPartInfoTitle;

    @FXML
    private Label lblPartInfo;

    @FXML
    private TilePane PartSelectorTilePane;

    @FXML
    private Button btnAddToConfiguration;

    @FXML
    private Label lblCurrentConfiguration;

    @FXML
    private Button backbutton;

    @FXML
    void backtomainviewid(ActionEvent event) throws IOException {
        App.changeView("mainview.fxml");
    }


    @FXML
    public void initialize() {
        //fyller arrays for testing

        wheelArrayList.add(wheel1);
        wheelArrayList.add(wheel2);

        accessoryArrayList.add(accessory1);
        accessoryArrayList.add(accessory2);


        try (InputStream is = Files.newInputStream(Paths.get("engines.jobj"), StandardOpenOption.READ);) {

            ObjectInputStream ois = new ObjectInputStream(is);

            engineArrayList = (ArrayList<Engine>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (InputStream is = Files.newInputStream(Paths.get("gearboxes.jobj"), StandardOpenOption.READ);) {

            ObjectInputStream ois = new ObjectInputStream(is);

            gearboxArrayList = (ArrayList<Gearbox>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (InputStream is = Files.newInputStream(Paths.get("paintjobs.jobj"), StandardOpenOption.READ);) {

            ObjectInputStream ois = new ObjectInputStream(is);

            paintjobArrayList = (ArrayList<Paintjob>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        FileReader fileReader = new FileReader();

        File file = new File("carregister.txt");

        ArrayList<Car> cars = new ArrayList<>();

        try {
            cars = fileReader.readCars(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        carArrayList = cars;


        //carArrayList.add(testCar1);
        //carArrayList.add(testCar2);


        //Legger til funksjonen updateCurretPartInfo som Listner til togglegroupen, så info om delene oppdateres
        partToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (partToggleGroup.getSelectedToggle() != null) {
                    updateCurrentPartInfo(partToggleGroup.getSelectedToggle().getUserData().toString());
                }

            }
        });

        carToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (carToggleGroup.getSelectedToggle() != null) {
                    updateCurrentCarInfo(carToggleGroup.getSelectedToggle().getUserData().toString());
                }

            }
        });

        currentPartType = PartType.OVERVEIW;
        updateTitleAndWidowButtons();
        fillRadioButtonTilePaneWithCarConfigurations(carArrayList);

        System.out.println("Initialized");
    }

    @FXML
    void AddSelectedPart(ActionEvent event) {
        if (partToggleGroup.getSelectedToggle() != null) {
            String selectedPartUUID = (String) partToggleGroup.getSelectedToggle().getUserData();
            Part selectedPart = findPartInPartArrayLists(selectedPartUUID);

            switch(currentPartType) {
                case OVERVEIW:
                    break;

                case ENGINE:
                    currentConfiguringCar.setEngine((Engine) selectedPart);
                    break;

                case GEARBOX:
                    currentConfiguringCar.setGearbox((Gearbox) selectedPart);
                    break;

                case PAINTJOB:
                    currentConfiguringCar.setPaintjob((Paintjob) selectedPart);
                    break;

                case WHEEL:
                    currentConfiguringCar.setWheel((Wheel)selectedPart);
                    break;

                case ACCESSORY:
                    currentConfiguringCar.addAccessory((Accessory)selectedPart);

            }

        }
        updateCurrentConfiguration();

    }

    @FXML
    void newCar(ActionEvent event) {

    }

    @FXML
    void selectCar(ActionEvent event) {
        currentConfiguringCar = findCarInCarArrayList(carToggleGroup.getSelectedToggle().getUserData().toString());
        updateCurrentConfiguration();
    }

    @FXML
    void saveConfiguration(ActionEvent event) throws IOException {

        FileReader fileReader = new FileReader();
        File file = new File("carregister.txt");

       try {

           String formatted = CarFormatter.formatCar(currentConfiguringCar);
           FileSaver.save(formatted, file);
           ArrayList<Car> cars = fileReader.readCars(file);
           carArrayList = cars;

       } catch(IOException ioe) {
           throw new InvalidCarFormatException("Feil bilformat");
       }

    }

    public void updateCurrentConfiguration() {
        lblCurrentConfiguration.setText(currentConfiguringCar.toString());
    }

    @FXML
    void showOverviewScene(ActionEvent event) {

        currentPartType = PartType.OVERVEIW;
        updateTitleAndWidowButtons();

        clearRadioButtonTilePane();
        fillRadioButtonTilePaneWithCarConfigurations(carArrayList);


    }

    @FXML
    void showEngineScene(ActionEvent event) {

        currentPartType = PartType.ENGINE;
        updateTitleAndWidowButtons();

        clearRadioButtonTilePane();
        fillRadioButtonTilePaneWithParts(engineArrayList);

    }

    @FXML
    void showGearboxScene(ActionEvent event) {

        currentPartType = PartType.GEARBOX;
        updateTitleAndWidowButtons();

        clearRadioButtonTilePane();
        fillRadioButtonTilePaneWithParts(gearboxArrayList);
    }

    @FXML
    void showPaintjobScene(ActionEvent event) {

        currentPartType = PartType.PAINTJOB;
        updateTitleAndWidowButtons();

        clearRadioButtonTilePane();
        fillRadioButtonTilePaneWithParts(paintjobArrayList);
    }

    @FXML
    void showWheelScene(ActionEvent event) {
        currentPartType = PartType.WHEEL;
        updateTitleAndWidowButtons();

        clearRadioButtonTilePane();
        fillRadioButtonTilePaneWithParts(wheelArrayList);
    }

    @FXML
    void showAccessoryScene(ActionEvent event) {
        currentPartType = PartType.ACCESSORY;
        updateTitleAndWidowButtons();

        clearRadioButtonTilePane();
        fillRadioButtonTilePaneWithParts(accessoryArrayList);
    }


    public void fillRadioButtonTilePaneWithParts(ArrayList<? extends Part> partArrayList) {

        for (Part p : partArrayList) {
            RadioButton radioButton = new RadioButton();
            radioButton.setText(p.getName() + "\n" + p.getPriceFormatted() + ",-");
            radioButton.setPadding(new Insets(5, 25, 5, 25));
            radioButton.setUserData(p.getUUIDString());
            radioButton.setToggleGroup(partToggleGroup);

            PartSelectorTilePane.getChildren().add(radioButton);
        }


    }

    public void fillRadioButtonTilePaneWithCarConfigurations(ArrayList<Car> carArrayList) {

        for (Car c : carArrayList) {
            RadioButton radioButton = new RadioButton();
            radioButton.setText(c.getPriceFormatted() + ",-" + "\n" + c.getEngine().getName() + "\n" + c.getGearbox().getName() + "\n" + c.getPaintjob().getName());
            radioButton.setPadding(new Insets(5, 25, 5, 25));
            radioButton.setUserData(c.getUUIDString());

            radioButton.setToggleGroup(carToggleGroup);

            PartSelectorTilePane.getChildren().add(radioButton);
        }


    }

    public void updateCurrentPartInfo(String UUID) {

        Part currentPart = findPartInPartArrayLists(UUID);

        lblPartInfo.setText(currentPart.toStringFormatted());
    }

    public void updateCurrentCarInfo(String UUID) {

        Car currentCar = findCarInCarArrayList(UUID);

        lblPartInfo.setText(currentCar.toString());
    }

    public void clearCurrentPartInfo() {
        lblPartInfo.setText("");
    }

    public void clearRadioButtonTilePane(){
        PartSelectorTilePane.getChildren().clear();
    }


    public Part findPartInPartArrayLists(String UUIDString) {
        Part returningPart = null;
        for (Part p : engineArrayList) {
            if (p.getUUIDString() == UUIDString) {
                returningPart = p;
            }
        }
        for (Part p : gearboxArrayList) {
            if (p.getUUIDString() == UUIDString) {
                returningPart = p;
            }
        }
        for (Part p : paintjobArrayList) {
            if (p.getUUIDString() == UUIDString) {
                returningPart = p;
            }
        }
        for (Part p : wheelArrayList) {
            if (p.getUUIDString() == UUIDString) {
                returningPart = p;
            }
        }
        for (Part p : accessoryArrayList) {
            if (p.getUUIDString() == UUIDString) {
                returningPart = p;
            }
        }
        return returningPart;
    }

    public Car findCarInCarArrayList(String UUIDString) {
        Car returningCar = null;
        for (Car c : carArrayList) {
            if (c.getUUIDString() == UUIDString) {
                returningCar = c;
            }
        }
        return returningCar;
    }

    public void enableAllSceneButtons() {
        BtnOverviewScene.setDisable(false);
        BtnEngineScene.setDisable(false);
        BtnGearboxScene.setDisable(false);
        BtnPaintjobScene.setDisable(false);
        BtnWheelScene.setDisable(false);
        BtnAccessoryScene.setDisable(false);
        btnAddToConfiguration.setVisible(true);

    }

    public void setTitle(String title) {
        LblTitle.setText(title);
    }

    public void updateTitleAndWidowButtons() {
        switch(currentPartType) {
            case OVERVEIW:
                setTitle("OVERSIKT");
                enableAllSceneButtons();
                BtnOverviewScene.setDisable(true);
                btnAddToConfiguration.setVisible(false);
                clearCurrentPartInfo();
                lblSelectPart.setText("Velg bilkonfigurasjon");
                lblPartInfoTitle.setText("Bil info");
                btnBarCarConfigs.setVisible(true);
                break;

            case ENGINE:
                setTitle("MOTOR");
                enableAllSceneButtons();
                BtnEngineScene.setDisable(true);
                clearCurrentPartInfo();
                lblSelectPart.setText("Velg motordel");
                lblPartInfoTitle.setText("Del-info");
                btnBarCarConfigs.setVisible(false);


                break;

            case GEARBOX:
                setTitle("GIRKASSE");
                enableAllSceneButtons();
                BtnGearboxScene.setDisable(true);
                clearCurrentPartInfo();
                lblSelectPart.setText("Velg girkasse");
                lblPartInfoTitle.setText("Del-info");
                btnBarCarConfigs.setVisible(false);


                break;

            case PAINTJOB:
                setTitle("MALINGSFARGE");
                enableAllSceneButtons();
                BtnPaintjobScene.setDisable(true);
                clearCurrentPartInfo();
                lblSelectPart.setText("Velg farge");
                lblPartInfoTitle.setText("Fargeinfo");
                btnBarCarConfigs.setVisible(false);


                break;

            case WHEEL:
                setTitle("Wheels");
                enableAllSceneButtons();
                BtnWheelScene.setDisable(true);
                clearCurrentPartInfo();
                lblSelectPart.setText("Select part");
                lblPartInfoTitle.setText("Part info");
                btnBarCarConfigs.setVisible(false);


                break;

            case ACCESSORY:
                setTitle("Accessories");
                enableAllSceneButtons();
                BtnAccessoryScene.setDisable(true);
                clearCurrentPartInfo();
                lblSelectPart.setText("Select part");
                lblPartInfoTitle.setText("Part info");
                btnBarCarConfigs.setVisible(false);


                break;
        }
    }

}
