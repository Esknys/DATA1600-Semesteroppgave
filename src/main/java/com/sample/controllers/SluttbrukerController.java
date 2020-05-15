package com.sample.controllers;

import com.sample.App;
import com.sample.car.*;
import com.sample.textfile.CarFormatter;
import com.sample.textfile.FileReader;
import com.sample.textfile.FileSaver;
import com.sample.textfile.InvalidCarFormatException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import static javafx.scene.paint.Color.*;

public class SluttbrukerController {

    private Engine standardEngine = new Engine("Standard Motor", "Elektrisk", 500, 200000);
    private Gearbox standardGearbox = new Gearbox("Standard Girboks",30000, "Manuell");
    private Paintjob standardPaint = new Paintjob("Standard Maling", 10000, "Hvit", "Metallic");
    private Wheel standardWheel = new Wheel("Standard Hjul", "Lettmetall", 20, 20000);

    private ArrayList<Engine> engineArrayList = new ArrayList<>();
    private ArrayList<Gearbox> gearboxArrayList = new ArrayList<>();
    private ArrayList<Paintjob> paintjobArrayList = new ArrayList<>();
    private ArrayList<Wheel> wheelArrayList = new ArrayList<>();
    private ArrayList<Accessory> accessoryArrayList = new ArrayList<>();

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

    Car standardCar = new Car(standardEngine, standardGearbox, standardPaint, standardWheel);
    Car lastSelectedCar;
    Car currentConfiguringCar;

    int currentConfiguringCarIndex;

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
    private Label lblErrorMessage;

    @FXML
    private TilePane PartSelectorTilePane;

    @FXML
    private Button btnAddToConfiguration;

    @FXML
    private Label lblCurrentConfigCar;

    @FXML
    private Label lblCurrentConfigCarTitle;

    @FXML
    private Label lblCurrentConfigEngineTitle;

    @FXML
    private Label lblCurrentConfigEngine;

    @FXML
    private Label lblCurrentConfigGearboxTitle;

    @FXML
    private Label lblCurrentConfigGearbox;

    @FXML
    private Label lblCurrentConfigPaintjobTitle;

    @FXML
    private Label lblCurrentConfigPaintjob;

    @FXML
    private Label lblCurrentConfigWheelTitle;

    @FXML
    private Label lblCurrentConfigWheel;

    @FXML
    private Label lblCurrentConfigAccessoriesTitle;

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

        //Innlastning av deler fra serialisert fil

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


        try (InputStream is = Files.newInputStream(Paths.get("wheels.jobj"), StandardOpenOption.READ);) {

            ObjectInputStream ois = new ObjectInputStream(is);

            wheelArrayList = (ArrayList<Wheel>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (InputStream is = Files.newInputStream(Paths.get("accessories.jobj"), StandardOpenOption.READ);) {

            ObjectInputStream ois = new ObjectInputStream(is);

            accessoryArrayList = (ArrayList<Accessory>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //setter standardbilen til første mulige komponent
        standardCar.setEngine(standardEngine);
        standardCar.setGearbox(standardGearbox);
        standardCar.setPaintjob(standardPaint);
        standardCar.setWheel(standardWheel);

        //Innlastning av bil-konfigurasjoner fra fil

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


        //Legger til funksjonen updateCurretPartInfo som Listener til endringer i togglegroupen, så info om delene oppdateres
        partToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (partToggleGroup.getSelectedToggle() != null) {
                    updateCurrentPartInfo(partToggleGroup.getSelectedToggle().getUserData().toString());
                }

            }
        });

        //Legger til funksjonen updateCurrentCarInfo som Listener til endringer i togglegroupen, så info om delene oppdateres


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
        if (currentConfiguringCar == null) {
            lblErrorMessage.setText("Ingen bil er valgt");
        } else if (partToggleGroup.getSelectedToggle() == null) {
            lblErrorMessage.setText("Ingen del er valgt");
        } else {
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
        //Legger til en ny bil med standard Konfigurasjon
        carArrayList.add(standardCar);
        //Oppdaterer radio-buttons
        clearRadioButtonTilePane();
        fillRadioButtonTilePaneWithCarConfigurations(carArrayList);
    }

    @FXML
    void selectCar(ActionEvent event) {
        currentConfiguringCar = findCarInCarArrayListAndUpdateIndex(carToggleGroup.getSelectedToggle().getUserData().toString());
        lastSelectedCar = findCarInCarArrayListAndUpdateIndex(carToggleGroup.getSelectedToggle().getUserData().toString());
        updateCurrentConfiguration();
    }

    @FXML
    void deleteSelectedCar(ActionEvent event) throws InvalidCarFormatException {
        Car selectedCar;
        selectedCar = findCarInCarArrayListAndUpdateIndex(carToggleGroup.getSelectedToggle().getUserData().toString());
        carArrayList.remove(selectedCar);

        //lagrer til fil og laster inn igjen

        FileReader fileReader = new FileReader();
        File file = new File("carregister.txt");

        try {

            //formaterer hele listen med biler
            String formatted = CarFormatter.formatCarArrayList(carArrayList);
            //lagrer hele listen til fil
            FileSaver.save(formatted, file);
            //henter opp igjen listen fra fil
            ArrayList<Car> cars = fileReader.readCars(file);
            carArrayList = cars;

        } catch(IOException ioe) {
            throw new InvalidCarFormatException("Feil bilformat");
        }

        //Oppdaterer radiobuttons
        clearRadioButtonTilePane();
        fillRadioButtonTilePaneWithCarConfigurations(carArrayList);


    }

    @FXML
    void saveConfiguration(ActionEvent event) throws IOException {
        //Sjekker om bil er valgt før det evt. lagres
        if (currentConfiguringCar == null) {
            lblErrorMessage.setText("Ingen bil er valgt");
        } else {
            FileReader fileReader = new FileReader();
            File file = new File("carregister.txt");
            //legger til konfigurerende bil til listen
            carArrayList.add(currentConfiguringCar);
            //Fjerner bilen som har blitt endret
            carArrayList.remove(lastSelectedCar);

            try {

                //formaterer hele listen med biler
                String formatted = CarFormatter.formatCarArrayList(carArrayList);
                //lagrer hele listen til fil
                FileSaver.save(formatted, file);
                //henter opp igjen listen fra fil
                ArrayList<Car> cars = fileReader.readCars(file);
                carArrayList = cars;
                lblErrorMessage.setTextFill(BLACK);
                lblErrorMessage.setText("Bilkonfigurasjon lagret");

            } catch(IOException ioe) {
                throw new InvalidCarFormatException("Feil bilformat");
            }
        }


    }

    public void updateCurrentConfiguration() {
        lblCurrentConfigCar.setText("Total pris: " + currentConfiguringCar.getPriceFormatted() + ",-");
        lblCurrentConfigEngine.setText(currentConfiguringCar.getEngine().toStringFormatted());
        lblCurrentConfigGearbox.setText(currentConfiguringCar.getGearbox().toStringFormatted());
        lblCurrentConfigPaintjob.setText(currentConfiguringCar.getPaintjob().toStringFormatted());
        lblCurrentConfigWheel.setText(currentConfiguringCar.getWheel().toStringFormatted());
        lblCurrentConfiguration.setText(currentConfiguringCar.formatAccessories());
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
            radioButton.setText(c.getPriceFormatted() + ",-" + "\n" + c.getEngine().getName() + "\n" + c.getGearbox().getName() + "\n" + c.getPaintjob().getName() + "\n" + c.getWheel().getName());
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

        Car currentCar = findCarInCarArrayListAndUpdateIndex(UUID);

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

    public Car findCarInCarArrayListAndUpdateIndex(String UUIDString) {
        Car returningCar = null;
        currentConfiguringCarIndex = -1;
        for (Car c : carArrayList) {
            currentConfiguringCarIndex++;
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

    public void clearErrorMessage() {
        lblErrorMessage.setText("");
        lblErrorMessage.setTextFill(RED);
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
                clearErrorMessage();
                break;

            case ENGINE:
                setTitle("MOTOR");
                enableAllSceneButtons();
                BtnEngineScene.setDisable(true);
                clearCurrentPartInfo();
                lblSelectPart.setText("Velg motordel");
                lblPartInfoTitle.setText("Del-info");
                btnBarCarConfigs.setVisible(false);
                clearErrorMessage();


                break;

            case GEARBOX:
                setTitle("GIRKASSE");
                enableAllSceneButtons();
                BtnGearboxScene.setDisable(true);
                clearCurrentPartInfo();
                lblSelectPart.setText("Velg girkasse");
                lblPartInfoTitle.setText("Del-info");
                btnBarCarConfigs.setVisible(false);
                clearErrorMessage();


                break;

            case PAINTJOB:
                setTitle("MALINGSFARGE");
                enableAllSceneButtons();
                BtnPaintjobScene.setDisable(true);
                clearCurrentPartInfo();
                lblSelectPart.setText("Velg farge");
                lblPartInfoTitle.setText("Fargeinfo");
                btnBarCarConfigs.setVisible(false);
                clearErrorMessage();


                break;

            case WHEEL:
                setTitle("HJUL");
                enableAllSceneButtons();
                BtnWheelScene.setDisable(true);
                clearCurrentPartInfo();
                lblSelectPart.setText("Velg hjul");
                lblPartInfoTitle.setText("Hjulinfo");
                btnBarCarConfigs.setVisible(false);
                clearErrorMessage();


                break;

            case ACCESSORY:
                setTitle("EKSTRAUTSTYR");
                enableAllSceneButtons();
                BtnAccessoryScene.setDisable(true);
                clearCurrentPartInfo();
                lblSelectPart.setText("Velg ekstrautstyr");
                lblPartInfoTitle.setText("Ekstrautstyrinfo");
                btnBarCarConfigs.setVisible(false);
                clearErrorMessage();


                break;
        }
    }

}
